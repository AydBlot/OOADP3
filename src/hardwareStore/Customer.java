package hardwareStore;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public abstract class Customer implements Observer
{
	public String name;
	protected Store store;
	protected ArrayList<RentalRecord> orderList;
	
	// The max tools a customer can have rented out
	protected final static int MAX_RENTALS = 3;
	
	// The % chance that a customer goes to the store if they can go
	protected final static double CHANCE_GOES_TO_STORE = 0.2;
	
	public Customer(String name, Store store)
	{
		this.name = name;
		this.store = store;
		store.addObserver(this);
		this.orderList = new ArrayList<RentalRecord>();
	}	

	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Determines whether a customer can go in to the store to rent something.
	 * @return True if the store has enough inventory and the customer hasn't reached their max rentals
	 */
	protected abstract boolean canRent();
	
	protected boolean willRent()
	{
		return Math.random() <= CHANCE_GOES_TO_STORE;
	}
	
	/**
	 * Generate the number of tools to rent for a given rental. 
	 * Varies depending on customer type.
	 * @return The number of tools to rent.
	 */
	protected abstract int howMany();
	
	
	/**
	 * Generate the number of days that a rental will last.
	 * Varies depending no customer type.
	 * @return The number of days to rent for.
	 */
	protected abstract int howLong();
	
	
	/**
	 * Generates the number of options to add.
	 * @return A 
	 */
	protected int numOptions()
	{
		int num = (int)(Math.random() * 7);
		return num;
	}
	
	
	/**
	 * Creates a Rental Record with the items and options that the customer rents.
	 * @param currentDay The current day of the simulation
	 * @return The generated Rental Record.
	 */
	protected final RentalRecord generateRental(int currentDay)
	{
		
		// First, determine how many tools the customer will rent
		int numTools = this.howMany();
		
		// The tools and options to rent
		ArrayList<RentalOption> options = new ArrayList<RentalOption>();
		ArrayList<Tool> tools = new ArrayList<Tool>();
		
		// The customer's store's current inventory
		ArrayList<Tool> storeInventory = store.getInventory();
		
		// Add tools to the rental
		for(int t = 1; t <= numTools; t++)
		{
			int numOptions = this.numOptions();
			tools.add(storeInventory.get(storeInventory.size() - t));
			for(int o = 0; o < numOptions; o++)
			{
				RentalOption opt = RentalOption.getRandomRentalOption();
				options.add(opt);
			}
		}
		
		// Create and return a rental record
		RentalRecord rental = new RentalRecord(tools, options, this.howLong(), currentDay);
		return rental;
		
		
	}
	
	
	/**
	 * @return The number of tools that the customer currently has rented out
	 */
    protected int getNumToolsRented()
    {
    	int total = 0;
    	for(RentalRecord rental : orderList)
    	{
    		total += rental.getRentedTools().size();
    	}
    	return total;
    }
    
    
    /**
     * Runs a day for the customer. If they decide to rent tools that day,
     * generates the rental and passes it to the customer's store.
     * @param currentDay The current day of the simulation.
     */
    public void runDay(int currentDay)
	{
    	if(canRent() && willRent())
		{
			// Determine if we are going to go to the store
			// If we go to the store, generate a rental
			RentalRecord rental = generateRental(currentDay);
			
			System.out.println(getName() + " rents " + rental.getRentedTools().size() + " tool(s) for " + rental.getRentalLength() + " day(s).");
			
			// Pass the rental to the store 
			store.startRental(rental);
				
			// Add the rental to the customer's order list
			this.orderList.add(rental);
		}
		
	}
    
    
    /**
     * Returns the tools from a Rental Record to the store.
     * @param record The Rental Record being returned.
     */
    private void returnTools(RentalRecord record)
    {
    	int toolsRented = record.getRentedTools().size();
    	if(toolsRented == 1)
    	{
    		System.out.println(this.getName() + " returns " + toolsRented + " tool.");
    	}
    	else
    	{
    		System.out.println(this.getName() + " returns " + toolsRented + " tools.");
    	}

		store.processReturn(record);
    }
    
    public void update(Observable obj, Object arg)
    {
    	RentalRecord toReturn = (RentalRecord)arg;
    	if(orderList.remove(toReturn))
    	{
	    	returnTools(toReturn);
    	}
    }
}

package hardwareStore;

import java.util.ArrayList;

/**
 * A World contains Customers and Stores and 
 * handles running a simulation for a given number of days.
 * 
 * Implements the Singleton pattern - there can only be one World in a program
 * which is created/accessed using the getTheWorld function.
 * 
 * @author Alex
 *
 */
public class World 
{
	private static World theWorld;
	private int stagedDay;
	private ArrayList<Store> stores;
	private ArrayList<Customer> customers;
	
	private World()
	{
		stores = new ArrayList<Store>();
		customers = new ArrayList<Customer>();
		stagedDay = 1;
	}
	
	/** 
	 * Increment the current day then run through the logic for stores and customers for each day
	 */
	public void startNewDay()
	{
		if(stagedDay != 1)
		{
			System.out.println("\n---------------\n");
		}
		else
		{
			System.out.println("\n");
		}
		
		System.out.println("Cue the sun. Day " + stagedDay + " is starting now.");
		
		// Loop through each store
		for (Store store : stores)
		{
			// Check if they have any due rentals and notify customers
			store.checkRentalRecords(stagedDay);
		}

		// Now, loop through each customer and have them run through their day
		for(Customer customer: customers)
		{
			customer.runDay(stagedDay);
		}
		
		// Stage the next day by incrementing the day counter
		stagedDay++;
	}
	
	/**
	 * Run the simulation for a given number of days. This calls the
	 * startNewDay function days number of times. If run multiple times, 
	 * will continue
	 * @param days The number of days to run the simulation for.
	 */
	public void runSimulation(int days)
	{
		int startDay = stagedDay;
		while(stagedDay - startDay < days)
		{
			startNewDay();
		}
		
		System.out.println("\n---------------\n");
		
		for(Store s : stores)
		{
			int total = s.calculateTotalSales();
			
			System.out.println("Cha-ching! " + s.getName() + " made a total of: $" + total);
		}
	}
	
	public void addStore(Store s)
	{
		stores.add(s);
	}
	
	public void addCustomer(Customer c)
	{
		customers.add(c);
	}
	
	public int getStagedDay() {
		return this.stagedDay;
	}
	
	public ArrayList<Customer> getCustomers() {
		return this.customers;
	}
	
	public ArrayList<Store> getStores() {
		return this.stores;
	}
	
	public static World getTheWorld()
	{
		if(theWorld == null)
		{
			theWorld = new World();
		}
		
		return theWorld;
	}
	
}

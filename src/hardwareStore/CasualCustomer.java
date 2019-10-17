package hardwareStore;

/**
 * A casual customer rents 1-2 tools for 1-2 days.
 * 
 * @author Lucas
 *
 */
public class CasualCustomer extends Customer
{
	private final static int MAX_RENTALS_CASUAL = 2;
	
	public CasualCustomer(String name, Store store)
	{
		super(name, store);
	}
	
	public int getType() {
		return CustomerType.CASUAL;
	}
	
	public int howMany()
	{
		int maxTools = Math.min(store.getInventory().size(), MAX_RENTALS - getNumToolsRented());
		maxTools = Math.min(MAX_RENTALS_CASUAL, maxTools);

		int numTools = (int)(Math.random() * maxTools) + 1;
		
		return numTools;
	}
	
	public int howLong()
	{
		// Rent for [1, 2] days
		int days = (int)(Math.random() * 2) + 1;
		return days;
	}
	
	protected boolean canRent()
	{
		// Rent if the store has at least 1 tool in inventory and the customer has less than 3 tools rented
		return (store.getInventory().size() != 0) && (getNumToolsRented() < MAX_RENTALS);
	}
}

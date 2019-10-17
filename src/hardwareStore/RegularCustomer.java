package hardwareStore;

/**
 * A Regular customer rents 1-3 tools for 3-5 days.
 * 
 * @author Lucas
 *
 */
public class RegularCustomer extends Customer
{
	private final static int MAX_RENTALS_REGULAR = 3;
	
	public RegularCustomer(String name, Store store)
	{
		super(name,store);
	}
	
	public int getType() {
		return CustomerType.REGULAR;
	}

	public int howMany()
	{
		int maxTools = Math.min(store.getInventory().size(), MAX_RENTALS - getNumToolsRented());
		maxTools = Math.min(MAX_RENTALS_REGULAR, maxTools);

		int numTools = (int)(Math.random() * maxTools) + 1;
		
		return numTools;
	}
	
	public int howLong()
	{
		// [3, 5] days
		int days = 3 + (int)(Math.random() * 3);
		return days;
	}
	
	protected boolean canRent()
	{
		// Rent if the store has at least 1 tool in inventory and the customer has less than 3 tools rented
		return (store.getInventory().size() != 0) && (getNumToolsRented() < MAX_RENTALS);
	}
}

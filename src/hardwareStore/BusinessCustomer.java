package hardwareStore;

/**
 * A business customer always rents 3 items for 7 days.
 * 
 * @author Lucas
 *
 */
public class BusinessCustomer extends Customer
{
	public BusinessCustomer(String name, Store store)
	{
		super(name,store);
	}
	
	public int getType() {
		return CustomerType.BUSINESS;
	}

	protected boolean canRent()
	{
		// Only rent if the store has at least 3 items in inventory and the customer has less than 3 tools rented
		return (store.getInventory().size() >= 3) && (getNumToolsRented() < MAX_RENTALS);
	}
	
	protected int howLong()
	{
		// Business customers always rent for 7 days
		return 7;
	}
	
	protected int howMany()
	{
		// Business customers always rent 3 tools
		return 3;
	}
}

package hardwareStore;
import java.util.ArrayList;
// Template pattern reference: https://www.tutorialspoint.com/design_pattern/template_pattern.htm

public abstract class Customer {
	public String name;
	private Store store;
	private ArrayList<RentalRecord> orderList;
	private RentBehavior rentType;
	
	public Customer(String name, RentBehavior type, Store store){
		this.name = name;
		this.store = store;
		this.rentType = type;
	}
	
	public RentBehavior getType() {
		return rentType;
	}
	private boolean willRent() {
		// Looks at inventory and see if I can rent tools
		if (store.getInventory().size() == 0) {
			return false;
		}
		// If the customer is a business customer and the inventory does not have three tools then don't go rent
		else if(this.rentType == BusinessCustomer && store.getInventory().size() < 3)
		{
			return false;
		}
		else if(this.rentType == Regular || this.rentType == Casual && store.getInventory().size())
		// Look at what I have and random number to decide if I will go rent.
		return true;
	}
	 RentalRecord rentTools() {
		// Check if we're casual or regular
		// Look at inventory generate number between 1 and the (min(inventory), max(rentals)). Rent that many tools
	}
}

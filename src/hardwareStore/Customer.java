package hardwareStore;
import java.util.ArrayList;


public class Customer {
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
		if (store.methodForInventoryCount == 0) {
			return false;
		}
		else if(this.rentType == Business && store.count < 3)
		{
			return false;
		}
		else if()
		// Look at what I have and random number to decide if I will go rent.
		return true;
	}
	 RentalRecord rentTools() {
		// Check if we're casual or regular
		// Look at inventory generate number between 1 and the (min(inventory), max(rentals)). Rent that many tools
	}
}

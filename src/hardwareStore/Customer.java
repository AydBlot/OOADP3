package hardwareStore;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Customer implements Observer{
	public String name;
	private Store store;
	private ArrayList<RentalRecord> orderList;
	private RentBehavior rentType;
	
	public Customer(String name, RentBehavior type, Store store){
		this.name = name;
		this.store = store;
		this.rentType = type;
	}
	
	//Observer update function looks for the rental ID
	//of the expired rental order and returns the 
	//tools
    public void update(Observable obj, Object arg) {
    	for (RentalRecord record : orderList) {
    		if (arg.equals(record.getOrderID())) {
    			orderList.remove(record);
    			returnTools(record);
    		}
    	}
        System.out.println("FirstNewsReader got The news:"+(String)arg);
    }
	
    private void returnTools(RentalRecord record) {
    	for (Tool returnTool : record.getRentedTools()) {
    		store.processReturn(returnTool);
    	}
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

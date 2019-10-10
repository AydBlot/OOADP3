package hardwareStore;

import java.util.ArrayList;

public class CasualCustomer extends Customer { // one or two tools for one or two nights
	
	public CasualCustomer(String name, RentBehavior type, Store store) {
		super(name, store);
		// TODO Auto-generated constructor stub
	}
	// How many tools do I rent
	public int howMany() {
		// Source for random number line: https://stackoverflow.com/questions/21246696/generating-a-number-between-1-and-2-java-math-random/21246795
		int num;
		if(store.getInventory().size() >= 2) {
			num = (Math.random() <= 0.5) ? 1 : 2;
		}
		else {
			num = 1;
		}		
		return num;
	}
	// How long do I rent the tools for
	public int howLong() {
		int num = (Math.random() <= 0.5) ? 1 : 2;
		return num;
	}
	// Will I even go to the store?
	@Override
	protected boolean willRent() {
		// TODO Auto-generated method stub
		if(store.getInventory().size() == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	@Override
	protected RentalRecord rent() {
		int numTools = this.howMany();
		ArrayList<Tool> rentList = null;
		ArrayList<Tool> storeInventory = store.getInventory();
		// Loop 
		for(int i = 1; i <= numTools; i++) {
			rentList.add(storeInventory.get(storeInventory.size()-i));
		}
		RentalRecord rentItems = new RentalRecord(rentList, this.howLong());
		return rentItems;
	}
	
}

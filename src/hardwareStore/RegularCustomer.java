package hardwareStore;

import java.util.ArrayList;

public class RegularCustomer extends Customer { //rent one to three tools each time they visit for 3 to 5 nights
	
	public RegularCustomer(String name, RentBehavior type, Store store) {
		super(name,store);
		// TODO Auto-generated constructor stub
	}

	public int howMany() {
		int num;
		if(store.getInventory().size() >= 3) {
			num = (int) (Math.random() * 3);
		}
		else if(store.getInventory().size() == 2) {
			num = (Math.random() <= 0.5) ? 1 : 2;
		}
		else {
			num = 1;
		}
		return num;
	}
	
	public int howLong() {
		int num;
		int days;
		num = (int) (Math.random() * 2);
		days = 3 + num;
		return days;
	}
	
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

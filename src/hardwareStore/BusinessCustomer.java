package hardwareStore;

import java.util.ArrayList;

public class BusinessCustomer extends Customer{
	
	public BusinessCustomer(String name, RentBehavior type, Store store) {
		super(name,store);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean willRent(){
		if(store.getInventory().size() < 3) {
			return false;
		}
		else {
			return true;
		}
	}
	
	@Override
	protected RentalRecord rent() {
		ArrayList<Tool> rentList = null;
		ArrayList<Tool> storeInventory = store.getInventory();
		// Loop 
		for(int i = 1; i <= 3; i++) {
			rentList.add(storeInventory.get(storeInventory.size()-i));
		}
		
		RentalRecord rentItems = new RentalRecord(rentList, 7);
		return rentItems;
	}


}

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
	protected RentalRecord rent(int currentDay) {
		ArrayList<Tool> rentList = null;
		ArrayList<RentalOption> options = null;
		ArrayList<Tool> storeInventory = store.getInventory();
		// Loop 
		for(int i = 1; i <= 3; i++) {
			int numOptions = this.numOptions();
			rentList.add(storeInventory.get(storeInventory.size()-i));
			for(int y = 0; y < numOptions; y++) {
				RentalOption opt = this.randomRentOption();
				options.add(opt);
			}
		}
		RentalRecord rentItems = new RentalRecord(rentList, options, 7, currentDay);
		this.orderList.add(rentItems);
		return rentItems;
	}


}

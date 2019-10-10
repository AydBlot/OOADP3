package hardwareStore;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.UUID;

public abstract class Customer implements Observer{
	public String name;
	protected Store store;
	protected ArrayList<RentalRecord> orderList;
	
	public Customer(String name, Store store){
		this.name = name;
		this.store = store;
	}	
	// Methods
	
	protected RentalOption randomRentOption() {
		int num = (int)(Math.random() * 3);
		if(num == 0) {
			return new AccessoryKitOption();
		}
		else if(num == 1) {
			return new ExtensionCordOption();
		}
		else {
			return new ProtectiveGearOption();
		}
	}
	
	protected int numOptions() {
		int num = (int)(Math.random() * 7);
		return num;
	}
	
	public final void rentTools(int currentDay) {
		//Determine if we are going to go to the store
		willRent();
		if(willRent()){
			rent(currentDay);
		}
	}
	protected abstract boolean willRent();
	protected abstract RentalRecord rent(int currentDay);
	//Observer update function looks for the rental ID
	//of the expired rental order and returns the 
	//tools
    public void update(Observable obj, Object arg) {
    	
    	UUID recordID = (UUID)arg;
    	
    	for (RentalRecord record : orderList) 
    	{
    		if (recordID.equals(record.getID())) 
			{    			
    			returnTools(record);
    			orderList.remove(record);
    		}
    	}
        System.out.println("FirstNewsReader got The news:"+(String)arg);
    }
	
    private void returnTools(RentalRecord record) {
		store.processReturn(record);
    }
}

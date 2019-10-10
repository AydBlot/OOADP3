package hardwareStore;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.UUID;

public abstract class Customer implements Observer{
	public String name;
	protected Store store;
	protected ArrayList<RentalRecord> orderList;
	public int day;
	
	public Customer(String name, Store store){
		this.name = name;
		this.store = store;
	}	
	// Methods
	protected int numOptions() {
		int num = (int)(Math.random() * 6);
		return num;
	}
	
	public void updateDay() {
		this.day = day+1;
	}
	
	public final void rentTools() {
		//Determine if we are going to go to the store
		willRent();
		if(willRent()){
			rent();
		}
	}
	protected abstract boolean willRent();
	protected abstract RentalRecord rent();
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

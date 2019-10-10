package hardwareStore;

import java.util.ArrayList;

public class World 
{
	private int currentDay;
	private ArrayList<Store> stores;
	private ArrayList<Customer> customers;
	
	
	public World()
	{
		currentDay = 1;
	}
	
	/** 
	 * Increment the current day
	 */
	public void startNewDay()
	{
		currentDay++;
		
		for (Store store : stores)
		{
			// First, stores need to check if they have any due rentals and notify customers
			store.checkRentalRecords(currentDay);
			
			
		}
		
		// TODO: Stores and customers need to do their things for the day here
	}
	
	public void runSimulation(int days)
	{
		while(currentDay < days)
		{
			startNewDay();
		}
	}
}

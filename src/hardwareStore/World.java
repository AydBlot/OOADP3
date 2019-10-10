package hardwareStore;

import java.util.ArrayList;

public class World 
{
	private int currentDay;
	private ArrayList<Store> stores;
	private ArrayList<Customer> customers;
	
	public World()
	{
		currentDay = 0;
	}
	
	/** 
	 * Increment the current day then run through the logic for stores and customers for each day
	 */
	public void startNewDay()
	{
		// Increment the day counter
		currentDay++;
		
		// Loop through each store
		for (Store store : stores)
		{
			// First, stores need to check if they have any due rentals and notify customers
			store.checkRentalRecords(currentDay);
		}
	}
	
	/**
	 * Run the simulation for a given number of days. This calls the
	 * startNewDay function days number of times. If run multiple times, 
	 * will continue
	 * @param days The number of days to run the simulation for.
	 */
	public void runSimulation(int days)
	{
		int startDay = currentDay;
		while(currentDay - startDay < days)
		{
			startNewDay();
		}
	}
}

package hardwareStore;

import java.util.ArrayList;

public class World 
{
	private int currentDay;
	private ArrayList<Store> stores;
	private ArrayList<Customer> customers;
	
	public World()
	{
		stores = new ArrayList<Store>();
		customers = new ArrayList<Customer>();
		currentDay = 0;
	}
	
	/** 
	 * Increment the current day then run through the logic for stores and customers for each day
	 */
	public void startNewDay()
	{
		if(currentDay != 0)
		{
			System.out.println("\n---------------\n");
		}
		else
		{
			System.out.println("\n");
		}
		
		System.out.println("Cue the sun. Day " + currentDay + " is starting now.");
		
		// Increment the day counter
		currentDay++;
		
		// Loop through each store
		for (Store store : stores)
		{
			// Check if they have any due rentals and notify customers
			store.checkRentalRecords(currentDay);
		}

		// Now, loop through each customer and have them run through their day
		for(Customer customer: customers)
		{
			customer.runDay(currentDay);
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
	
	public void addStore(Store s)
	{
		stores.add(s);
	}
	
	public void addCustomer(Customer c)
	{
		customers.add(c);
	}
}

package hardwareStore;

import java.util.ArrayList;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class Store extends Observable
{
	private ArrayList<Tool> inventory;
	private ArrayList<RentalRecord> activeRentals;
	private ArrayList<RentalRecord> archivedRentals;
	private String name;
	
	public Store(String name)
	{
		this.inventory = new ArrayList<Tool>();
		this.activeRentals = new ArrayList<RentalRecord>();
		this.archivedRentals = new ArrayList<RentalRecord>();
		this.name = name;
	}
	
	public Store(String name, ArrayList<Tool> inventory)
	{
		this.inventory = new ArrayList<Tool>(inventory);
		this.activeRentals = new ArrayList<RentalRecord>();
		this.archivedRentals = new ArrayList<RentalRecord>();
		this.name = name;
	}
	
	/** 
	 * Add a tool to the store's inventory.
	 * @param t The tool to be added.
	 */
	public void addToolToInventory(Tool t)
	{
		this.inventory.add(t);
	}
	
	/**
	 * Remove a tool from the store's inventory.
	 * @param t The tool to be removed.
	 */
	public void removeToolFromInventory(Tool t)
	{
		this.inventory.remove(t);
	}
	
	/**
	 * @return The store's current inventory.
	 */
	public ArrayList<Tool> getInventory()
	{
		return this.inventory;
	}
	
	/**
	 * Look through the active rental records at the store and notify any customers
	 * who have rentals that are due to be returned. Should be run before the beginning
	 * of each day.
	 * @param currentDay The current day in the simulation.
	 */
	public void checkRentalRecords(int currentDay) 
	{
		// Loop through the list of active rentals
		for (RentalRecord record: this.activeRentals)
		{
			// Number of days that have passed since the rental record was created.
			int daysPassed = currentDay - record.getDayRented();
			
			// If the days passed is equal to the rental length, the rental is due
			if (daysPassed == record.getRentalLength()) 
			{
				// Notify the customers that the record needs to be returned
				notifyObservers(record.getID());
			}
		}
	}
	
	/**
	 * Receives a rental record from the Customer and starts the rental 
	 * by removing the tools from inventory and adding the rental record
	 * to the list of active records.
	 * @param toStart The rental to start.
	 */
	public void processReturn(RentalRecord record) 
	{
		// Return the tools to the inventory
		for (Tool rentedTool : record.getRentedTools()) 
		{
			addToolToInventory(rentedTool);
		}
		
		// Move the rental record from active to archive
		activeRentals.remove(record);
		archivedRentals.add(record);
	}

	public ArrayList<RentalRecord> getArchive()
	{
		return this.archivedRentals;
	}
	
	public int calculateTotalSales()
	{
		int total = 0;
		
		// TODO: Calculate the total sales based on the active and archived rentals
		
		for(RentalRecord rec : activeRentals)
		{
			
		}
		
		for(RentalRecord rec : archivedRentals)
		{
			
		}
		
		return total;
	}
}

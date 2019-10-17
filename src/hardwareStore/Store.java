package hardwareStore;

import java.util.ArrayList;
import java.util.Observable;

/**
 * A Store is visited by Customers and rents Tools to those customers.
 * 
 * Implements the Observable/Subject part of the Observer pattern 
 * in conjunction with Customer, which implements Observer.
 * 
 * @author Alex
 *
 */
@SuppressWarnings("deprecation")
public class Store extends Observable
{
	private ArrayList<Tool> inventory;
	private ArrayList<RentalRecord> activeRentals;
	private ArrayList<RentalRecord> archivedRentals;
	private String name;
	
	/**
	 * Constructor for Store
	 * @param name The name of the store
	 */
	public Store(String name)
	{
		this.inventory = new ArrayList<Tool>();
		this.activeRentals = new ArrayList<RentalRecord>();
		this.archivedRentals = new ArrayList<RentalRecord>();
		this.name = name;
	}
	
	/**
	 * Constructor for Store with an inventory
	 * @param name The name of the store
	 * @param inventory The list of Tools that exist in the Store's inventory
	 */
	public Store(String name, ArrayList<Tool> inventory)
	{
		this.inventory = new ArrayList<Tool>(inventory);
		this.activeRentals = new ArrayList<RentalRecord>();
		this.archivedRentals = new ArrayList<RentalRecord>();
		this.name = name;
	}
	
	/**
	 * @return The name of the store.
	 */
	public String getName()
	{
		return this.name;
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
		ArrayList<RentalRecord> recordsToReturn = new ArrayList<RentalRecord>();
		
		// Loop through the list of active rentals
		for (RentalRecord record: this.activeRentals)
		{
			// Number of days that have passed since the rental record was created.
			int daysPassed = currentDay - record.getDayRented();
			
			// If the days passed is equal to the rental length, the rental is due
			if (daysPassed == record.getRentalLength()) 
			{
				recordsToReturn.add(record);
			}
		}
		
		for (RentalRecord record : recordsToReturn)
		{
			// Notify the customers that the record needs to be returned
			setChanged();
			notifyObservers(record);
		}
	}
	
	/**
	 * Receives a rental record from the Customer and starts the rental 
	 * by removing the tools from inventory and adding the rental record
	 * to the list of active records.
	 * @param toStart The rental to start.
	 */
	public void startRental(RentalRecord rental)
	{
		// Remove the tools in the rental from inventory
		for(Tool rentedTool : rental.getRentedTools())
		{
			removeToolFromInventory(rentedTool);
		}
		
		// Add the rental to the list of active rentals
		activeRentals.add(rental);
	}
	
	/**
	 * Receives a rental record from the Customer and ends the renal
	 * by adding the tools back to inventory and moving the rental record
	 * from the list of active rentls to the list of archived rentals.
	 * @param record The rental to end.
	 */
	public void processReturn(RentalRecord rental) 
	{
		// Return the tools to the inventory
		for (Tool rentedTool : rental.getRentedTools())
		{
			addToolToInventory(rentedTool);
		}
		
		// Move the rental record from active to archive
		activeRentals.remove(rental);
		archivedRentals.add(rental);
	}

	/**
	 * @return The list of archived rentals.
	 */
	public ArrayList<RentalRecord> getArchive()
	{
		return this.archivedRentals;
	}
	
	/**
	 * @return The list of active rentals.
	 */
	public ArrayList<RentalRecord> getActiveRentals()
	{
		return this.activeRentals;
	}
	
	public void printInventory() {
		String printString = this.getName() + "'s inventory: ";
		for (Tool tool : this.inventory)
		{
			printString += tool.getName() + ", ";
		}
		printString = printString.substring(0, printString.length() - 2);
		System.out.println(printString); 
	}
	
	//Display the past archived tools that were rented and by whom
	public void printArchivedRecords()
	{
		System.out.println("\nCompleted Rentals for " + this.getName() + ":");
		for (RentalRecord archivedRental : archivedRentals)
		{
			archivedRental.printRentalDescription();
		}
	}
	
	public void printActiveReocrds() {
		System.out.println("\nActive Rentals for " + this.getName() + ":");
		for (RentalRecord archivedRental : activeRentals)
		{
			archivedRental.printRentalDescription();
		}
	}
	
	/**
	 * Calculate the current total money made by the store.
	 * @return The calculated total.
	 */
	public int calculateTotalSales()
	{
		int total = 0;
		
		// Money made from active rentals
		for(RentalRecord rec : activeRentals)
		{
			total += rec.getCost();
		}
		
		// Money made from archived rentals
		for(RentalRecord rec : archivedRentals)
		{
			total += rec.getCost();
		}
		
		return total;
	}
}

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
	
	public void addToolToInventory(Tool t)
	{
		this.inventory.add(t);
	}
	
	public void removeToolFromInventory(Tool t)
	{
		this.inventory.remove(t);
	}
	
	public ArrayList<Tool> getInventory()
	{
		return this.inventory;
	}
	
	//called at the beginning of every day
	public void checkRentalRecords(int currentDay) {
		for (RentalRecord record: this.activeRentals){
			int daysPassed = currentDay - record.getDayRented();
			if ( daysPassed == record.getDaysToRentTool()) {
				//Notify the observer of the ID that expired
				//and remove it from the active rentals
				notifyObservers(record.getOrderID());
			}
		}
	}
	
	public void processReturn(RentalRecord record) {
		activeRentals.remove(record);
		
		//Return the tools
		for (Tool rentedTool : record.getRentedTools()) {
			inventory.add(rentedTool);
		}
		
		archivedRentals.add(record);
	}
	
	public void startRental(RentalRecord toStart)
	{
		// TODO: Remove tools from inventory
		
		// Add the RentalRecord to the list of active rentals
		activeRentals.add(toStart);
	}
	
	public void endRental(RentalRecord toEnd)
	{
		// TODO: Add tools back to inventory
		
		// Move the rental from active rentals to the rental archive
		// TODO: Throw exception if the rental record doesn't exist?
		if(activeRentals.remove(toEnd))
		{
			archivedRentals.add(toEnd);
		}
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

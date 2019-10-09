package hardwareStore;

import java.util.ArrayList;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class Store extends Observable
{
	private ArrayList<Tool> inventory;
	private ArrayList<RentalRecord> activeRentals;
	private ArrayList<RentalRecord> rentalArchive;
	private String name;
	private int day = 1;
	
	public Store(String name)
	{
		this.inventory = new ArrayList<Tool>();
		this.activeRentals = new ArrayList<RentalRecord>();
		this.rentalArchive = new ArrayList<RentalRecord>();
		this.name = name;
	}
	public Store(String name, ArrayList<Tool> inventory)
	{
		this.inventory = new ArrayList<Tool>(inventory);
		this.activeRentals = new ArrayList<RentalRecord>();
		this.rentalArchive = new ArrayList<RentalRecord>();
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
	
	public int getDay()
	{
		return this.day;
	}
	public void incrementDay()
	{
		this.day++;
	}
}

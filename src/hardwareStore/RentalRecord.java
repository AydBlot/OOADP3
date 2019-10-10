package hardwareStore;
import java.util.UUID;
import java.util.ArrayList;

public class RentalRecord{
	private UUID rentalID;
	private int rentalLength;
	private int dayRented;
	private int orderCost;
	private ArrayList<Tool> rentedTools;
	private ArrayList<RentalOption> options;
	
	public RentalRecord(ArrayList<Tool> rentedTools, ArrayList<RentalOption> options, int rentalLength, int today)
	{
		this.rentedTools = rentedTools;
		this.rentalLength = rentalLength;
		this.rentalID = UUID.randomUUID();
		this.dayRented = today;
		
		// Calculate the total cost
		calculateCost();
	}
	
	/**
	 * @return The unique ID for the rental record.
	 */
	public UUID getID()
	{
		return this.rentalID;
	}
	
	/** 
	 * @return The day that the tools were rented on.
	 */
	public int getDayRented() 
	{
		return this.dayRented;
	}
	
	/** 
	 * @return The number of days that the tools were rented for.
	 */
	public int getRentalLength()
	{
		return this.rentalLength;
	}
	
	/**
	 * @return The list of tools in the rental record.
	 */
	public ArrayList<Tool> getRentedTools()
	{
		return this.rentedTools;
	}
	
	/**
	 * @return The total cost of the rental record.
	 */
	public int getCost()
	{
		return this.orderCost;
	}
	
	/**
	 * Calculates the total cost of the rental based on the
	 * options and tools added to the RentalRecord
	 */
	private void calculateCost()
	{
		// Initialize orderCost to 0
		orderCost = 0;
		
		// Add the cost of the options
		for (RentalOption option: options) 
		{
			orderCost += option.getCost();
		}
		
		// Add the total cost of the tools (cost per day * total days)
		for (Tool tool: rentedTools) 
		{
			orderCost += (tool.getDailyPrice() * rentalLength);
		}
	}
}

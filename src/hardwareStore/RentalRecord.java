package hardwareStore;
import java.util.UUID;
import java.util.ArrayList;

/**
 * Rental Records are created by Customers and executed by Stores.
 * Represents a rental, including the tools rented, 
 * options added, rental length, and total cost
 * 
 * Implements the Command Pattern - created by Customer and executed by Store.
 * 
 * @author Ayden
 *
 */
public class RentalRecord
{
	private UUID rentalID;
	private int rentalLength;
	private int dayRented;
	private int orderCost;
	private ArrayList<Tool> rentedTools;
	private ArrayList<RentalOption> options;
	private Customer rentalCustomer;
	
	public RentalRecord(ArrayList<Tool> rentedTools, ArrayList<RentalOption> options, int rentalLength, int today, Customer rentalCustomer)
	{
		this.rentedTools = rentedTools;
		this.options = options;
		this.rentalLength = rentalLength;
		this.rentalID = UUID.randomUUID();
		this.dayRented = today;
		this.rentalCustomer = rentalCustomer;
		
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
	
	public Customer getCustomer()
	{
		return this.rentalCustomer;
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
	
	public void printRentalDescription() {
		String printString = this.getCustomer().getName() + "rented a";
		for (Tool tool: this.getRentedTools() ) {
			printString += tool.getName() + ",";
		}
		printString += "with Options";
		for (RentalOption option : this.options) {
			printString += option.getDescription() + ","; 
		}
		printString += "for" + this.getCost();
		printString += "for" + this.getRentalLength() + "days";
		System.out.print(printString);
	}
}

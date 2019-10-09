package hardwareStore;
import java.util.*;

public class RentalRecord{
	private String rentalID;
	private int daysToRentTool;
	private ArrayList<Tool> orderedTools;
	private int orderCost;
	
	public RentalRecord(ArrayList<Tool> OrderedTools, int DaysToRent){
		this.orderedTools = OrderedTools;
		this.daysToRentTool = DaysToRent;
		this.rentalID = UUID.randomUUID().toString();
	}
	
	public String getOrderID()
	{
		return this.rentalID;
	}
	
	public int getDaysToRentTool() {
		return this.daysToRentTool;
	}
}

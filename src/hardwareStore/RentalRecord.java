package hardwareStore;
import java.util.*;

public class RentalRecord{
	private String rentalID;
	private int daysToRentTool;
	private int dayRented;
	private ArrayList<Tool> ToolsToRent;
	private int orderCost;
	private ArrayList<RentalOption> OptionList;
	
	public RentalRecord(ArrayList<Tool> OrderedTools, int DaysToRent, int today){
		this.ToolsToRent = OrderedTools;
		this.daysToRentTool = DaysToRent;
		this.rentalID = UUID.randomUUID().toString();
		this.dayRented = today;
	}
	
	public String getOrderID()
	{
		return this.rentalID;
	}
	
	public int getDayRented() {
		return this.dayRented;
	}
	
	public void setOptions(ArrayList<RentalOption> Options) {
		this.OptionList = Options;
	}
	
	public void calculateCost() {
		for (RentalOption option: this.OptionList) {
			this.orderCost += option.getCost();
		}
		
		for (Tool rentedTool: this.ToolsToRent) {
			this.orderCost += (rentedTool.getDailyPrice() * this.daysToRentTool);
		}
	}
	
	public int getDaysToRentTool() {
		return this.daysToRentTool;
	}
	
	public ArrayList<Tool> getRentedTools(){
		return this.ToolsToRent;
	}
}

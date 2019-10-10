package hardwareStore;
import java.util.*;

public class RentalRecord{
	private String rentalID;
	private int daysToRentTool;
	private ArrayList<Tool> ToolsToRent;
	private int orderCost;
	private ArrayList<RentalOption> OptionList;
	
	public RentalRecord(ArrayList<Tool> OrderedTools, int DaysToRent){
		this.ToolsToRent = OrderedTools;
		this.daysToRentTool = DaysToRent;
		this.rentalID = UUID.randomUUID().toString();
	}
	
	public String getOrderID()
	{
		return this.rentalID;
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

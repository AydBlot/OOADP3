package hardwareStore;

public class ProtectiveGearOption extends RentalOption
{
	private final int COST = 12;
	
	public ProtectiveGearOption()
	{
		
	}
	
	public String getDescription() 
	{
		return "Protective Gear Package";
	}
	public int getCost() 
	{
		return COST;
	}
}

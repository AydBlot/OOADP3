package hardwareStore;

public class ExtensionCordOption extends RentalOption
{
	private final int COST = 4;
	
	public ExtensionCordOption()
	{
		
	}
	
	public String getDescription() 
	{
		return "Extension Cord";
	}
	public int getCost() 
	{
		return COST;
	}
}

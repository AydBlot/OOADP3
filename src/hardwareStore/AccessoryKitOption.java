package hardwareStore;

public class AccessoryKitOption extends RentalOption
{
	private final int COST = 8;
	
	public AccessoryKitOption()	{}
	
	public String getDescription() 
	{
		return "Accessory Kit";
	}
	public int getCost() 
	{
		return COST;
	}
}

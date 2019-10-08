package hardwareStore;

public class WoodworkTool extends Tool
{
	public WoodworkTool(String name)
	{
		super(name);
	}
	
	public int getDailyPrice()
	{
		return 20;
	}
	public int getCategory()
	{
		return CategoryTypes.WOODWORK; 
	}
}

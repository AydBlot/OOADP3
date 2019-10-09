package hardwareStore;

public class PlumbingTool extends Tool
{
	public PlumbingTool(String name)
	{
		super(name);
	}
	
	public int getDailyPrice()
	{
		return 5;
	}
	public int getCategory()
	{
		return CategoryType.PLUMBING; 
	}
}

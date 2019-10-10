package hardwareStore;

public class YardworkTool extends Tool
{
	public YardworkTool(String name)
	{
		super(name);
	}
	
	public int getDailyPrice()
	{
		return 28;
	}
	public int getCategory()
	{
		return CategoryType.YARDWORK; 
	}
}

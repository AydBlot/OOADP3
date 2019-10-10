package hardwareStore;

public class ConcreteTool extends Tool
{
	public ConcreteTool(String name)
	{
		super(name);
	}
	
	public int getDailyPrice()
	{
		return 15;
	}
	public int getCategory()
	{
		return CategoryType.CONCRETE;
	}
}

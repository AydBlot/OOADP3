package hardwareStore;

public class PaintingTool extends Tool
{
	public PaintingTool(String name)
	{
		super(name);
	}
	
	public int getDailyPrice()
	{
		return 10;
	}
	public int getCategory()
	{
		return CategoryType.PAINTING; 
	}
}

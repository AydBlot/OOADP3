package hardwareStore;

public abstract class Tool 
{
	protected String name;

	public Tool(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public abstract int getDailyPrice();
	public abstract int getCategory();
}

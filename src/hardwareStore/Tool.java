package hardwareStore;

public abstract class Tool 
{
	protected String name;

	public Tool(String name)
	{
		this.name = name;
	}
	
	/**
	 * 
	 * @return The name of the tool
	 */
	public String getName()
	{
		return name;
	}
	
	/** 
	 * 
	 * @return The cost per day for renting the tool based on the Category type that the tool is
	 */
	public abstract int getDailyPrice();
	
	/**
	 * 
	 * @return The category that the tool is in. Category types are found in CategoryType.java
	 */
	public abstract int getCategory();
}

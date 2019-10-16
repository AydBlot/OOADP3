package hardwareStore;

/**
 * Tools are rented to Customers from Stores via Rental Records.
 * 
 * @author Alex
 *
 */
public abstract class Tool 
{
	protected String name;

	/**
	 * Constructor for Tools
	 * @param name The name of the tool
	 */
	public Tool(String name)
	{
		this.name = name;
	}
	
	/**
	 * @return The name of the tool.
	 */
	public String getName()
	{
		return name;
	}
	
	/** 
	 * @return The cost per day for renting the tool based on the category that the tool is a part of.
	 */
	public abstract int getDailyPrice();
	
	/**
	 * @return The category that the tool is in. Category types are defined in the CategoryType class.
	 */
	public abstract int getCategory();
}

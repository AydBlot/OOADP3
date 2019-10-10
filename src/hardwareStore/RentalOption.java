package hardwareStore;

public abstract class RentalOption{
	
	/**
	 * @return The description of the rental option.
	 */
	public abstract String getDescription();
	
	/**
	 * @return The cost to add the rental option to a rental.
	 */
	public abstract int getCost();
}

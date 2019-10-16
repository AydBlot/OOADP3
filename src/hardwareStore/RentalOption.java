package hardwareStore;

/**
 * Rental Options are optional additional items added to a Rental Record.
 * The price of a rental option applies to an entire rental, not on a daily basis.
 * 
 * @author Ayden
 *
 */
public abstract class RentalOption
{
	/**
	 * @return The description of the rental option.
	 */
	public abstract String getDescription();
	
	/**
	 * @return The cost to add the rental option to a rental.
	 */
	public abstract int getCost();
	
	/**
	 * Generate a random rental option.
	 * @return The randomly generated rental option
	 */
	public static RentalOption getRandomRentalOption()
	{
		RentalOption result;
		int optionType = (int)(Math.random() * OptionType.TYPE_COUNT);
		
		switch(optionType)
		{
			case OptionType.ACCESSORY_KIT:
				result = new AccessoryKitOption();
				break;
			case OptionType.EXTENSION_CORD:
				result = new ExtensionCordOption();
				break;
			case OptionType.PROTECTIVE_GEAR:
			default:
				result = new ProtectiveGearOption();
				break;
		}
		
		return result;
	}
}

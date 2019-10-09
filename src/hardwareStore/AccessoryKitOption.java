package hardwareStore;

public class AccessoryKitOption extends RentalOption{
	private int cost = 8;
	
	public String getDescription() {
		return "Accessory Kit";
	}
	
	public int getCost() {
		return this.cost;
	}
}

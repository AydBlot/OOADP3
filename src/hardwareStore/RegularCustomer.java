package hardwareStore;

public class RegularCustomer extends Customer {
	
	public RegularCustomer(String name, RentBehavior type, Store store) {
		super(name, type, store);
		// TODO Auto-generated constructor stub
	}

	public int howMany() {
		return 3;
	}
	
	public int howLong() {
		return 5;
	}
}
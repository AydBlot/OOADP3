package hardwareStore;

public class CasualCustomer extends Customer {
	
	public CasualCustomer(String name, RentBehavior type, Store store) {
		super(name, type, store);
		// TODO Auto-generated constructor stub
	}
	public int howMany() {
		return 2;
	}
	public int howLong() {
		return 2;
	}
}

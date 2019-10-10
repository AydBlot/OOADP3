package hardwareStore;
import java.util.ArrayList;
// Template pattern reference: https://www.tutorialspoint.com/design_pattern/template_pattern.htm

public abstract class Customer {
	// Attributes
	public String name;
	protected Store store;
	protected ArrayList<RentalRecord> orderList;
	
	public Customer(String name, Store store){
		this.name = name;
		this.store = store;
	}	
	// Methods
	public final void rentTools() {
		//Determine if we are going to go to the store
		willRent();
		if(willRent()) {
			rent();
		}
	}	
	protected abstract boolean willRent();
	protected abstract RentalRecord rent();
}

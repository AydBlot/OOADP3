package hardwareStore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestWorld {
	World hitchhikersWorld = World.getTheWorld();
	Store hardwareStore = new Store("The Hard Store");
	Customer newCustomer = new CasualCustomer("Steve", hardwareStore);
	
	@Test
	void testAddCustomer() {
		
		//Test adding one customer
		hitchhikersWorld.addCustomer(newCustomer);
		
		assertEquals(hitchhikersWorld.getCustomers().size(), 1);
		
		////Test adding two customers at once
		Customer new2Customer = new CasualCustomer("Steve2", hardwareStore);
		Customer new3Customer = new CasualCustomer("Steve3", hardwareStore);
		
		hitchhikersWorld.addCustomer(new2Customer);
		hitchhikersWorld.addCustomer(new3Customer);
		
		assertEquals(hitchhikersWorld.getCustomers().size(), 3);		
	}
	
	@Test
	void testAddStore() {
		hitchhikersWorld.addStore(hardwareStore);
		
		assertEquals(hitchhikersWorld.getStores().size(), 1);
	}

	@Test
	void testCurrentDays() {
		hitchhikersWorld.startNewDay();
		
		assertEquals(hitchhikersWorld.getStagedDay(), 2);
	}
	
	@Test
	void testRunSimulation() {
		hitchhikersWorld.runSimulation(4);
		
		// At the start of the 6th day, but have yet to perform the actions of that day.
		assertEquals(hitchhikersWorld.getStagedDay(), 6);
	}
	
	
}

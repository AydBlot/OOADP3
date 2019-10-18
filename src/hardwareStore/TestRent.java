package hardwareStore;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestRent
{
	Store emptyStore = new Store("Empty Store");
	Store okStore = new Store("Some stuff");
	Store niceStore = new Store("Mos Eisley Cantina");
	
	Tool tool1 = new ConcreteTool("Hammer");
	Tool tool2 = new ConcreteTool("Impact Driver");
	Tool tool3 = new ConcreteTool("Lever");
	Tool tool4 = new ConcreteTool("Screw");
	Tool tool5 = new ConcreteTool("Saw");
	Tool tool6 = new ConcreteTool("Drill");
	Tool tool7 = new ConcreteTool("Lightsaber");
	
	RentalOption option1 = new ExtensionCordOption();
	RentalOption option2 = new ProtectiveGearOption();
	RentalOption option3 = new AccessoryKitOption();
	
	ArrayList<RentalOption> options = new ArrayList<RentalOption>();
	
	@Test
	void testStoreEmptyBusiness()
	{
		Customer business = new BusinessCustomer("Jordan Belfort", emptyStore);
		if(emptyStore.getInventory().size() != 0)
		{
			fail("Empty store is not empty");
		}
		business.runDay(1);		
		assertEquals(business.getNumToolsRented(), 0);
	}
	
	@Test
	void testStoreEmptyCasual()
	{
		Customer casual = new CasualCustomer("Zed", emptyStore);
		if(emptyStore.getInventory().size() != 0)
		{
			fail("Empty store is not empty");
		}
		casual.runDay(1);		
		assertEquals(casual.getNumToolsRented(), 0);
	}
	
	@Test
	void testStoreEmptyRegular() {
		Customer regular = new RegularCustomer("The Dude", emptyStore);
		if(emptyStore.getInventory().size() != 0)
		{
			fail("Empty store is not empty");
		}
		regular.runDay(1);		
		assertEquals(regular.getNumToolsRented(), 0);
	}
	
	@Test
	void testStoreThreeItems() {
		okStore.addToolToInventory(tool7);
		okStore.addToolToInventory(tool5);
		okStore.addToolToInventory(tool5);
		
		Customer business = new BusinessCustomer("Jordan Belfort", okStore);
		
		if(okStore.getInventory().size() != 3)
		{
			fail("Store does not have exactly three items");
		}
		
		RentalRecord rental = business.generateRental(1);
		assertEquals(3, rental.getRentedTools().size());
	}
}

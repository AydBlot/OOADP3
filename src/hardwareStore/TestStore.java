package hardwareStore;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestStore
{
	Store s = new Store("Test");
	Tool concTool = new ConcreteTool("Test Concrete Tool");
	RentalOption extCordOpt = new ExtensionCordOption();
	
	final int RENTAL_LENGTH = 3;
	
	/**
	 * Check that a tool is in inventory after it has been added
	 * and no longer in inventory after it has been removed.
	 */
	@Test
	void testAddAndRemoveToolInventory()
	{
		s.addToolToInventory(concTool);
		
		// Inventory size should now be 1
		assertEquals(s.getInventory().size(), 1);
		
		// Tool in inventory should match our test tool
		assertEquals(s.getInventory().get(0), concTool);
		
		// Now, remove the tool from inventory
		s.removeToolFromInventory(concTool);
		
		// Inventory size should now be 0
		assertEquals(s.getInventory().size(), 0);
	}
	
	/**
	 * Check that a tool is properly removed from inventory when starting a rental
	 * and added back to inventory when a rental is completed.
	 */
	@Test
	void testStartAndEndRental()
	{
		// Add a test tool to the store's inventory
		s.addToolToInventory(concTool);
		
		// Tools list for the rental record, only containing the test tool
		ArrayList<Tool> tList = new ArrayList<Tool>();
		tList.add(concTool);
		
		// Options list for the rental record
		ArrayList<RentalOption> oList = new ArrayList<RentalOption>();
		oList.add(extCordOpt);
		
		// Create and start the rental record
		RentalRecord r = new RentalRecord(tList, oList, RENTAL_LENGTH, 0);
		s.startRental(r);
		
		// Inventory should now be empty
		assertEquals(0, s.getInventory().size());
		
		// There should now be 1 active rental, which is the rental option we created
		assertEquals(1, s.getActiveRentals().size());
		assertEquals(s.getActiveRentals().get(0), r);
		
		// Now, process the return
		s.processReturn(r);

		// Inventory should equal the tools list from the rental record since we checked every tool out
		assertEquals(s.getInventory(), tList);
		
		// There should now be 0 active rentals
		assertEquals(0, s.getActiveRentals().size());
		
		// There should now be 1 archived rental, which is the rental option we created
		assertEquals(0, s.getActiveRentals().size());
		assertEquals(s.getArchive().get(0), r);
	}
	
	/** 
	 * Test that the total calculated sales is correct
	 */
	@Test
	void testCalculateTotal()
	{
		// Run the test rental again to set up
		testStartAndEndRental();
		
		// Correct total is the daily price of concTool * the length of the rental + the cost of the extension cord option
		int correctTotal = concTool.getDailyPrice() * RENTAL_LENGTH;
		correctTotal += extCordOpt.getCost();
		
		// Make sure that the calculated total is equal to the correct total
		assertEquals(s.calculateTotalSales(), correctTotal);
	}
}

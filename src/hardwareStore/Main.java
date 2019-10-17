package hardwareStore;

public class Main 
{
	public static void main(String[] args)
	{
		// Get the World
		World aWholeNewWorld = World.getTheWorld();
		
		// Create a Store
		Store theStore = new Store("Bartlebee's Hardware Shack");
		
		// Create and add tools to the Store
		
		// Concrete Tools
		theStore.addToolToInventory(new ConcreteTool("Concrete Mixer"));
		theStore.addToolToInventory(new ConcreteTool("Concrete Powder"));
		
		// Painting Tools
		theStore.addToolToInventory(new PaintingTool("Paint Roller"));
		theStore.addToolToInventory(new PaintingTool("Mixing Stick"));
		
		// Woodworking Tools
		theStore.addToolToInventory(new WoodworkTool("Mitre Saw"));
		theStore.addToolToInventory(new WoodworkTool("Sawhorse"));
		
		// Yardworking Tools
		theStore.addToolToInventory(new YardworkTool("Rake"));
		theStore.addToolToInventory(new YardworkTool("Wheelbarrow"));
		
		// Plumbing Tools
		theStore.addToolToInventory(new PlumbingTool("Plumbing Wrench"));
		theStore.addToolToInventory(new PlumbingTool("Plunger"));
		
		// Add the Store to the World
		aWholeNewWorld.addStore(theStore);
		
		// Create Customers and add them to the World
		
		Customer timApple = new RegularCustomer("Timothy Apple", theStore);
		aWholeNewWorld.addCustomer(timApple);
		
		Customer billMicrosoft = new CasualCustomer("William Microsoft", theStore);
		aWholeNewWorld.addCustomer(billMicrosoft);
		
		Customer larryGoogle = new BusinessCustomer("Laurence Google", theStore);
		aWholeNewWorld.addCustomer(larryGoogle);
		
		Customer trumanburbank = new RegularCustomer("Truman Burbank", theStore);
		aWholeNewWorld.addCustomer(trumanburbank);
		
		Customer amalikyoaz = new RegularCustomer("Amalik Yoaz", theStore);
		aWholeNewWorld.addCustomer(amalikyoaz);
		
		Customer frankNStein = new RegularCustomer("Frank N Stein", theStore);
		aWholeNewWorld.addCustomer(frankNStein);
		
		Customer mikerotch = new CasualCustomer("Mike Rotch", theStore);
		aWholeNewWorld.addCustomer(mikerotch);
		
		Customer hughjass = new CasualCustomer("Hugh Jass", theStore);
		aWholeNewWorld.addCustomer(hughjass);
		
		Customer willieStroker = new CasualCustomer("Willie Stroker", theStore);
		aWholeNewWorld.addCustomer(willieStroker);
		
		Customer bendover = new BusinessCustomer("Ben Dover", theStore);
		aWholeNewWorld.addCustomer(bendover);
		
		Customer jacksmith = new BusinessCustomer("Jack Smith", theStore);
		aWholeNewWorld.addCustomer(ericshun);
		
		Customer neildown = new BusinessCustomer("Neil Down", theStore);
		aWholeNewWorld.addCustomer(jackknauf);
				
		// Run the simulation for 35 days
		aWholeNewWorld.runSimulation(35);
	}
}

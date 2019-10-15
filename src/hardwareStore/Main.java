package hardwareStore;

public class Main 
{
	public static void main(String[] args)
	{
		World aWholeNewWorld = new World();
		
		Store theStore = new Store("Bartlebee's Hardware Shack");
		
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
		
		aWholeNewWorld.addStore(theStore);
		
		Customer timApple = new RegularCustomer("Timothy Apple", theStore);
		aWholeNewWorld.addCustomer(timApple);
		
		Customer billMicrosoft = new CasualCustomer("William Microsoft", theStore);
		aWholeNewWorld.addCustomer(billMicrosoft);
		
		Customer larryGoogle = new BusinessCustomer("Laurence Google", theStore);
		aWholeNewWorld.addCustomer(larryGoogle);
		
		aWholeNewWorld.runSimulation(35);
	}
}

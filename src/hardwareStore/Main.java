package hardwareStore;

public class Main 
{
	public static void main(String[] args)
	{
		World aWholeNewWorld = new World();
		
		
		Store theStore = new Store("Bartlebee's Hardware Shack");
		theStore.addToolToInventory(new ConcreteTool("Concrete Mixer"));
		theStore.addToolToInventory(new ConcreteTool("Concrete Mixer"));
		theStore.addToolToInventory(new ConcreteTool("Concrete Mixer"));
		theStore.addToolToInventory(new ConcreteTool("Concrete Mixer"));
		theStore.addToolToInventory(new ConcreteTool("Concrete Mixer"));
		theStore.addToolToInventory(new ConcreteTool("Concrete Mixer"));
		theStore.addToolToInventory(new ConcreteTool("Concrete Mixer"));
		theStore.addToolToInventory(new ConcreteTool("Concrete Mixer"));
		theStore.addToolToInventory(new ConcreteTool("Concrete Mixer"));
		theStore.addToolToInventory(new ConcreteTool("Concrete Mixer"));
		aWholeNewWorld.addStore(theStore);
		
		Customer timApple = new RegularCustomer("Timothy Apple", theStore);
		aWholeNewWorld.addCustomer(timApple);
		
		Customer billMicrosoft = new CasualCustomer("William Microsoft", theStore);
		aWholeNewWorld.addCustomer(billMicrosoft);
		
		
		aWholeNewWorld.runSimulation(35);
	}
}

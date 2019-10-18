package hardwareStore;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main 
{
	public static void main(String[] args)
	{
		// Ask the user if they want to output to the console or to a file
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Print to console (c) or create a file (f)?");
		String inputString = "";
		
		try
		{
			inputString = input.readLine();
			
			// Keep asking until the user gives a valid input
			while(!inputString.equalsIgnoreCase("c") && !inputString.equalsIgnoreCase("f"))
			{
				System.out.println("Invalid input: Please input 'c' for console or 'f' for file.");
				inputString = input.readLine();
			}
		} 
		catch (Exception ex)
		{
			System.err.println("An exception occurred while trying to read input:\n" + ex.getStackTrace());
		}
		
		// Output to file if the user input an f
		Boolean outputToFile = inputString.equalsIgnoreCase("f");
		if(outputToFile)
		{
			try
			{
				System.out.println("Printing to hardwarestore.out!");
				PrintStream fileStream = new PrintStream(new FileOutputStream("hardwarestore.out"));
				System.setOut(fileStream);
				
			} 
			catch (Exception ex)
			{
				System.err.println("An exception occurred while trying to create an output file:\n" + ex.getStackTrace());
			}
		}
		
		// Get the World
		World aWholeNewWorld = World.getTheWorld();
		
		// Create a Store
		Store theStore = new Store("Bartlebee's Hardware Shack");
		
		// Create and add tools to the Store
		
		// Concrete Tools
		theStore.addToolToInventory(new ConcreteTool("Concrete Mixer"));
		theStore.addToolToInventory(new ConcreteTool("Concrete Powder"));
		theStore.addToolToInventory(new ConcreteTool("Jackhammer"));
		theStore.addToolToInventory(new ConcreteTool("Concrete Saw"));
		theStore.addToolToInventory(new ConcreteTool("Sledgehammer"));
		
		// Painting Tools
		theStore.addToolToInventory(new PaintingTool("Paint Roller"));
		theStore.addToolToInventory(new PaintingTool("Mixing Stick"));
		theStore.addToolToInventory(new PaintingTool("Paint Brush"));
		theStore.addToolToInventory(new PaintingTool("Tarp"));
		theStore.addToolToInventory(new PaintingTool("Easel"));
		
		// Woodworking Tools
		theStore.addToolToInventory(new WoodworkTool("Mitre Saw"));
		theStore.addToolToInventory(new WoodworkTool("Sawhorse"));
		theStore.addToolToInventory(new WoodworkTool("Hammer"));
		theStore.addToolToInventory(new WoodworkTool("Table Saw"));
		theStore.addToolToInventory(new WoodworkTool("Hand Saw"));
		
		// Yardworking Tools
		theStore.addToolToInventory(new YardworkTool("Rake"));
		theStore.addToolToInventory(new YardworkTool("Wheelbarrow"));
		theStore.addToolToInventory(new YardworkTool("Hoe"));
		theStore.addToolToInventory(new YardworkTool("Lawnmower"));
		theStore.addToolToInventory(new YardworkTool("Sheers"));
		
		// Plumbing Tools
		theStore.addToolToInventory(new PlumbingTool("Plumbing Wrench"));
		theStore.addToolToInventory(new PlumbingTool("Plunger"));
		theStore.addToolToInventory(new PlumbingTool("Industrial Toilet Brush"));
		theStore.addToolToInventory(new PlumbingTool("Blowtorch"));
		
		// Add the Store to the World
		aWholeNewWorld.addStore(theStore);
		
		// Create Customers and add them to the World
		
		Customer timApple = new RegularCustomer("Timothy Apple", theStore);
		aWholeNewWorld.addCustomer(timApple);
		
		Customer billMicrosoft = new CasualCustomer("William Microsoft", theStore);
		aWholeNewWorld.addCustomer(billMicrosoft);
		
		Customer larryGoogle = new BusinessCustomer("Laurence Google", theStore);
		aWholeNewWorld.addCustomer(larryGoogle);
		
		Customer trumanBurbank = new RegularCustomer("Truman Burbank", theStore);
		aWholeNewWorld.addCustomer(trumanBurbank);
		
		Customer marcusFacebook = new RegularCustomer("Marcus Facebook", theStore);
		aWholeNewWorld.addCustomer(marcusFacebook);
		
		Customer frankNStein = new RegularCustomer("Frank N Stein", theStore);
		aWholeNewWorld.addCustomer(frankNStein);
		
		Customer michaelRotch = new CasualCustomer("Michael Rotch", theStore);
		aWholeNewWorld.addCustomer(michaelRotch);
		
		Customer hughJassman = new CasualCustomer("Hugh Jassman", theStore);
		aWholeNewWorld.addCustomer(hughJassman);
		
		Customer williamStroker = new CasualCustomer("William Stroker", theStore);
		aWholeNewWorld.addCustomer(williamStroker);
		
		Customer benjaminDover = new BusinessCustomer("Benjamin Dover", theStore);
		aWholeNewWorld.addCustomer(benjaminDover);
		
		Customer jackSmith = new BusinessCustomer("Jack Smith", theStore);
		aWholeNewWorld.addCustomer(jackSmith);
		
		Customer neilDown = new BusinessCustomer("Neil Down", theStore);
		aWholeNewWorld.addCustomer(neilDown);
				
		// Run the simulation for 35 days
		aWholeNewWorld.runSimulation(35);
	}
}

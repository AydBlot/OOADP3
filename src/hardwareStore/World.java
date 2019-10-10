package hardwareStore;

public class World 
{
	private int currentDay;
	
	
	public World()
	{
		currentDay = 0;
	}
	
	public void startNewDay()
	{
		currentDay++;
		
		// TODO: Stores and customers need to do their things for the day here
	}
	
	public void runSimulation(int days)
	{
		while(currentDay < days)
		{
			startNewDay();
		}
	}
}

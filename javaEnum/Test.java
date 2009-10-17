public class Test
{
	public static void main (String [] args)
	{
		new Test().runMe();
	}

	public void runMe()
	{
		Season someSeason = getSeason();

		System.out.println ("Printing out the season we got from getSeason...");
		System.out.println (someSeason);

		// note that we can switch on Enums.
		switch (someSeason)
		{
			case WINTER:
				// do something for winter...
				break;
			case SUMMER:
				// do something for summer...
				break;
			case FALL:
				// do something for fall...
				break;
			case SPRING:
				// do something for spring...
				break;
			default:
				System.out.println ("Unknown Season!");
		}

		// we can also iterate over all values in an enum
		System.out.println ("Iterating over all seasons...");
		for (Season s : Season.values())
			System.out.println (s);
	}

	// example showing returning an enum type from a method
	public Season getSeason ()
	{
		return Season.WINTER; 
	}
}

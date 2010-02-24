public class InterfaceTester
{
	public static void main (String [] args)
	{
		MeaningOfLife [] theTruths = new MeaningOfLife[3];
		theTruths[0] = new DouglasAdams();
		theTruths[1] = new Buddha();
		theTruths[2] = new MontyPython();

		System.out.println ("Some answers to the meaning of life:");
		for (int x = 0; x < theTruths.length; x++)
			System.out.println (theTruths[x].getClass().getName() + " says '" + 
				theTruths[x].giveMeTheAnswer() + "'");
	}
}

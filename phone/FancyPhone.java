import java.util.*;

public class FancyPhone
{
	// create a 2D array such that the 0th element corresponds to all letters
	// 0 can be mapped to, the 1st element to all letters 1 can be mapped to,
	// the 2nd all letter that 2 can be mapped to, etc. 
	static final char [][] mappings = {
		{0}, 
		{1},
		{'A', 'B', 'C'}, 
		{'D', 'E', 'F'},
		{'G', 'H', 'I'},
		{'J', 'K', 'L'},
		{'M', 'N', 'O'},
		{'P', 'Q', 'R', 'S'},
		{'T', 'U', 'V'},
		{'W', 'X', 'Y', 'Z'}
	};

	public static void main (String [] args)
	{
		String phoneNum = "2232337";
		ArrayList<String> words = doPhone (phoneNum);
		Collections.sort (words);

		System.out.println ("All word combinations for " + phoneNum);
		System.out.println ("--------------------------------------");
		for (String s : words)
			System.out.println (s);
	}

	public static ArrayList<String> doPhone (String phoneNum)
	{
		ArrayList <String> rv = new ArrayList<String>(); 
		processPhone ("", phoneNum, rv);
		return rv;
	}

	public static void processPhone (String wordSoFar, String phoneRemaining, ArrayList <String> rv)
	{
		// base case, if there's no more digits in the phone number, we're done
		// so add the word to the list
		if (phoneRemaining.length() == 0)
			rv.add (wordSoFar);
		else
		{
			// otherwise handle the next digit of the phone number
			int next = Integer.parseInt(phoneRemaining.substring(0,1));
			phoneRemaining = phoneRemaining.substring (1);

			// for each letter that the digit can be mapped to, recursively
			// generate that word
			for (int x = 0; x < mappings[next].length; x++)
				processPhone (wordSoFar + mappings[next][x], phoneRemaining, rv); 
		}
	}
}

import java.util.*;

public class Phone
{
	// an array to hold the words we find.  If the phone number is
	// 7 digits long, then the maximum number of words would be 4^7
	// == 16,384.  Why? -- because each digit can be mapped to as many
	// as 4 different characters (7 can be associated with 'P', 'Q', 
	// 'R', and 'S'), and there's 7 digits, so that's:
	//
	// 4 * 4 * 4 * 4 * 4 * 4 * 4 == 4^7 == 16,384
	//
	// different possible permutations.
	static String [] words = new String[16384];

	// the index into the words array where we should store the next word.
	static int next = 0;

	public static void main (String [] args)
	{
		String phoneNum = "2232337";
		processPhone ("", phoneNum);

		System.out.println ("All word combinations for " + phoneNum);
		System.out.println ("--------------------------------------");

		for (int x = 0; x < next; x++)
			System.out.println (words[x]);
	}

	public static void processPhone (String wordSoFar, String phoneRemaining)
	{
		// base case, if there's no more digits in the phone number, 
		// we're done so add the word to the array. 
		if (phoneRemaining.length() == 0)
		{
			words[next] = wordSoFar;

			// increment to the next slot in the array
			next++;
		}
		else
		{
			// otherwise, get the next digit, and process it recursively
			char next = phoneRemaining.charAt(0);
			phoneRemaining = phoneRemaining.substring (1);

			if (next == '2')
			{
				processPhone (wordSoFar + "A", phoneRemaining); 
				processPhone (wordSoFar + "B", phoneRemaining); 
				processPhone (wordSoFar + "C", phoneRemaining); 
			}
			else if (next == '3')
			{
				processPhone (wordSoFar + "D", phoneRemaining); 
				processPhone (wordSoFar + "E", phoneRemaining); 
				processPhone (wordSoFar + "F", phoneRemaining); 
			}
			else if (next == '4')
			{
				processPhone (wordSoFar + "G", phoneRemaining); 
				processPhone (wordSoFar + "H", phoneRemaining); 
				processPhone (wordSoFar + "I", phoneRemaining); 
			}
			else if (next == '5')
			{
				processPhone (wordSoFar + "J", phoneRemaining); 
				processPhone (wordSoFar + "K", phoneRemaining); 
				processPhone (wordSoFar + "L", phoneRemaining); 
			}
			else if (next == '6')
			{
				processPhone (wordSoFar + "M", phoneRemaining); 
				processPhone (wordSoFar + "N", phoneRemaining); 
				processPhone (wordSoFar + "O", phoneRemaining); 
			}
			else if (next == '7')
			{
				processPhone (wordSoFar + "P", phoneRemaining); 
				processPhone (wordSoFar + "Q", phoneRemaining); 
				processPhone (wordSoFar + "R", phoneRemaining); 
				processPhone (wordSoFar + "S", phoneRemaining); 
			}
			else if (next == '8')
			{
				processPhone (wordSoFar + "T", phoneRemaining); 
				processPhone (wordSoFar + "U", phoneRemaining); 
				processPhone (wordSoFar + "V", phoneRemaining); 
			}
			else if (next == '9')
			{
				processPhone (wordSoFar + "W", phoneRemaining); 
				processPhone (wordSoFar + "X", phoneRemaining); 
				processPhone (wordSoFar + "Y", phoneRemaining); 
				processPhone (wordSoFar + "Z", phoneRemaining); 
			}
			else // must be 0 or 1, so just add this digit to the word
				processPhone (wordSoFar + next, phoneRemaining);
		}
	}
}

/*

Interesting exploration of Java's implicit casting rules (or lack thereof) between strings
and characters.

*/

public class CharString 
{
	public static void main (String [] args)
	{
		String bar;

		bar = "A";

		Character a = new Character ('A');

		// explicitly convert the character to a string, works fine
		// but seems redundant
		System.out.println ((bar.equals (a.toString()) ? "true" : "false"));

		// however if we just pass a Character, the comparison fails, 
		// as the equals method isn't smart enough to call toString on
		// the character and compare strings (rightfully so). 
		System.out.println ((bar.equals (a) ? "true" : "false"));

		// and of course direct comparison fails, since Java does strict
		// type checking, and Character and String are different types.
		// thus the following line will not compile
		// System.out.println ((bar == a ? "true" : "false"));
		
		// Now where it gets really stupid:

		// The String class' constructor is not overloaded to accept a
		// character object, and thus the following line is illegal
		// String foo = new String (a);

		// To do the above you need to call the toString() method of
		// the characcter like so, so that the String class' copy
		// constructor gets called:
		String foo = new String (a.toString());

		// Note that it's the same with the primitive type char as well:
		// String fromaChar = new String ('a'); // illegal
	}
}

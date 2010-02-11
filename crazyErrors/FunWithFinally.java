/**
 * Goofy fun with the finally statement.
 *
 * @author Adam Parkin
*/

public class FunWithFinally
{

	public static void main (String [] args)
	{
		System.out.println (foo());	// prints -1, not 42

		// the following is actually an infinite loop
		while (true)
		{
			try {
				System.out.println ("Still in loop...");
				break;
			} finally {
				continue;
			}
		}
	}

	/*
	 * Note that finally overrides a return statement.  Thus, if a regular
	 * return statement is inside a try block, and the finally block associated
	 * with that try block has a return statement the value returned inside the
	 * try will never be passed to the caller of the method.
	*/
	public static int foo ()
	{
		for (;;)
		{
			try {
				return 42;
			} finally {
				return -1;
			}
		}
	}
}

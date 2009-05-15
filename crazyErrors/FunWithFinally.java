
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

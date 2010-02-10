import java.util.*;

public class Fibonacci 
{
	public static void main (String [] args)
	{
		new Fibonacci().runMe();
	}

	public void runMe()
	{
		for (int x = 1; x <= 12; x++)
			System.out.println ("fibIter(" + x + ") == " + fibIter (x) + 
				" and fibRec(" + x + ") == " + fibRec(x));
	}

	public int fibRec (int n)
	{
		if (n <= 2)
			return 1;

		return fibRec (n-1) + fibRec (n-2);
	}

	public int fibIter (int n)
	{
		int n1 = 1, n2 = 1; // n1 represents fib(n-1) and n2 represents fib(n-2)
		int cur = 1;	// cur represents fib (n)

		for (int x = 3; x <= n; x++) 
		{
			// calculate next fib num
			cur = n1 + n2;	

			// update the previous two fib numbers
			n1 = n2;	
			n2 = cur;
		}

		return cur;
	}
} 

/**
 * The Covariance problem in Java.
 *
 * @author Adam Parkin
*/
public class Covariance 
{
	public class A
	{
		public int x;

		void display ()
		{
			System.out.println ("A display");
		}
	}

	public class B extends A
	{
		void display ()
		{
			System.out.println ("B display " + x);
		}
	}

	public void runMe()
	{

		A [] aS = new A[10];
		B [] bS = new B[10];

		bS[0] = new B();
		bS[0].x = 42;

		aS = bS;	// valid since A is a superclass of B
		
		aS[0].display();
		aS[0] = new B();
		aS[0].x = 113;
		bS[0].display();

		aS[1] = new A();	// causes an ArrayStoreException, as
					// aS is the same reference as bS, which
					// is of type B[] (an array of B's).
	}

	public static void main(String[] args)
	{
		new Covariance().runMe();
	}
}

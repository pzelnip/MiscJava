/**
 * GenericTest - a simple program showing the use of Java generics and a
 * few "gotchas" associated with them in regards to static data members.
 *
 * @author Adam Parkin
*/

public class GenericTest<E>
{
	// Static count of instances
	public static int count = 0;
	public E value;

	// each time an instance is created, the count is incremented
	public GenericTest()
	{
		count++;
	}

	public static void main (String [] args)
	{
		// 0 instances
		System.out.println (count);

		GenericTest<String> g = new GenericTest<String>();

		// 1 instance
		System.out.println (count);

		GenericTest<Integer> g2 = new GenericTest<Integer>();

		// 2 instances
		System.out.println (count);

		/*
		note that GenericTest<String> and GenericTest<Integer> are
		the *SAME CLASS*, so count is shared between the two.

		This is fundamentally the big difference between C++ templates
		and Java generics.  With Generics a generified type is resolved
		to a single individual type at compile time.  With templates,
		a separate templated type is created at compile time for each
		parameter (so if you have a "MyTempType<int>" and "MyTempType<String>"
		there will be two separate classes created (which happen to have
		the same methods)

		This is also the reason that GenericTest<Object> is not a supertype
		of GenericTest<String> -- they are in fact the same type, but have
		a different type "attribute".
		*/
	}
}

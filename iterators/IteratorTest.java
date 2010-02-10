/**
 * A simple test showing how to define and use Java Iterators.
 * As an example of an iterator, we'll implement a class which
 * encapsulates an array of ints.  The iterator will iterate
 * through this array.
 *
 * @author Adam Parkin
 */

import java.util.*; 

/*
Note that iterators are closely related to generics.  The type
specifier below indicates that our iterator will operate over
Integers.  You can avoid the use of generics alltogether with
iterators, however, then you would be limited to having your
Iterators return Objects rather than any specific type. 
*/
public class IteratorTest implements Iterable<Integer>
{
	int [] vals;

	// if a class implements iterable, it must provide an
	// implementation of the iterator() method.  Providing
	// this also allows your class to be used with the newer
	// "foreach" style for loop
	public Iterator<Integer> iterator()
	{
		return new MyIterator();
	}

	// Oftentimes Iterators are defined as non-static private nested classes
	private class MyIterator implements Iterator<Integer>
	{
		// Iterators must implement three methods: hasNext, next
		// and remove (though remove is often implemented such that
		// it simply throws a OperationNotSupportedException

		int index = 0;

		// Return true if there are more items
		public boolean hasNext()
		{
			return index < vals.length;
		}

		// return the current value and increment to the next
		public Integer next ()
		{
			return (vals[index++]);
		}

		// this is the suggested behaviour for remove().  Why they 
		// included it as part of the interface for itearator is
		// a bit puzzling to me.
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * Test out the iterator.
	 */
	public static void main (String [] args)
	{
		// Lets use them:
		IteratorTest it = new IteratorTest();

		// use the iterator explicitly
		Iterator<Integer> i = it.iterator();
		System.out.println ("Using iterator manually:");
		while (i.hasNext())
		{
			Integer value = i.next();
			System.out.println (value + " is " + value.toHexString(value.intValue()) + " in hex");
		}
		
		// or we can use the foreach syntax if IteratorTest implements Iterable
		System.out.println ("\nUsing foreach:");
		for (Integer value : it)
			System.out.println (value + " is " + value.toHexString(value.intValue()) + " in hex");
	}

	/**
	 * Default constructor which fills the internal array with random values.
	 */
	public IteratorTest ()
	{
		vals = new int[10];
		for (int x = 0; x < vals.length; x++)
			vals[x] = x * 4 + 2;
	}
}

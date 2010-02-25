/**
 * The Stack class represents a last-in-first-out (LIFO) collection of ints. 
 * The usual push and pop operations are provided, as well as a method to 
 * peek at the top item on the stack, and a method to test for whether the 
 * stack is empty.
 * 
 * When a stack is first created, it contains no items. 
 *
 * @author Adam Parkin
*/

import java.util.*;

public class GenericListStack<E> 
{
	LinkedList<E> items = new LinkedList<E>();

	/**
	 * Add (push) the supplied value to the end of the stack.  A 
	 * StackFullException is thrown if the stack cannot accept
	 * any more items.
	 * 
	 * @param value	the value to put into the stack
	 * @throws StackFullException
	 */
	public void push (E value)
	{
		items.add (0, value);
	}

	/**
	 * Removes and returns the last value pushed onto this stack.  A
	 * StackEmptyException is thrown if the stack is empty.
	 *
	 * @return the value formerly at the top of the stack
	 * @throws StackEmptyException
	 */
	public E pop () throws StackEmptyException
	{
		if (items.size() == 0) throw new StackEmptyException ("Can't pop");
		return items.removeFirst();
	}

	/**
	 * Returns (but does not remove) the last value pushed onto this 
	 * stack.  A StackEmptyException is thrown if the stack is empty.
	 *
	 * @return the value at the top of the stack
	 * @throws StackEmptyException
	 */
	public E peek () throws StackEmptyException
	{
		if (items.size() == 0) throw new StackEmptyException ("Can't peek");
		return items.get(0);
	}

	/**
	 * Returns true if this stack contains no items, false otherwise.
	 *
	 * @return 	<code>true</code> if this stack contains no items,
	 *		<code>false</code> otherwise.
	 */
	public boolean isEmpty()
	{
		return items.size() == 0; 
	}

	public static void main (String [] args)
	{

		GenericListStack <Integer> s = new GenericListStack<Integer>();

		try
		{
			// Stack is empty so the lines below should trigger a
			// StackEmptyException
			// s.peek();
			// s.pop();

			for (int x = 5; x < 15; x++)
				s.push (x);

			System.out.println ("Peek test 1 (should be 14): " + s.peek());
			System.out.println ("Peek test 2 (should be 14): " + s.peek());
			System.out.println ("Pop test 1 (should be 14): " + s.pop());
			System.out.println ("Peek test 3 (should be 13): " + s.peek());

			while (!s.isEmpty())
				System.out.println (s.pop());

			for (int x = 0; x < 100; x++)
				s.push(x);
			
		}
		catch (StackEmptyException e)
		{
			System.out.println ("Caught a stack empty exception: " + e.getMessage());
		}
	}
}

/**
 * Thrown by the Stack class to indicate the stack contains no items
 */
class StackEmptyException extends Exception
{
	public StackEmptyException ()
	{
		super();
	}

	public StackEmptyException (String s)
	{
		super (s);
	}
}


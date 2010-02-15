import java.util.*;

/**
 *   A simple implementation of a binary search tree.
 *   The tree needs to accept and store a Comparator object that defines
 *   how to order the (generic, type-T) values inserted into the tree.
 *
 * @author Rhodes Brown
 * @author Adam Parkin
 */

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> 
{
	private Node root;

	/**
	 * Creates an empty Binary Search Tree.
	*/
	public BinarySearchTree ()
	{
		root = null; // hey, why not?
	}

	/**
	 * Creates a BST containing the values stored in array
	*/
	public BinarySearchTree (T [] array)
	{
		for (int x = 0; x < array.length; x++)
			this.add (array[x]);
	}

	/**
	 * Creates a BST containing the values contained in the supplied 
	 * Collection.
	 *
	 * @param col	a collection of values
	*/
	public BinarySearchTree (Collection<T> col)
	{
		for (T val : col)
			this.add(val);
	}

	/**
	 * Return an iterator for this BST.  This method returns an
	 * <b>In-Order</b> iterator, for pre and post order traversals
	 * use the <code>preOrderIterator()</code> and 
	 * <code>postOrderIterator()</code> methods respectively.
	 *
	 * @return 	an in-order iterator for this BST
	 * @see		BinarySearchTree#postOrderIterator() 
	 * @see		BinarySearchTree#preOrderIterator() 
	 * @see		BinarySearchTree#inOrderIterator() 
	*/
	public Iterator<T> iterator()
	{
		return inOrderIterator(); 
	}

	/**
	 * Return an in-order iterator for this BST. Note that this
	 * method is equivalent to <code>iterator()</code>. 
	 * For pre and post order traversals
	 * use the <code>preOrderIterator()</code> and 
	 * <code>postOrderIterator()</code> methods respectively.
	 *
	 * @return 	an in-order iterator for this BST
	 * @see		BinarySearchTree#postOrderIterator() 
	 * @see		BinarySearchTree#preOrderIterator() 
	 * @see		BinarySearchTree#iterator() 
	*/
	public Iterator<T> inOrderIterator()
	{
		return new InOrderIterator();
	}

	/**
	 * Return a pre-order iterator for this BST. 
	 * For post and in order traversals
	 * use the <code>postOrderIterator()</code> and 
	 * <code>inOrderIterator()</code> methods respectively.
	 *
	 * @return 	an in-order iterator for this BST
	 * @see		BinarySearchTree#postOrderIterator() 
	 * @see		BinarySearchTree#inOrderIterator() 
	 * @see		BinarySearchTree#iterator() 
	*/
	public Iterator<T> preOrderIterator()
	{
		return new PreOrderIterator();
	}

	/**
	 * Return a post-order iterator for this BST. 
	 * For pre and in order traversals
	 * use the <code>preOrderIterator()</code> and 
	 * <code>inOrderIterator()</code> methods respectively.
	 *
	 * @return 	an in-order iterator for this BST
	 * @see		BinarySearchTree#preOrderIterator() 
	 * @see		BinarySearchTree#inOrderIterator() 
	 * @see		BinarySearchTree#iterator() 
	*/
	public Iterator<T> postOrderIterator()
	{
		return new PostOrderIterator();
	}

	/**
	 * Return the height of this BST.
	 *
	 * @return the height (length of the path from root to deepest leaf)
	*/
	public int height ()
	{
		return (isEmpty() ? 0 : root.height());
	}

	/**
	 * Check if a given value exists in this BST.
	 *
 	 * @param value	the value to look for
	 * @return	<code>true</code> if value exists in this BST 
	 * 		<code>false</code> otherwise
	*/
	public boolean exists (T value)
	{
		return (root.find (value) != null);
	}

	/**
	 * Find the smallest value in this BST.  The meaning of "smallest"
	 * is determined by the compareTo method of the type of value stored
	 * in this BST.
	 *
	 * @return the smallest value in this BST
	*/
	public T minValue ()
	{
		return minValue(root);
	}

	// private helper method
	private T minValue (Node r)
	{
		if (r.left != null)
			return minValue(r.left);
		else	
			return r.value;
	}

	/**
	 * Find the largest value in this BST.  The meaning of "largest"
	 * is determined by the compareTo method of the type of value stored
	 * in this BST.
	 *
	 * @return the largest value in this BST
	*/
	public T maxValue ()
	{
		return maxValue (root);
	}

	// private helper method
	private T maxValue (Node r)
	{
		if (r.right != null)
			return maxValue(r.right);
		else	
			return r.value;
	}

	/**
	 * Check if this tree is equal to another.  Two BST's are equal if
	 * they are structurally equal, with the same values in the same nodes.
	 *
	 * @param bstIn	the tree to compare with this tree
	 * @return	<code>true</code> if bstIn is equal to this BST 
	 * 		<code>false</code> otherwise
	*/
	public boolean equals(BinarySearchTree<T> bstIn)
	{
		return equals(bstIn.root, root);
	}

	// private helper method
	private boolean equals(Node aRoot, Node bRoot)
	{
		// if the same tree then they are identical
		if (aRoot == bRoot)
			return true;

		// ASSERT (aRoot != bRoot)

		// if one is null, the other can't be, so they're not equal
		if (aRoot == null || bRoot == null)
			return false;

		// ASSERT (aRoot != null && bRoot != null)

		// the trees are equal if the value at the roots are equal
		// and the left and right subtrees are equal

		return (aRoot.value.compareTo(bRoot.value) == 0) && 
			equals (aRoot.left, bRoot.left) &&
			equals (aRoot.right, bRoot.right);
	}

	/**
	 * Return the number of elements in this BST.
	 *
	 * @return the number of elements stored in this BST
	 */
	public int size ()
	{
		return (isEmpty() ? 0 : root.size());
	}

	/** 
	 * Check if this tree is empty
	 *
	 * @return	<code>true</code> if this BST contains no items 
	 * 		<code>false</code> otherwise
	*/
	public boolean isEmpty() {
		return ( root == null );
	}

	/** 
	 * Insert the given value into this tree using the comparator's order. 
	 * 
	 * @param value	the item to insert into this BST
	 */
	public void add(T value) {
		if ( this.isEmpty() )
			root = new Node(value);
		else
			// recursively attempt to insert the value, starting at the root:
			root.insert(value);
	}

	/** 
	 * Get a String representation of this tree. 
	 *
	 * @return a string representation of this BST.
	*/
	public String toString() {
		if ( this.isEmpty() )
			return "";
		else
			// recursively build a String, starting at the root:
			return root.toString();
	}

	private class PreOrderIterator implements Iterator<T>
	{
		private Stack<Node> returnStack;

		public PreOrderIterator ()
		{
			returnStack = new Stack<Node>();

			if (root != null)
				returnStack.push(root);
		}

		public boolean hasNext()
		{
			return !returnStack.empty(); 
		}

		public T next ()
		{
			if (!hasNext()) throw new NoSuchElementException();

			Node next = returnStack.pop();
			T val = next.value;

			if (next.right != null)
				returnStack.push (next.right);
			if (next.left != null)
				returnStack.push(next.left);
			
			return val;
		}

		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * An example of doing a PostOrder traversal iteratively without using a 
	 * "visited" attribute.
	 *
	 * @see <a href="http://discuss.joelonsoftware.com/default.asp?interview.11.318495.11">http://discuss.joelonsoftware.com/default.asp?interview.11.318495.11</a>
	*/
	private void postOrder ()
	{
		Stack<Node> stack = new Stack<Node>();
		Node node = root;

		while (node != null || !stack.empty())
		{
			if (node == null)
			{
				while (!stack.empty() && node == stack.peek().right)
				{
					node = stack.pop();
					System.out.println (node.value + " ");
				}
				node = (stack.empty() ? null : stack.peek().right);
			}
			if (node != null)
			{
				stack.push(node);
				node = node.left;
			}
		}
	}

	/**
	 * A PostOrder iterator for our BST.  Note that doing a postorder traversal
	 * iteratively is nontrivial.  Most implementations rely on a "visited"
	 * field to be added to each node.  It is possible to do it without this
	 * attribute, but then becomes difficult to implement in a "continuation"
	 * style that an iterator requires (how do you pick up where you left off?)
	 * So as a simple compromise, we just do a natural full recursive postorder 
	 * traversal of the BST in the constructor, where we add visited values to
	 * a vector.  Then we can just wrap a vector iterator in our PostOrderIterator
	 * class.
	 * 
	 * The downside to this approach is that our iterator will require O(n) space
	 * where n is the number of elements in our BST.  
	*/ 
	private class PostOrderIterator implements Iterator<T>
	{
		private Vector<T> vals = new Vector<T>();
		Iterator<T> i;

		public PostOrderIterator ()
		{
			postOrder (root);
			i = vals.iterator();
		}

		private void postOrder (Node n)
		{
			if (n.left != null)
				postOrder (n.left);

			if (n.right != null)
				postOrder (n.right);

			vals.add(n.value);
		}

		public boolean hasNext()
		{
			return i.hasNext();
		}

		public T next ()
		{
			if (!hasNext()) throw new NoSuchElementException();

			return i.next();
		}

		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}

	private class InOrderIterator implements Iterator<T>
	{
		private Vector<T> vals = new Vector<T>();
		Iterator<T> i;

		public InOrderIterator ()
		{
			inOrder (root);
			i = vals.iterator();
		}

		private void inOrder (Node n)
		{
			if (n.left != null)
				inOrder (n.left);

			vals.add(n.value);

			if (n.right != null)
				inOrder (n.right);
		}

		public boolean hasNext()
		{
			return i.hasNext();
		}

		public T next ()
		{
			if (!hasNext()) throw new NoSuchElementException();

			return i.next();
		}

		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * A simple binary search tree node.
	 *
	 * This is an inner class, so instances have access to the methods
	 * and fields of the outer BinarySearchTree object.
	 */
	private class Node {
		T value;
		Node left, right;

		Node(T value) {
			this.value = value;
		}

		/**
		 * Search for value inside the tree.  Return a reference
		 * to the Node containing it if it is, null otherwise.
		 */
		Node find (T value)
		{
			int result = this.value.compareTo (value);

			if (result == 0)
				return this;
			else if (result > 0)
				return (this.left != null ? this.left.find (value) : null);
			else
				return (this.right != null ? this.right.find (value) : null);
		}

		/**
		 * Using the tree's definition of "order" (its comparator),
		 * insert the given value in the sub-tree rooted at this node.
		 */
		void insert(T value) {
			int result = this.value.compareTo (value);

			// if already in tree, do nothing
			if (result == 0)
				return;

			// else if less than current value, put in left subtree
			else if (result > 0)
				if(this.left==null)
					this.left = new Node(value);
				else
					this.left.insert(value);

			// else put in right subtree
			else
				if (this.right == null)
					this.right = new Node(value);
				else
					this.right.insert(value);
		}

		int size()
		{
			return 1 + (this.left == null ? 0 : this.left.size()) 
				+ (this.right == null ? 0 : this.right.size());
		}

		int height ()
		{
			int lheight = (this.left == null ? 0 : this.left.height());
			int rheight = (this.right == null ? 0 : this.right.height());
		
			return 1 + (lheight > rheight ? lheight : rheight); 
		}

		/**
		 * Build a String representation of the sub-tree rooted at this node
		 * using a (recursive) in-order traversal. Try to remove "L:[]" if
		 * you have difficulty to understand the output.
		 */
		public String toString() {
			StringBuilder s = new StringBuilder();

			// recursively construct a string for the left sub-tree:
			if ( left != null )
				s.append("L:[").append(left.toString()).append("] ");

			// include the value at this node:
			s.append(value.toString());

			// recursively construct a string for the right sub-tree:
			if ( right != null )
				s.append(" R:[").append(right.toString()).append(']');

			return s.toString();
		}
	}

	public static void main(String[] args)
	{
		BinarySearchTree <String> bst = new BinarySearchTree<String>();
		bst.add("String");
		bst.add("Another");
		bst.add("Bannana");
		bst.add("Peach");
		bst.add("Adam");
		bst.add("Car");
		System.out.println(bst);
		System.out.println ("Height is : " + bst.height());
		System.out.println ("Size is : " + bst.size());
		System.out.println ("Adam " + (bst.exists("Adam") ? "is" : "is not") +
			" in the tree");
		System.out.println ("Frankenstein " + (bst.exists("Frankenstein") ? "is" : "is not") +
			" in the tree");

		BinarySearchTree <Integer> bst2 = new BinarySearchTree<Integer>();
		bst2.add (new Integer(42));
		bst2.add (new Integer(84));
		bst2.add (new Integer(14));
		bst2.add (new Integer(420));
		System.out.println(bst2);

		System.out.println ("------------------------");
		bst2.postOrder();
		System.out.println ("------------------------");
		
		for (Integer i : bst2)
			System.out.print (i + " ");

		System.out.println ("]");
		System.out.println ("Height is : " + bst2.height());
		System.out.println ("Size is : " + bst2.size());
		System.out.println ("42 " + (bst2.exists(new Integer (42)) ? "is" : "is not") +
			" in the tree");
		System.out.println ("666 " + (bst2.exists(new Integer (666)) ? "is" : "is not") +
			" in the tree");
		System.out.println ("The smallest value in bst2 is: " + bst2.minValue());

		BinarySearchTree <Double> bst3 = new BinarySearchTree <Double>();
		System.out.println ("bst3 " + (bst3.isEmpty() ? "is" : "is not") + " empty");
		bst3.add (new Double (Math.PI));
		bst3.add (new Double (42.0));
		bst3.add (new Double (Math.E));
		System.out.println ("bst3 " + (bst3.isEmpty() ? "is" : "is not") + " empty");

		System.out.println ("bst and bst2 " + 
			(bst.equals (bst2) ? "are" : "are not") + " equal");

		System.out.println ("bst and bst " + 
			(bst.equals (bst) ? "are" : "are not") + " equal");
		BinarySearchTree <Integer> it1 = new BinarySearchTree <Integer>();
		BinarySearchTree <Integer> it2 = new BinarySearchTree <Integer>();

		int [] ar = {552, 23, 42, 29, 30, 31, 10, 84};
		for (int x = 0; x < ar.length; x++)
		{
			it1.add (ar[x]);
			it2.add (ar[x]);
		}
		
		System.out.println ("it1 and it2 " + 
			(it1.equals (it2) ? "are" : "are not") + " equal");

		Integer [] vals = {42, 24, 13, 111, 278, 9}; 
		BinarySearchTree <Integer> fromArray = new BinarySearchTree <Integer> (vals);
		for (Integer i : fromArray)
			System.out.print (i + " ");
		System.out.println ("");

		Vector<Integer> vInts = new Vector<Integer>();
		Random r = new Random (42);
		for (int x = 0; x < 10; x++)
			vInts.add (r.nextInt(100));
		BinarySearchTree <Integer> fromCollection = new BinarySearchTree <Integer> (vInts);
		for (Integer i : fromCollection)
			System.out.print (i + " ");
		System.out.println ("");
	}
}

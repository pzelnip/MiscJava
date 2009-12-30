import java.util.Stack;

/* Adapted from Rhodes Brown. Modified for this lab.
 * Author: Rhodes Brown (wild crazy significant changes by Adam Parkin)
 *
 * Description:
 *   A simple (and incomplete) implementation of a binary search tree.
 *   The tree needs to accept and store a Comparator object that defines
 *   how to order the (generic, type-T) values inserted into the tree.
 *   The inner Node class needs to implement an insert operation that uses
 *   the tree's comparator to decide whether to put a value in the left
 *   or right sub-tree.
 */


/**
 * A Binary Search Tree over generic value types.
 */
public class BinarySearchTree<T extends Comparable<T>> {

	private Node root;

	public BinarySearchTree( ) {
		root = null; // redundant, but doesn't hurt
	}

	public int height ()
	{
		return (isEmpty() ? 0 : root.height());
	}

	public boolean exists (T value)
	{
		return (root.find (value) != null);
	}

	public T minValue ()
	{
		return minValue(root);
	}

	private T minValue (Node r)
	{
		if (r.left != null)
			return minValue(r.left);
		else	
			return r.value;
	}

	public T maxValue ()
	{
		return maxValue (root);
	}

	private T maxValue (Node r)
	{
		if (r.right != null)
			return maxValue(r.right);
		else	
			return r.value;
	}

	public void remove (T val)
	{
		return;
		Node n = root.find (val);
		if (n != null)
			remove (val, n);
	}

	private void remove (T val, Node n)
	{
		if (n.left == null && n.right == null)
			// delete the node from the parent
	}

	public boolean equals(BinarySearchTree<T> bstIn)
	{
		return equals(bstIn.root, root);
	}

	public boolean equals(Node aRoot, Node bRoot)
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

	public BinarySearchTree<T> mirror ()
	{
		BinarySearchTree<T> ret = new BinarySearchTree<T>();
		if (!isEmpty()) 
			ret.root = mirror (root);
		return ret;
	}

	private Node mirror (Node r)
	{
		Node newRoot = new Node (r.value);
		if (r.right != null) newRoot.left = mirror (r.right);
		if (r.left != null) newRoot.right = mirror (r.left);
		return newRoot;
	}

	public int size ()
	{
		return (isEmpty() ? 0 : root.size());
	}

	/** Is this tree empty? */
	public boolean isEmpty() {
		return ( root == null );
	}

	/** Insert the given value into this tree using the comparator's order. */
	public void add(T value) {
		if ( this.isEmpty() )
			root = new Node(value);
		else
			// recursively attempt to insert the value, starting at the root:
			root.insert(value);
	}

	/** Get a String representation of this tree. */
	public String toString() {
		if ( this.isEmpty() )
			return "";
		else
			// recursively build a String, starting at the root:
			return root.toString();
	}

	public void preOrder (Operation<T> fn)
	{
		preOrder (root, fn);
	} 

	private void preOrder (Node r, Operation<T> fn)
	{
		fn.apply (r.value);

		if (r.left != null)
			preOrder (r.left, fn);

		if (r.right != null)
			preOrder (r.right, fn);
	}

	public void inOrder (Operation<T> fn)
	{
		inOrder (root, fn);
	}

	private void inOrder (Node r, Operation <T> fn)
	{
		if (r.left != null)
			inOrder (r.left, fn);

		fn.apply (r.value);

		if (r.right != null)
			inOrder (r.right, fn);
	}

	public void postOrder (Operation<T> fn)
	{
		postOrder (root, fn);
	}

	private void postOrder (Node r, Operation <T> fn)
	{
		if (r.left != null)
			postOrder (r.left, fn);

		if (r.right != null)
			postOrder (r.right, fn);

		fn.apply (r.value);
	}


	/**
	 * A simple binary search tree node.
	 *
	 * NOTE:
	 * This is an inner class, so instances have access to the methods
	 * and fields of the outer BinarySearchTree object.
	 */
	protected class Node {
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

		// added by Adam Parkin
		int size()
		{
			return 1 + (this.left == null ? 0 : this.left.size()) 
				+ (this.right == null ? 0 : this.right.size());
		}

		// added by Adam Parkin
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

		Operation <Double> od = new OpAddDouble();
		bst3.inOrder (od);
		System.out.println ("Sum of values in bst3: " + od.getResult()); 

		BinarySearchTree <String> bstOrderTest = new BinarySearchTree <String>();
		bstOrderTest.add ("F");
		bstOrderTest.add ("B");
		bstOrderTest.add ("A");
		bstOrderTest.add ("D");
		bstOrderTest.add ("C");
		bstOrderTest.add ("E");
		bstOrderTest.add ("G");
		bstOrderTest.add ("I");
		bstOrderTest.add ("H");

		Operation<String> o = new OpToPrettyString<String>();
		bstOrderTest.inOrder (o);
		System.out.println ("In Order: " + o.getResult());

		o = new OpToPrettyString<String>();
		bstOrderTest.preOrder (o);
		System.out.println ("Pre Order (should be F-B-A-D-C-E-G-I-H): " + o.getResult());

		o = new OpToPrettyString<String>();
		bstOrderTest.postOrder (o);
		System.out.println ("Post Order (should be A-C-E-D-B-H-I-G-F): " + o.getResult());

		o = new OpToPrettyString<String>();
		bstOrderTest.mirror().inOrder(o);
		System.out.println ("Mirror Test: " + o.getResult());

		OpPushToStack<Integer> oi = new OpPushToStack<Integer>();
		bst2.inOrder(oi);
		Stack<Integer> si = oi.getStack(); 
		System.out.println ("Stack: " + si);

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
	}
}

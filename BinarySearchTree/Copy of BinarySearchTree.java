/* Adapted from Rhodes Brown. Modified for this lab.
 * Author: Rhodes Brown
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
public class BinarySearchTree {

	private Node root;

	public BinarySearchTree( ) {

	}

	// added by Adam Parkin
	public int height ()
	{
		return (root == null ? 0 : root.height());
	}

	public boolean inTree (String value)
	{
		return (root.find (value) != null);
	}

	// added by Adam Parkin
	public int size ()
	{
		return (root == null ? 0 : root.size());
	}

	/** Is this tree empty? */
	public boolean isEmpty() {
		return ( root == null );
	}

	/** Insert the given value into this tree using the comparator's order. */
	public void add(String value) {
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

	/**
	 * A simple binary search tree node.
	 *
	 * NOTE:
	 * This is an inner class, so instances have access to the methods
	 * and fields of the outer BinarySearchTree object.
	 */
	private class Node {
		String value;
		Node left, right;

		Node(String value) {
			this.value = value;
		}

		/**
		 * Search for value inside the tree.  Return a reference
		 * to the Node containing it if it is, null otherwise.
		 */
		Node find (String value)
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
		void insert(String value) {
			if (this.value.compareTo(value)>0){
				if(this.left==null){
					this.left = new Node(value);
				}
				else{
					this.left.insert(value);
					}
			}
			else if(this.value.compareTo(value)==0){
					System.exit(0);
			}
			else{
				if(this.right==null){
					this.right=new Node(value);
				}
				else{
					this.right.insert(value);
				}
			}
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

	public static void main(String[] args){
			BinarySearchTree T = new BinarySearchTree();
			T.add("String");
			T.add("Another");
			T.add("Bannana");
			T.add("Peach");
			T.add("Adam");
			T.add("Car");
			System.out.println(T);
			System.out.println ("Height is : " + T.height());
			System.out.println ("Size is : " + T.size());

			System.out.println ("Adam " + (T.inTree("Adam") ? "is" : "is not") +
				" in the tree");
			System.out.println ("Frankenstein " + (T.inTree("Frankenstein") ? "is" : "is not") +
				" in the tree");
	}


}



public class WrapperCaching
{

    public static void main (String [] args)
    {
        // explicitly create new integer objects
        Integer i1 = new Integer(42);
        Integer i2 = new Integer(42);

        // Because we created new objects, they are independently located in memory
        System.out.println ((i1 == i2) ? "same" : "diff");

        // now use autoboxing, this triggers the wrapper caching code in the 
        // integer class:
        i1 = 42;
        i2 = 42;
        
        // and as such they are the same location in memory 
        System.out.println ((i1 == i2) ? "same" : "diff");
    }
}


/*

Generic Binary Search Tree, with Integer values from 0 to 1000 inserted (creating a completely unbalanced tree).

search() for a particular Integer was only working with numbers up to 127, 128 and above was failing to find items in the tree.

Why?

hint: the search method had a line like:

if (nodeInTree.value == valueLookingFor)

Answer:

Integers in Java are immutable.  As such, actual integer values (for small values) are often shared amongst integer instances.  In particular values in the range -128 to +127 are shared.  Since the line in search does reference equality instead of value equality, it works for all values in this range.

See: http://www.owasp.org/index.php/Java_gotchas (the section called Immutable Objects / Wrapper Class Caching)

In particular, the following code appears in the Integer class:

private static class IntegerCache 
{
   private IntegerCache(){}
   
   static final Integer cache[] = new Integer[-(-128) + 127 + 1];
 
   static 
   {
     for(int i = 0; i < cache.length; i++)
     cache[i] = new Integer(i - 128); 
   }
}
    
public static Integer valueOf(int i) 
{
	final int offset = 128;
	if (i >= -128 && i <= 127) // must cache 
    { 
	    return IntegerCache.cache[i + offset];
	}
    return new Integer(i);
}


*/

import java.util.*;

/**
 * VarArgs.java - showing off variable argument lists in Java.
 * 
 * @author Adam Parkin
 */
public class VarArgs {

    public static void main (String [] args) {
        new VarArgs().runMe();
    }

    void runMe() {
        /*
        In Java, much like C, you can now have methods which take a variable 
        number of arguments.  You can either give them as individual args or
        even pass an array of arguments.
        */
        foo();
        foo("a");
        foo("b", "c");
        foo(new Object [] {"d", "e", "f", "g"});

        ArrayList<Integer> ar = new ArrayList<Integer>();
        for (int x = 0; x < 10; x++)
            ar.add(x);
        
        /*
        Now you'd think that since an array works, you could pass a list and 
        have it work, however, this doesn't work as you'd think.  Instead of
        seeing ar.length arguments, foo() sees a single argument of type
        ArrayList<String>.  Thus the following is passing <b>a single 
        argument</b> to foo():
        */
        foo (ar);

        /*
        Of course we could get the desired behavior by first converting to a
        an array:
        */
        foo (ar.toArray());
    }

    /**
     * A variable length argument list is defined with the elipsis between the
     * type and the name in the parameter list, and iterated over using the 
     * typical for-each loop construct.
     */
    void foo (Object ... args) {
        int x = 0;
        for (Object o : args) { 
            x++;
            System.out.println ("Arg " + x + ": " + o.toString());
        }
        System.out.println ("Total: " + x + " argument(s)");
        System.out.println ("------------------");
    }
} 

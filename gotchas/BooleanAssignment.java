
public class BooleanAssignment
{

    public static void main (String [] args)
    {
        /* 
        everyone knows about how == and = are different operators but
        can be easily confused.  Java's nice in that it often flags
        expressions like:

        if (a = 42)

        as an error.  Note though I said "often" and not "always". 
        Consider:
        */

        boolean a = false;
        if (a = true) 
            System.out.println ("A is true!");
        else
            System.out.println ("A is false!");

        /*
        this will always print out "A is true" because an assignment
        expression yields a result of the type of values being assigned
        (in this case boolean).  The reason

        if (x = 42)

        fails is because the assignment x = 42 yields an integer result
        (42), and an if statement only works on boolean expressions.

        However if the assignment yields a boolean result, then there is
        no error and so computation proceeds.

        Of course the same applies to the ternary operator:
        */

        a = false;
        System.out.println ("A is " + ((a = true) ? "true" : "false"));
    }
}

import java.awt.Point;

public class FinalVsConst
{
    public static void main (String [] args)
    {
        /*
        Java has a final keyword which is similar to C++'s const keyword.
        However, there is a key difference: in C++ const means "you cannot
        modify this thing in any way", in Java final means "you cannot 
        reassign this value".  That seems like a subtle distinction, here's
        an example that shows why it matters:
        */
        final Point p = new Point(5,2);
        
        // you can use getters/setters to modify:
        p.setLocation(22, 42);

        // you can also modify fields directly (assuming appropriate access
        // specifiers):
        p.x = 82;

        // but you cannot make the reference refer to something else:

        //p = new Point (10, 10);   // causes an error!
    }

}

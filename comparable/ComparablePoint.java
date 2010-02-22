/**
 * A point representing a location in (x, y) coordinate space, specified in 
 * integer precision, with the addition that they may be compared based upon 
 * distance from the origin (0,0). 
 *
 * @author Adam Parkin
*/

import java.util.*;
import java.awt.Point;

public class ComparablePoint extends Point implements Comparable<ComparablePoint>
{

	/**
	 * Compare another ComparablePoint to this point.  A comparable point is 
	 * considered to be "less than" another if it is closer to the origin (0,0),
	 * where distance to the origin is calculated as sqrt (x^2 + y^2).
	 * 
	 * @param c the ComparablePoint to compare to this ComparablePoint
	 * @return a negative integer, zero, or a positive integer as this 
	 * 	ComparablePoint is closer to, the same distance from, or 
	 *	farther from the origin than the specified ComparablePoint. 
	*/
	public int compareTo (ComparablePoint c)
	{
		double thisDistance = Math.sqrt (x * x + y * y);
		double otherDistance = Math.sqrt (c.x * c.x + c.y * c.y);

		// ugliness required as Point has it's own Double class which is 
		// different from the standard java.lang.Double, so without fully 
		// qualified class names the two conflict.
		return new java.lang.Double(thisDistance).compareTo 
			(new java.lang.Double (otherDistance));
	}

	/**
	 * Constructs and initializes a point at the specified (x, y) location in 
	 * the coordinate space.
	 * 
	 * @param x	the x coordinate
	 * @param y	the y coordinate
	 */
	public ComparablePoint (int x, int y)
	{
		super (x,y);
	}
	
	public String toString ()
	{
		return "(" + x + ", " + y + ")";
	}

	public static void main (String [] args)
	{
		ComparablePoint [] cArr = new ComparablePoint[5];
		cArr[0] = new ComparablePoint (2,2);
		cArr[1] = new ComparablePoint (1,2);
		cArr[2] = new ComparablePoint (-1,2);
		cArr[3] = new ComparablePoint (5,5);
		cArr[4] = new ComparablePoint (-4,-4);

		System.out.println ("Before sort: " + Arrays.toString (cArr));
		Arrays.sort (cArr);
		System.out.println ("After sort: " + Arrays.toString (cArr));
	}
}

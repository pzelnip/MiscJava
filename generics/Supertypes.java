import java.io.*;
import java.util.*;

public class Supertypes 
{
	public static void main (String [] args)
	{

		/* Note that different instantiations of generic types do not have
		   any supertype/subtype relationship.  That is:

		List<Object>

		is not a supertype of

		List<String>

		As a consequence of this the following is invalid:
		*/
		ArrayList<String> l = new ArrayList<String>();
		//printList (l);  // error as l is not of type ArrayList<Object>

		// but the following would be ok:
		ArrayList<Object> ol = new ArrayList<Object>();
		printList (ol);
		
		// to make this work, we need type wildcards:
		printAnyList (l);
		printAnyList (ol);

		// but what if we want a list of things that aren't just Objects?
		// Then we need *bounded wildcards*:

		try
		{
			List<InputStream> listofIstreams = new ArrayList<InputStream>();
			listofIstreams.add (System.in);
			listofIstreams.add (new FileInputStream (new File ("Supertypes.java")));
			printListOfStreams (listofIstreams);
		} catch (IOException e) { }
	}

	public static void printList (ArrayList<Object> olist)
	{
		for (Object o : olist)
			System.out.println (o);
	}

	public static void printAnyList (List<?> olist)
	{
		for (Object o : olist)
			System.out.println (o);
	}

	public static void printListOfStreams (List<? extends InputStream> olist) throws IOException
	{
		for (InputStream o : olist)
			System.out.println (o.available() + " bytes available");
	}
}

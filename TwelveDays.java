public class TwelveDays
{
	public static void main (String [] args)
	{
		for (int x = 1; x <= 12; x++)
			System.out.println (doDay(x));
	}

	static public String doDay (int x)
	{
		final String [] days = {"first", "second", "third", "fourth", "fifth",
			"sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth"};

		String retval = "On the " + days[x - 1] + " of Christmas,\nmy true love sent to me\n";

		switch (x)
		{
			case 12:
				retval += "Twelve drummers drumming\n";
			case 11:
				retval += "eleven pipers piping\n";
			case 10:
				retval += "ten lords a-leaping\n";
			case 9:
				retval += "nine ladies dancing\n";
			case 8:
				retval += "eight maids a-milking\n";
			case 7:
				retval += "seven swans a-swimming\n";
			case 6:
				retval += "six geese a-laying\n";
			case 5:
				retval += "five golden rings\n";
			case 4:
				retval += "four calling birds\n";
			case 3:
				retval += "three French hens,\n";
			case 2:
				retval += "two turtle doves, and\n";
			case 1:
				retval += "a partridge in a pear tree\n";
		}

		return retval;
	}
}


public class OpToPrettyString<T> implements Operation <T>
{
	String result = ""; 
	int count = 0;

	public void apply (T o)
	{
		if (count == 0)
			result = o.toString();
		else
			result += ", " + o.toString();
		count++;
	}

	public Object getResult ()
	{
		result = "[" + result + "]";
		return result;
	}
}

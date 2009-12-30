import java.util.Stack;

public class OpPushToStack<T> implements Operation <T>
{
	Stack <T> result = new Stack<T>();

	public void apply (T o)
	{
		result.push (o);
	}

	public Object getResult ()
	{
		return result;
	}

	public Stack<T> getStack()
	{
		return result;
	}
}


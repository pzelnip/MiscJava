
public class OpAddDouble implements Operation <Double>
{
	double result = 0.0; 

	public void apply (Double o)
	{
		result += o.doubleValue();
	}

	public Object getResult ()
	{
		return new Double (result);
	}
}


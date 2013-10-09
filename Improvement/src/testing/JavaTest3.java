package testing;
public class JavaTest3 extends Thread
{		
	private int start;
	private int end;
	private double result;
	public JavaTest3 (int start, int end) 
	{
		this.start = start;
		this.end = end;
		result = 0;
	}
	
	public double getResult()
	{
		return result;
	}
	
	@Override
	public void run() 
	{
		for (int i = start; i < end; i++)
		{
			result += Math.sqrt(i);
		}
	}
}
package common;

public class Timer {
	private long startTime = 0L;
	private long endTime = 0L;
	
	public Timer() {
		startTime = System.currentTimeMillis();
	}
	
	public void stop() 
	{
		endTime = System.currentTimeMillis();
	}
	
	public void print()
	{
		System.out.println("Time passed: " + (endTime-startTime) + "ms.");
	}
	
	public void stopAndPrint()
	{
		stop();
		print();
	}
	
}

package testing;

import java.util.Stack;

import common.Timer;

public class JavaTest2 {
	
	static int size = 1000000000;
	
	public static void test()
	{
		
		Stack<Integer> list = new Stack<Integer>();
		for (int i = 0; i<size/100; i++)
		{
			list.add(i);
		}
		Timer t = new Timer();
		for (int j=0; j<size; j++)
		{
			list.push(j);
			list.pop();
		}
		t.stopAndPrint();
	}
	
    public static void main(String[] args) 
    
    {
    	test();
    }
}
package testing;

import java.util.ArrayList;

public class JavaTest3 {
	
	static int size = 1000000000;
	
	public static void test()
	{
		
		ArrayList<Integer> list = new ArrayList<Integer> ();
		list.add(1);
		list.add(2);
		for(@SuppressWarnings("unused") Integer i: list)
		{
			list.add(3);
		}
	}
	
    public static void main(String[] args) 
    
    {
    }
}
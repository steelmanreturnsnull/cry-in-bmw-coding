package testing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JavaTest {
	
	static int size = 1000000;
	
	public static void test(List<Integer> list)
	{
    	long start = System.currentTimeMillis();
    	for (int i = 0; i<size; i++)
    	{
    		list.add(i);
    	}
    	long end  = System.currentTimeMillis();
    	System.out.println((end-start)+ " ms.");
	}
	
    public static void main(String[] args) {
    	
    	double j = -1.5;
    	System.out.println((j++)%1);

    	ArrayList<Integer> array = new ArrayList<Integer> ();
    	LinkedList<Integer> linked = new LinkedList<Integer> ();
    	
    	long start = System.currentTimeMillis();
    	for (int i = 0; i<size; i++)
    	{
    		array.add(i);
    	}
    	long end  = System.currentTimeMillis();
    	System.out.println((end-start)+ " ms.");
    	
    	long start2 = System.currentTimeMillis();
    	for (int i = 0; i<size; i++)
    	{
    		linked.add(i);
    	}
    	long end2  = System.currentTimeMillis();
    	System.out.println((end2-start2)+ " ms.");
    	
    	start = System.currentTimeMillis();
    	for (int i = 0; i<size/10; i++)
    	{
    		array.get(size/2);
    	}
    	end  = System.currentTimeMillis();
    	System.out.println((end-start)+ " ms.");
    	
    	start2 = System.currentTimeMillis();
    	for (int i = 0; i<size/10; i++)
    	{
    		linked.get(size/2);
    	}
    	end2  = System.currentTimeMillis();
    	System.out.println((end2-start2)+ " ms.");
    }
}
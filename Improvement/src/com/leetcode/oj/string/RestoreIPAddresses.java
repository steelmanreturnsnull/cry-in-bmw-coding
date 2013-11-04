package com.leetcode.oj.string;

import java.util.ArrayList;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * 
 * For example:
 * Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 *
 */

// OK
public class RestoreIPAddresses 
{
	// O(Cn4)
	public static ArrayList<String> restoreIpAddresses(String s) 
	{
		ArrayList<String> result = new ArrayList<String> ();
		restoreIpHelper ("", s, 4, result);
		return result;
	}
	
	public static void restoreIpHelper (String processed, String toProcess, int remaining_fields, ArrayList<String> result) 
	{
		if (toProcess.length() == 0 && remaining_fields ==0)
			result.add(processed.substring(1));
		else if (remaining_fields ==0 || remaining_fields > toProcess.length())
			return;
		else 
		{
			for (int i = 1; i <= Math.min(3, toProcess.length()); i++) // Need it for the substring (to avoid out of bound)
			{
				String field = toProcess.substring(0, i);
				if (toProcess.length() >= i && Integer.valueOf(field) < 256 
						&& (field.charAt(0) != '0' || field.equals("0")))
				restoreIpHelper (processed+"."+field, toProcess.substring(i), remaining_fields-1, result);
			}
		}
	}
	
	public static void main (String[] args)
	{
		restoreIpAddresses("0000");
	}
}

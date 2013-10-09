package Util;

import java.util.regex.Pattern;

public class StringUtil {
	
	public static boolean containsRescritedCharacters (String str)
	{
		return str.matches(".*[\\\\/:*?\"<>|].*");
	}
	
	public static void main (String[] args)
	{
		System.out.println(containsRescritedCharacters("abc\\"));
		
	}
}

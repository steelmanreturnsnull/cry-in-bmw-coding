package leetcode;

import java.util.ArrayList;

public class RestoreIPAddresses {
	
	public static ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> result = new ArrayList<String> ();
		restoreIpHelper ("", s, 4, result);
		return result;
	}
	
	public static void restoreIpHelper (String processed, String toProcess, int remaining_fields, ArrayList<String> result) {
		if (toProcess.length() == 0 && remaining_fields ==0)
			result.add(processed.substring(1));
		else if (remaining_fields ==0)
			return;
		else if (remaining_fields > toProcess.length())
			return;
		else {
			if (toProcess.length()>=3 && Integer.valueOf(toProcess.substring(0, 3)) <256 && toProcess.charAt(0) != '0')
				restoreIpHelper (processed+"."+toProcess.substring(0, 3), toProcess.substring(3), remaining_fields-1, result );
			if (toProcess.length()>=2 && toProcess.charAt(0) != '0')
				restoreIpHelper (processed+"."+toProcess.substring(0, 2), toProcess.substring(2), remaining_fields-1, result );
			if (toProcess.length()>=1)
				restoreIpHelper (processed+"."+toProcess.substring(0, 1), toProcess.substring(1), remaining_fields-1, result );
		}
	}
}

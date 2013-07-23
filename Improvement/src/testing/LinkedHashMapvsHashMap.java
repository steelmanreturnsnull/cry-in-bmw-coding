package testing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LinkedHashMapvsHashMap {

	public static void main(String[] args) {
		Map<String,Integer> m1 = new HashMap<String,Integer> ();
		m1.put("Cindy", 1);
		m1.put("Pinjie", 2);
		m1.put("Grgeg", 3);
		m1.put("Gregg", 3);
		m1.put("Greg", 3);
		Iterator<Entry<String, Integer>> it1 = m1.entrySet().iterator();
		while (it1.hasNext()) {
			Entry<String, Integer> pairs = (Entry<String, Integer>)it1.next();
			System.out.println(pairs.getKey());
		}
		
		
		Map<String,Integer> m2 = new LinkedHashMap<String,Integer> ();
		m2.put("Cindy", 1);
		m2.put("Pinjie", 2);
		m2.put("Grgeg", 3);
		m2.put("Gregg", 3);
		m2.put("Greg", 3);
		Iterator<Entry<String, Integer>> it2 = m2.entrySet().iterator();
		while (it2.hasNext()) {
			Entry<String, Integer> pairs = (Entry<String, Integer>)it2.next();
			System.out.println(pairs.getKey());
		}
	}

}

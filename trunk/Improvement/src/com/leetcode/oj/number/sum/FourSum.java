package com.leetcode.oj.number.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * Given an array S of n integers, are there elements a, b, c, 
 * and d in S such that a + b + c + d = target? Find all unique 
 * quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 * A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
 * 
 * 
*/

public class FourSum 
{ 
	// O(n^2) best O(n^4) worst
	static public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) 
    {
    	HashSet<ArrayList<Integer>> resultSet = new HashSet<ArrayList<Integer>>();
    	Arrays.sort(num);
    	Map<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
    	for (int i=0; i<num.length-1; i++) {
    		for (int j=1; j<num.length; j++) {
    			ArrayList<Integer> list = new ArrayList<Integer> ();
    			list.add(num[i]);
    			list.add(num[j]);
    			if (!map.containsKey(num[i]+num[j])) {
    				ArrayList<ArrayList<Integer>> set = new ArrayList<ArrayList<Integer>>();
    				set.add(list);
    				map.put(num[i]+num[j], set);
    			}
    			else {
    				ArrayList<ArrayList<Integer>> set = map.get(num[i]+num[j]);
    				set.add(list);
    			}
    		}
    	}
    	
    	Iterator<Integer> it = map.keySet().iterator();
    	while (it.hasNext()) {
    		Integer key = it.next();
    		if (key+key == target) {
    			addSetToResult(map.get(key), resultSet);
    		}
    		else {
    			if (map.containsKey(target-key)) {
    				addSetsToResult(map.get(key), map.get(target-key), resultSet);
    			}
    		}
    	}
    	
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> (resultSet);
    	return result;
    	
    }
    
    public static void addSetsToResult (ArrayList<ArrayList<Integer>> s1, ArrayList<ArrayList<Integer>> s2, HashSet<ArrayList<Integer>> resultSet) {
    	Iterator<ArrayList<Integer>> it1 = s1.iterator();
    	while (it1.hasNext()) {
    		ArrayList<Integer> key = it1.next();
    		Iterator<ArrayList<Integer>> it2 = s2.iterator();
        	while (it2.hasNext()) {
        		ArrayList<Integer> key2 = it2.next();
        		ArrayList<Integer> result = new ArrayList<Integer> ();
        		result.addAll(key);
        		result.addAll(key2);
        		Collections.sort(result);
        		resultSet.add(result);
        	}
    	}
    }
    
    public static void addSetToResult (ArrayList<ArrayList<Integer>> s1, HashSet<ArrayList<Integer>> resultSet) {
    	Iterator<ArrayList<Integer>> it1 = s1.iterator();
    	while (it1.hasNext()) {
    		ArrayList<Integer> key = it1.next();
    		Iterator<ArrayList<Integer>> it2 = s1.iterator();
        	while (it2.hasNext()) {
        		ArrayList<Integer> key2 = it2.next();
        		if (key.equals(key2))
        			continue;
        		ArrayList<Integer> result = new ArrayList<Integer> ();
        		result.addAll(key);
        		result.addAll(key2);
        		Collections.sort(result);
        		resultSet.add(result);
        	}
    	}
    }

	public static void main(String[] args) {
		fourSum(new int[] {0,0}, 0);
	}
}

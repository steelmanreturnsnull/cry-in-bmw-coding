package com.leetcode.oj.numbers.sums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// http://leetcode.com/2010/04/finding-all-unique-triplets-that-sums.html

/* Given an array S of n integers, are there elements a, b, c in S such that 
 * a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ? b ? c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 * 
*/
public class ThreeSum { // O(n^2)
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    	Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>> ();
    	Arrays.sort(num);
    	int length = num.length;
    	for (int i=0; i<length-2; i++) {
    		int k = i+1;
    		int l = length-1;
    		while (k<l) {
    			int a = num[i];
    			int b = num[k];
    			int c = num[l];
    			if (a+b+c == 0) {
    				ArrayList<Integer> list = new ArrayList<Integer>();
    				list.add(a);
    				list.add(b);
    				list.add(c);
    				set.add(list);
    				k++;
    				l--;
    			}
    			else if (a+b+c <0) {
    				k++;
    			}
    			else {
    				l--;
    			}
    		}
    	}
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> (set);
    	return result;
    }
    
}

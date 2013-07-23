package leetcode;

import java.util.Arrays;

/* Given an array S of n integers, find three integers in S such that the sum is closest to a given number, 
 * target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * 
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

public class ThreeSumClosest { //O(n^2)
    public int threeSumClosest(int[] num, int target) {
    	int diff = Integer.MAX_VALUE;
    	Arrays.sort(num);
    	int length = num.length;
    	int sum;
    	if (length >=3)
    		sum = num[0] + num[1] + num[2];
    	else
    		sum = 0; // should throw an exception here
    	for (int i=0; i<length-2; i++) {
    		int k = i+1;
    		int l = length-1;
    		while (k<l) {
    			int a = num[i];
    			int b = num[k];
    			int c = num[l];
    			if (a+b+c == target) {
    				return target;
    			}
    			else if (a+b+c <target) {
    				if (target - (a+b+c) < Math.abs(diff)) {
    					diff = target - (a+b+c);
    					sum = a + b + c;
    				}
    				k++;
    			}
    			else {
    				if ((a+b+c) - target < Math.abs(diff)) {
    					diff = (a+b+c) - target;
    					sum = a + b + c;
    				}
    				l--;
    			}
    		}
    	}
    	return sum;
    }
}

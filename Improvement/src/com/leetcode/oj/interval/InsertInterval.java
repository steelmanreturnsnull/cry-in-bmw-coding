package com.leetcode.oj.interval;

import java.util.ArrayList;

import com.leetcode.oj.common.model.Interval;

public class InsertInterval {

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for (Interval interval:intervals)
        {
        	if (overlaps(interval, newInterval))
        	{
        		left = Math.min(left, Math.min(interval.start, newInterval.start));
        		right = Math.max(right, Math.max(interval.end, newInterval.end));
        	}
        	else
        		result.add(interval);
        }
        
        if (left!= Integer.MAX_VALUE)
        	result.add(new Interval(left, right));
        else
        	result.add(newInterval);
        return result;
    }
	
	public static boolean overlaps (Interval i1, Interval i2)
	{
		if (i1.start < i2.start)
			return i1.end >= i2.start;
		if (i1.start > i2.start)
			return i2.end >= i1.start;
		return true;
			
	}

}

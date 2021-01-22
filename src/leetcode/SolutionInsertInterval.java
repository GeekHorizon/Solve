package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1:
 * 
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5] Output: [[1,5],[6,9]]
 * Example 2:
 * 
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]] Explanation: Because the new interval [4,8]
 * overlaps with [3,5],[6,7],[8,10].
 * 
 */
public class SolutionInsertInterval {

	public static void main(String[] args) {
		SolutionInsertInterval swm = new SolutionInsertInterval();
		System.out.println(Arrays.toString(swm.insert(new int[][] { {1, 3}, {6, 9}}, new int[] {2, 5})));
		
		
		
	}

    public int[][] insert(int[][] intervals, int[] newInterval) {
    	
    	if (intervals.length == 0) {
    		return new int[][] {newInterval};
    	}
    	
    	int startIndex = 0;
    	int endIndex = 0;
    	int endInterval = newInterval[1];
    	
    	
    	for (int idx = 0; idx  < intervals.length; idx++) {
    		
    		int[] subNums = intervals[idx];
    		 
    		if (subNums[0] <= newInterval[0] && newInterval[0] <= subNums[1]) {
    			startIndex = idx;
    		}
    		
    		if (subNums[0] <= newInterval[1] || subNums[1] <= newInterval[1]) {
    			endIndex = idx;
    			endInterval = Math.max(subNums[1], endInterval);
    		}
    	}

    	int totalIndex = intervals.length - (endIndex - startIndex);
    	
    	int[][] resultIntervals = new int[totalIndex][2];
    	
    	for (int idx = 0, arrayIdx = 0; idx < intervals.length; idx++) {
    		
    		if (idx > startIndex && idx <= endIndex) {
    			continue;
    		} 
    		
    		resultIntervals[arrayIdx] = intervals[idx];
    		
    		if (startIndex == idx) {
    			resultIntervals[arrayIdx][1] = endInterval;
    		}
    		
    		arrayIdx++;
    	}
    	
    	return resultIntervals;
    }
}

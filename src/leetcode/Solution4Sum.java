package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * Example:
 * 
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is: [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 * 
 */
public class Solution4Sum {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		Solution4Sum s = new Solution4Sum();
		
		
		System.out.println(s.fourSum(new int[] {-5, -4, -2, -2, -2, -1, 0, 0, 1}, -9));
		
		
	}
	
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		
		Arrays.sort(nums);
		
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		
		
		for (int firstIndex = 0; firstIndex < nums.length - 3; firstIndex++) {
			
			if (nums[firstIndex] + nums[firstIndex + 1] + nums[firstIndex + 2] + nums[firstIndex + 3] > target) {
				break;
			}
			
			if (nums[firstIndex] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
				continue;
			}
			
			if (firstIndex > 0 && nums[firstIndex - 1] == nums[firstIndex]) {
				continue ;
			}
			
			for (int secondIndex = firstIndex + 1; secondIndex < nums.length - 2; secondIndex++) {
				
				if (nums[firstIndex] + nums[secondIndex] + nums[secondIndex + 1] + nums[secondIndex + 2] > target) {
					break;
				}
				
				if (nums[firstIndex] + nums[secondIndex] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
					continue;
				}
				
				if (firstIndex + 1 < secondIndex && nums[secondIndex - 1] == nums[secondIndex]) {
					continue;
				}
				
				int thirdIndex = secondIndex + 1;
				int fourthIndex = nums.length - 1;
				
				while (thirdIndex < fourthIndex) {
					int sum = nums[firstIndex] + nums[secondIndex] + nums[thirdIndex] + nums[fourthIndex];
					
					if (sum == target) {
						List<Integer> elements = new ArrayList<Integer>();
						elements.add(nums[firstIndex]);
						elements.add(nums[secondIndex]);
						elements.add(nums[thirdIndex]);
						elements.add(nums[fourthIndex]);
						
						resultList.add(elements);
						
						
						while (thirdIndex < fourthIndex && nums[thirdIndex] == nums[thirdIndex + 1]) {
							thirdIndex++;
						}
						while (secondIndex < fourthIndex && nums[fourthIndex] == nums[fourthIndex - 1]) {
							fourthIndex--;
						}
						
						thirdIndex++;
						fourthIndex--;
					} else if (sum < target) {
						thirdIndex++;
					} else {
						fourthIndex--;
					}
				}
			}
		}
				
		return resultList;
	}

}

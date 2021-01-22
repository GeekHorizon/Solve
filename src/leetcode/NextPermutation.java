package leetcode;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 → 1,3,2 3,2,1 → 1,2,3 1,1,5 → 1,5,1
 * 
 * @author iris
 *
 */
class Solution {
	
	public static void main(String[] args) {
		
		Solution s = new Solution();
		
		int[] items = new int [] {5,4,7,5,3,2};
		
		s.nextPermutation(items);
		
		System.out.println(Arrays.toString(items));
		
	}
	
	
	/**
	 * 
	 * @param nums
	 */
	public void nextPermutation(int[] nums) {
		
		if (nums.length < 2) {
			return;
		}
		
		
		for (int idx = nums.length - 2; idx >= 0; idx--) {
			for (int idy = nums.length -1; idy > idx; idy--) {
				if (nums[idx] < nums[idy]) {
					swap(idx, idy, nums);
					return;
				}
			}
		}
		
		if (nums[0] > nums[1]) {
			int x = 0; 
			int y = nums.length - 1;
			while (x < y) {
				swap(x, y, nums);
				x++; y--;
			}
			return;
		}
		
		int x = 1; 
		int y = nums.length - 1;
		while (x < y) {
			swap(x, y, nums);
			x++; y--;
		}
		
		for (int idx = 1; idx < nums.length; idx++) {
			if (nums[idx] > nums[0]) {
				swap(idx, 0, nums);
				return;
			}
		}
		
		return;
	}
	
	public void swap(int x, int y, int[] nums) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
	
}  
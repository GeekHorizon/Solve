package leetcode;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * 
 * Input: [2,3,1,1,4] Output: 2 Explanation: The minimum number of jumps to
 * reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the
 * last index.
 */
public class SolutionJumpGameII {

	public static void main(String[] args) {
		SolutionJumpGameII swm = new SolutionJumpGameII();
		System.out.println(swm.jump(new int[] { 
				2,3,1,1,4 }));
	}

	public int jump(int[] nums) {
	
		int jump = 0;
		int jumpMaxIndex = 0;
		int maxIndex = 0;
	
		for (int idx = 0; idx < nums.length - 1; idx++) {
			jumpMaxIndex = Math.max(jumpMaxIndex, idx + nums[idx]);
			
			if (jumpMaxIndex >= nums.length - 1) {
				return jump + 1;
			}
			
			
			if (idx == maxIndex) {
				maxIndex = jumpMaxIndex;
				jump++;
			}
		}
		return jump;
	}

}

package leetcode;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * Example 1:
 * 
 * Input: "(()" Output: 2 Explanation: The longest valid parentheses substring
 * is "()" Example 2:
 * 
 * Input: ")()())" Output: 4 Explanation: The longest valid parentheses
 * substring is "()()"
 */
public class SolutionLongestValidParentheses {

	public int longestValidParentheses(String s) {

		char startBucket = '(';
		int longestValidParenteses = 0;
		
		int idx = 0; 
		int length = s.length();
		while (idx < length) {
			int findWordLength = 0;
			int bucketLength = 0;
			
			
			int halfSize = length - idx + 1;

			for (int wordIdx = idx; wordIdx < length; wordIdx++) {

				if (bucketLength > halfSize) {
					break;
				}

				if (s.charAt(wordIdx) == startBucket) {
					bucketLength++;
					continue;
				}

				if (bucketLength == 0) {
					break;
				}

				bucketLength--;

				if (bucketLength == 0) {
					findWordLength = wordIdx + 1 - idx;
				}
			}

			if (longestValidParenteses < findWordLength) {
				longestValidParenteses = findWordLength;
				idx += longestValidParenteses;
			}
			
			idx++;
		}

		return longestValidParenteses;

	}

}

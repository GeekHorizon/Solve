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
		Stack<Integer> stack = new Stack<>();
		
		for (int idx = 0; idx < s.length(); idx++) {
			
			if (s.charAt(idx) == '(') {
				stack.push(idx);
			} else {
				if (!stack.isEmpty()) {
					if (s.charAt(stack.peek()) == '(') {
						stack.pop();
					} else {
						stack.push(idx);	
					}
				} else {
					stack.push(idx);
				}
			}
		}

		if (stack.isEmpty()) {
			return s.length();
		}
		
		int right = s.length();
		int longest = 0;
		
		while (!stack.isEmpty()) {
			int left = stack.pop();
			
			longest = Math.max(longest, right - left - 1);
			right = left;
		}
		longest = Math.max(longest, right);
		
		
		return longest;
	}

}

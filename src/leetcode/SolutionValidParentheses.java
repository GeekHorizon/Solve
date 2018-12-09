package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must
 * be closed in the correct order. Note that an empty string is also considered
 * valid.
 * 
 * Example 1:
 * 
 * Input: "()" Output: true Example 2:
 * 
 * Input: "()[]{}" Output: true Example 3:
 * 
 * Input: "(]" Output: false Example 4:
 * 
 * Input: "([)]" Output: false Example 5:
 * 
 * Input: "{[]}" Output: true *
 */
public class SolutionValidParentheses {

	public static void main(String[] args) {

		SolutionValidParentheses s = new SolutionValidParentheses();

		s.isValid("()");

	}

	public boolean isValid(String s) {

		Stack<Character> stack = new Stack<Character>();

		Map<Character, Character> bracatGroup = new HashMap<Character, Character>();

		bracatGroup.put('(', ')');
		bracatGroup.put('{', '}');
		bracatGroup.put('[', ']');

		for (int index = 0; index < s.length(); index++) {
			char bracketWord = s.charAt(index);

			if (bracatGroup.containsKey(bracketWord)) {
				stack.push(bracatGroup.get(bracketWord));
				continue;
			}
			
			if (stack.isEmpty()) {
				return false;
			}
			
			if (stack.pop() != bracketWord) {
				return false;
			}
		}

		if (!stack.isEmpty()) {
			return false;
		}

		return true;
	}

}

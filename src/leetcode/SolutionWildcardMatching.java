package leetcode;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern
 * matching with support for '?' and '*'.
 * 
 * '?' Matches any single character. '*' Matches any sequence of characters
 * (including the empty sequence). The matching should cover the entire input
 * string (not partial).
 * 
 * Note:
 * 
 * s could be empty and contains only lowercase letters a-z. p could be empty
 * and contains only lowercase letters a-z, and characters like ? or *. Example
 * 1:
 * 
 * Input: s = "aa" p = "a" Output: false Explanation: "a" does not match the
 * entire string "aa". Example 2:
 * 
 * Input: s = "aa" p = "*" Output: true Explanation: '*' matches any sequence.
 * Example 3:
 * 
 * Input: s = "cb" p = "?a" Output: false Explanation: '?' matches 'c', but the
 * second letter is 'a', which does not match 'b'. Example 4:
 * 
 * Input: s = "adceb" p = "*a*b" Output: true Explanation: The first '*' matches
 * the empty sequence, while the second '*' matches the substring "dce". Example
 * 5:
 * 
 * Input: s = "acdcb" p = "a*c?b" Output: false
 */
public class SolutionWildcardMatching {

	public static void main(String[] args) {
		SolutionWildcardMatching swm = new SolutionWildcardMatching();
		System.out
				.println(swm.isMatch2("aa", "*"));
	}

	public boolean isMatch(String s, String p) {

		if (p.length() == 0) {
			return s.length() == 0;
		}

		int countAsterisk = 0;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '*') {
				countAsterisk++;
			}
		}

		if (s.length() < p.length() - countAsterisk) {
			return false;
		}

		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;

		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '*') {
				for (int j = 0; j < s.length(); j++) {
					dp[j + 1] = dp[j] || dp[j + 1];
				}
			} else {
				for (int j = s.length() - 1; j >= 0; j--) {
					dp[j + 1] = (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j)) && dp[j];
				}
				dp[0] = false;
			}
		}

		return dp[s.length()];
	}
	
	public boolean isMatch2(String s, String p) {

		if (p.length() == 0) {
			return s.length() == 0;
		}

		char[] sArrays = s.toCharArray();
		char[] pArrays = p.toCharArray();
		
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		
		for (int idx = 0; idx < p.length(); idx++) {
			if (pArrays[idx] == '*') {
				dp[0][idx + 1] = dp[0][idx];
			}
		}
		
		
		for (int idx = 0; idx < s.length(); idx++) {
			for (int idy = 0; idy < p.length(); idy++) {
				if (sArrays[idx] == pArrays[idy] || pArrays[idy] == '?') {
					dp[idx + 1][idy + 1] = dp[idx][idy];
				} else if (pArrays[idy] == '*') {
					dp[idx + 1][idy + 1] = dp[idx][idy + 1] || dp[idx + 1][idy];
				}
			}
		}
	
		return dp[s.length()][p.length()];
	}

}

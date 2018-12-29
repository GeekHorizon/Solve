package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * Example 1:
 * 
 * Input: s = "barfoothefoobarman", words = ["foo","bar"] Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar"
 * respectively. The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 * 
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []*
 */
public class SolutionSubstringWithConcatenationOfAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> results = new ArrayList<Integer>();

		if (words.length == 0) {
			return results;
		}

		for (int idx = 0; idx < s.length() - words.length * words[0].length() + 1; idx++) {
			if (containsString(idx, s, words)) {
				results.add(idx);
			}
		}

		return results;
	}

	private boolean containsString(int startIdx, String s, String[] words) {
		boolean[] containsWords = new boolean[words.length];

		boolean isWordContains = false;

		while (!isWordContains) {
			isWordContains = true;

			boolean isStepContains = false;

			for (int idx = 0; idx < words.length; idx++) {

				if (containsWords[idx]) {
					continue;
				}

				isWordContains = false;

				String word = words[idx];

				boolean isContains = true;
				for (int wordIdx = 0; wordIdx < word.length(); wordIdx++) {

					if (word.charAt(wordIdx) != s.charAt(startIdx + wordIdx)) {
						isContains = false;
						break;
					}
				}

				if (isContains) {
					isStepContains = true;
					startIdx += word.length();
					containsWords[idx] = true;
				}

			}

			if (!isWordContains && !isStepContains) {
				return false;
			}
		}

		return true;
	}
}

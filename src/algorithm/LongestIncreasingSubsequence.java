package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        System.out.println(new LongestIncreasingSubsequence().longestIncreasingSubsequence(new int[] {4, 7, 6, 9, 8, 10}));

        System.out.println(new LongestIncreasingSubsequence().findLongestIncreasingSubsequence(new int[] {4, 7, 6, 9, 8, 10}));
    }
    
    public int longestIncreasingSubsequence(int[] s) {  
        Integer[] dp = new Integer[s.length];

        return lis(s, 0, dp);
    }

    public int lis(int[] s, int start, Integer[] dp) {
        
        if (dp[start] != null) {
            return dp[start];
        }

        int ret = 1;

        for (int next = start + 1; next < s.length; next++) {
            if (s[start] < s[next]) {
                ret = Math.max(ret, lis(s, next, dp) + 1);
            } 
        }

        dp[start] = ret;
        return ret;
    }

    public List<Integer> findLongestIncreasingSubsequence(int[] s) {  
        Integer[] dp = new Integer[s.length + 1];
        Integer[] choices = new Integer[s.length + 1];

        findLisCombination(s, -1, dp, choices);
        List<Integer> result = new LinkedList<>();

        reconstruct(s, -1, choices, result);
        return result;
    }


    public int findLisCombination(int[] s, int start, Integer[] dp, Integer[] choices) {
        
        if (dp[start + 1] != null) {
            return dp[start + 1];
        }

        int ret = 1;
        int bestNext = -1;
        for (int next = start + 1; next < s.length; next++) {
            if (start == -1 || s[start] < s[next]) {
                int cand = findLisCombination(s, next, dp, choices) + 1;
                if (cand > ret) {
                    ret = cand;
                    bestNext = next;
                }
            } 
        }

        choices[start + 1] = bestNext;
        dp[start + 1] = ret;
        return ret;
    }

    public void reconstruct(int[] s, int start, Integer[] choices, List<Integer> seq) {
        if (start != -1) {
            seq.add(s[start]);
        }
        
        Integer next = choices[start + 1];

        if (next != -1) {
            reconstruct(s, next, choices, seq);
        }
    }
}

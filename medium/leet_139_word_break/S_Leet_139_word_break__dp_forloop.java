package leet_139_word_break;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//	https://leetcode.com/problems/word-break/

//	DP(Memoization)
//	Time Complexity: O(N^2)
//	Space Complexity: O(N)

//	BruteForce
//	Time Complexity: O(2^N)
//	https://leetcode.com/problems/word-break/discuss/169383/The-Time-Complexity-of-The-Brute-Force-Method-Should-Be-O(2n)-and-Prove-It-Below/175114/

public class S_Leet_139_word_break__dp_forloop {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        int maxLen = 0, minLen = Integer.MAX_VALUE;
        
        for (String i : wordDict) {
            set.add(i);
            maxLen = Math.max(i.length(), maxLen);
            minLen = Math.min(i.length(), minLen);
        }
        
        int n = s.length();
        boolean[] dp = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = minLen; j <= maxLen; j++) {
                // j go behind i
                if (j > i + 1) {
                    break;
                } else {
                    dp[i] |= (i - j < 0 || dp[i - j]) && 
                        set.contains(s.substring(i - j + 1, i + 1));
                }
            }
        }
        
        return dp[n - 1];
    }
    
    public static void main(String args[]) {
    	S_Leet_139_word_break__dp_forloop inst = new S_Leet_139_word_break__dp_forloop();
    	
//    	boolean res = inst.wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code")));
//    	boolean res = inst.wordBreak("applepenapple", new ArrayList<>(Arrays.asList("apple", "pen")));
    	boolean res = inst.wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat")));
    	System.out.println(res);
    }
}

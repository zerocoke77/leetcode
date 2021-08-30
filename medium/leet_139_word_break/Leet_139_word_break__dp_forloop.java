package leet_139_word_break;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//	https://leetcode.com/problems/word-break/

//	DP(Memoization)
//	Time Complexity: O(N^2)
//	Space Complexity: O(N)

//	BruteForce
//	Time Complexity: O(2^N)
//	https://leetcode.com/problems/word-break/discuss/169383/The-Time-Complexity-of-The-Brute-Force-Method-Should-Be-O(2n)-and-Prove-It-Below/175114/

public class Leet_139_word_break__dp_forloop {
	public boolean wordBreak(String s, List<String> wordDict) {
		int []dp = new int[s.length() + 1];
		dp[0] = 1;
		
		for(int i=0; i<s.length(); ++i) {
			for(int j=0; j<wordDict.size(); ++j) {
				String word = wordDict.get(j);
				if(s.length() < i + word.length()) continue;
				String wordSplit = s.substring(i, i + word.length());
				if(word.equals(wordSplit)) {
					dp[i + word.length()] += dp[i];
				}
			}
		}
		
		return dp[s.length()] > 0;
	}
	
	public static void main(String args[]) {
		Leet_139_word_break__dp_forloop inst = new Leet_139_word_break__dp_forloop();
    	boolean res = inst.wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code")));
//    	boolean res = inst.wordBreak("applepenapple", new ArrayList<>(Arrays.asList("apple", "pen")));
//    	boolean res = inst.wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat")));
    	System.out.println(res);
	}
}

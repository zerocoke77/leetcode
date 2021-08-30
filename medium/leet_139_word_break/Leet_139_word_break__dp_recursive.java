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

public class Leet_139_word_break__dp_recursive {
	public static String ss;
	public static List<String> words;
	public static int[] dp;
	public boolean wordBreak(String s, List<String> wordDict) {
		ss = s;
		words = wordDict;
		dp = new int[s.length() + 1];
		Arrays.fill(dp, -1);
		
        int res = getCount(s.length());
		return res > 0;
    }
	
	public static int getCount(int index) {
		if(dp[index] != -1) return dp[index];
		if(index == 0) return 1;
	
		int sum = 0;
		for(int i=0; i<words.size(); ++i) {
			String word = words.get(i);
			if(index < word.length()) continue;
			String splitWord = ss.substring(index - word.length() ,index);
			if(word.equals(splitWord)) {
				sum += getCount(index - word.length());
			}
		}
		
		return dp[index] = sum;
	}
	
    public static void main(String args[]) {
    	Leet_139_word_break__dp_recursive inst = new Leet_139_word_break__dp_recursive();
    	
//    	boolean res = inst.wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code")));
//    	boolean res = inst.wordBreak("applepenapple", new ArrayList<>(Arrays.asList("apple", "pen")));
    	boolean res = inst.wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat")));
    	System.out.println(res);
    }
}

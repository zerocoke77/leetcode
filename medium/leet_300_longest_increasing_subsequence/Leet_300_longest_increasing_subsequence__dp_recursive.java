package leet_300_longest_increasing_subsequence;

import java.util.Arrays;

//	https://leetcode.com/problems/longest-increasing-subsequence/
//	https://aaronice.gitbook.io/lintcode/dynamic_programming/longest-increasing-subsequence
//	https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O%28nlogn%29-time-with-explanation

//	Brute-Force (TLE) - recursively search, O(2^n) time
//	Dynamic Programming - O(n^2) time, O(n) space
//	Dynamic Programming with Binary Search - O(nlogn) time, O(n) space

public class Leet_300_longest_increasing_subsequence__dp_recursive {
	public int []dp;
	public int []lis;
    public int lengthOfLIS(int[] nums) {
    	lis = nums;
    	dp = new int[nums.length];
    	Arrays.fill(dp, -1);
    	
    	int maxLeng = 0;
    	
    	for(int i=nums.length-1; i>=0; --i) {
    		maxLeng = Math.max(maxLeng, getLongest(i) + 1);
    	}
    	
        return maxLeng;
    }
    
    public int getLongest(int index) {
    	if(dp[index] != -1) return dp[index];
    	int maxLeng = 0;
    	
    	for(int i=index-1; i>=0; --i) {
    		if(lis[i] < lis[index]) {
    			maxLeng = Math.max(maxLeng, getLongest(i) + 1);
    		}
    	}
    	
    	return dp[index] = maxLeng;
    }
    
	public static void main(String args[]) {
		Leet_300_longest_increasing_subsequence__dp_recursive inst = new Leet_300_longest_increasing_subsequence__dp_recursive();
		int res = inst.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18});
//		int res = inst.lengthOfLIS(new int[] {0,1,0,3,2,3});
//		int res = inst.lengthOfLIS(new int[] {7,7,7,7,7,7,7});
		System.out.println(res);
	}
}

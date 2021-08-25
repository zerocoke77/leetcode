package leet_300_longest_increasing_subsequence;

//https://aaronice.gitbook.io/lintcode/dynamic_programming/longest-increasing-subsequence
//https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O%28nlogn%29-time-with-explanation

//Brute-Force (TLE) - recursively search, O(2^n) time
//Dynamic Programming - O(n^2) time, O(n) space
//Dynamic Programming with Binary Search - O(nlogn) time, O(n) space

public class S_Leet_30_longest_increasing_subsequence__dp_forloop_binarysearch {
	public int lengthOfLIS(int[] nums) {
	    int[] tails = new int[nums.length];
	    int size = 0;
	    for (int x : nums) {
	        int i = 0, j = size;
	        while (i != j) {
	            int m = (i + j) / 2;
	            if (tails[m] < x)
	                i = m + 1;
	            else
	                j = m;
	        }
	        tails[i] = x;
	        if (i == size) ++size;
	    }
	    return size;
	}
	
	public static void main(String args[]) {
		S_Leet_30_longest_increasing_subsequence__dp_forloop_binarysearch inst = new S_Leet_30_longest_increasing_subsequence__dp_forloop_binarysearch();
		int res = inst.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18});
//		int res = inst.lengthOfLIS(new int[] {0,1,0,3,2,3});
//		int res = inst.lengthOfLIS(new int[] {7,7,7,7,7,7,7});
		System.out.println(res);
	}
}

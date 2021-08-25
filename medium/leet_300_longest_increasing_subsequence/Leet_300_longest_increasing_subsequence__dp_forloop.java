package leet_300_longest_increasing_subsequence;

public class Leet_300_longest_increasing_subsequence__dp_forloop {
	public int []dp;
	public int lengthOfLIS(int[] nums) {
		dp = new int[nums.length];
		
		int leng = nums.length;
		int maxLeng = -1;
		
		for(int i=0; i<leng; ++i) {
			for(int j=0; j<i; ++j) {
				if(nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			maxLeng = Math.max(maxLeng, dp[i]);
		}
		
		return maxLeng + 1;
	}
	
	public static void main(String args[]) {
		Leet_300_longest_increasing_subsequence__dp_forloop inst = new Leet_300_longest_increasing_subsequence__dp_forloop();
		int res = inst.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18});
//		int res = inst.lengthOfLIS(new int[] {0,1,0,3,2,3});
//		int res = inst.lengthOfLIS(new int[] {7,7,7,7,7,7,7});
		System.out.println(res);
	}
}

package leet_300_longest_increasing_subsequence;

import java.util.Arrays;

public class Leet_300_longest_increasing_subsequence__dp_forloop_binarysearch {
	public static int []tail;
	public int lengthOfLIS(int[] nums) {
		tail = new int[nums.length + 1];
		Arrays.fill(tail, Integer.MIN_VALUE);
		int size = 0;

		for(int i=0; i<nums.length; ++i) {
			if(nums[i] > tail[size]) {
				tail[++size] = nums[i];
			} else {
				int index = binarySearch(0, size, nums[i]);
				tail[index] = nums[i];
			}
		}
		
		return size;
	}
	
	public static int binarySearch(int s, int e, int target) {
		if(s >= e) return s;
			
		int m = (s + e) / 2;
		if(target <= tail[m]) {
			return binarySearch(s, m, target);
		} else {
			return binarySearch(m+1, e, target);
		}
	}
	
	public static void main(String args[]) {
		Leet_300_longest_increasing_subsequence__dp_forloop_binarysearch inst = new Leet_300_longest_increasing_subsequence__dp_forloop_binarysearch();
//		int res = inst.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18});
//		int res = inst.lengthOfLIS(new int[] {0,1,0,3,2,3});
		int res = inst.lengthOfLIS(new int[] {4,10,4,3,8,9});
//		int res = inst.lengthOfLIS(new int[] {0,1,0,3,2,3});
//		int res = inst.lengthOfLIS(new int[] {7,7,7,7,7,7,7});
		System.out.println(res);
	}
}

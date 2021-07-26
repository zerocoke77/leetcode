package leet_1_two_sum;

import java.util.HashMap;

//	https://leetcode.com/problems/two-sum/
//	O(N)

public class Leet_1_two_sum_hashtable {
    public int[] twoSum(int[] nums, int target) {
    	HashMap<Integer, Integer> hashMap = new HashMap<>();
    	int leng = nums.length;
    	for(int i=0; i<leng; ++i) {
    		int remain = target - nums[i];
    		if(hashMap.containsKey(remain)) {
    			return new int[] {i, hashMap.get(remain)};	
    		}
    		hashMap.put(nums[i], i);
    	}
    	
    	return new int[] {0, 0};
    }
    
    public static void main(String args[]) {
    	Leet_1_two_sum_hashtable inst = new Leet_1_two_sum_hashtable();
    	int []res = inst.twoSum(new int[]{2,7,11,15}, 9);
//    	int []res = inst.twoSum(new int[]{3,2,4}, 6);
//    	int []res = inst.twoSum(new int[]{3,3}, 6);
    	System.out.println("[" + res[0] + "," + res[1] + "]");
    }
}

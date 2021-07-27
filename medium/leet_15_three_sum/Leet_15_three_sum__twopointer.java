package leet_15_three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//	https://leetcode.com/problems/3sum/
//	O(N)

public class Leet_15_three_sum__twopointer {
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> list = new ArrayList<>();
    	int leng = nums.length;
    	Arrays.sort(nums);
    	
    	for(int i=0; i<leng-1; ++i) {
    		int remain = 0 - nums[i];
    		if(nums[i] > 0) continue;
    		int s = i+1;
    		int e = leng-1;
    		while(s < e) {
    			if(nums[s]+nums[e] < remain) {
    				++s;
    				while(s < leng && nums[s-1] == nums[s]) ++s;
    			}
    			else if(nums[s]+nums[e] > remain) {
    				--e;
    				while(e >= 0 && nums[e] == nums[e+1]) --e;
    			}
    			else {
    				list.add(Arrays.asList(nums[i], nums[s], nums[e]));
    				++s;
    				while(s < leng && nums[s-1] == nums[s]) ++s;
    			}
    		}
    		while(i+1 < leng && nums[i] == nums[i+1]) ++i;
    	}
    	
    	return list;
    }
    
    public static void main(String args[]) {
    	Leet_15_three_sum__twopointer inst = new Leet_15_three_sum__twopointer();
//    	List<List<Integer>> res = inst.threeSum(new int[] {-1,0,1,2,-1,-4});
//    	List<List<Integer>> res = inst.threeSum(new int[] {});
//    	List<List<Integer>> res = inst.threeSum(new int[] {0});
    	List<List<Integer>> res = inst.threeSum(new int[] {-1,0,1,0});
    	System.out.println(res);
    }
}

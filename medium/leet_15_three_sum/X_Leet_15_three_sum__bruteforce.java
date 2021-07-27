package leet_15_three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//https://leetcode.com/problems/3sum/
//O(N^3) - fail (Time Limit Exceeded)

public class X_Leet_15_three_sum__bruteforce {
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> list = new ArrayList<>();
    	HashSet<Long> hashSet = new HashSet<>();
    	
    	Arrays.sort(nums);
    	int leng = nums.length;
    	for(int i=0; i<leng; ++i) {
    		for(int j=i+1; j<leng; ++j) {
    			for(int k=j+1; k<leng; ++k) {
    				if(nums[i] + nums[j] + nums[k] == 0) {
    					long key = nums[i] + nums[j] * (long)Math.pow(10, 5) + nums[k] * (long)Math.pow(10, 10);
    					if(!hashSet.contains(key)) {
    						list.add(Arrays.asList(nums[i], nums[j], nums[k]));
    						hashSet.add(key);
    					};    				
    				}
    			}
    		}
    	}
    	return list;
    }
    
    public static void main(String args[]) {
    	X_Leet_15_three_sum__bruteforce inst = new X_Leet_15_three_sum__bruteforce();
    	List<List<Integer>> res = inst.threeSum(new int[] {-1,0,1,2,-1,-4});
//    	List<List<Integer>> res = inst.threeSum(new int[] {});
//    	List<List<Integer>> res = inst.threeSum(new int[] {0});
    	System.out.println(res);
    }
}

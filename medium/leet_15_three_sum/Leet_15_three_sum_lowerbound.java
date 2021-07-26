package leet_15_three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//	https://leetcode.com/problems/3sum/
//	O(N^2logN)

public class Leet_15_three_sum_lowerbound {
	public static int[] gNums;
    public List<List<Integer>> threeSum(int[] nums) {
    	gNums = nums;
    	List<List<Integer>> result = new ArrayList <>();
    	HashMap<Integer, Integer> hashMap = new HashMap <>();
    	HashSet<String> hashSet = new HashSet<>();
    	
    	Arrays.sort(nums);
    	int leng = nums.length;
    	for(int i=0; i<leng; ++i) {
    		if(hashMap.containsKey(nums[i])) {
    			hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
    		} else {
    			hashMap.put(nums[i], 1);	
    		}
    	}
    	
    	for(int i=0; i<leng - 2; ++i) {
    		for(int j=i+1; j<leng - 1; ++j) {
    			int remain = 0 - nums[i] - nums[j];
    			int pos = lowerBound(j+1, leng-1, remain);
    			String key = Integer.toString(nums[i]) + Integer.toString(nums[j]);
    			
    			if(nums[pos] == remain && !hashSet.contains(key)) {
    				result.add(Arrays.asList(nums[i], nums[j], remain));
    				hashSet.add(key);
    			}
    		}
    	}
    	
        return result;
    }
    
    public static int lowerBound(int s, int e, int t) {
    	while(s < e) {
    		int m = (s + e) / 2;
    		if(gNums[m] >= t) e = m;
    		else s = m+1;
    	}
    	return e;
    }
    
    public static void main(String args[]) {
    	Leet_15_three_sum_lowerbound inst = new Leet_15_three_sum_lowerbound();
    	List<List<Integer>> res = inst.threeSum(new int[] {-1,0,1,2,-1,-4});
//    	List<List<Integer>> res = inst.threeSum(new int[] {});
//    	List<List<Integer>> res = inst.threeSum(new int[] {0});
    	System.out.println(res);
    }
}

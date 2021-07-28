package leet_15_three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S_Leet_15_three_sum_twopointer {
	public void twoSum(int target, int l, int r, int[] nums, List<List<Integer>> ans) {
		while(l < r) {
			int sum = nums[l] + nums[r] + target;
	
	        if(sum == 0) {
	            ans.add(Arrays.asList(target, nums[l++], nums[r--]));
	            while(l < r && nums[l] == nums[l-1]) {
	            	++l;
	            }
	        } else if(sum < 0) {
	            ++l;
	        } else {
	            --r;
	        }
		}
	}
    
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        for(int i = 0; i < n && nums[i] <= 0; ++i) {
            if(i == 0 || nums[i] != nums[i-1]) {
                twoSum(nums[i], i+1, n-1, nums, ans);
            }
        }
        return ans;
    }
    
    public static void main(String args[]) {
    	S_Leet_15_three_sum_twopointer inst = new S_Leet_15_three_sum_twopointer();
//    	List<List<Integer>> res = inst.threeSum(new int[] {-1,0,1,2,-1,-4});
//    	List<List<Integer>> res = inst.threeSum(new int[] {});
//    	List<List<Integer>> res = inst.threeSum(new int[] {0});
    	List<List<Integer>> res = inst.threeSum(new int[] {-1,0,1,0});
    	System.out.println(res);
    }
}

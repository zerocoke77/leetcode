package leet_1_two_sum;

import java.util.Arrays;
import java.util.Comparator;

//	https://leetcode.com/problems/two-sum/
//	O(NlogN)

public class Leet_1_two_sum_lowerbound {
    public static Node[] nodes;
	public class Node {
		int value, order;
		public Node(int value, int order) {
			this.value = value;
			this.order = order;
		}
	}
	
    public int[] twoSum(int[] nums, int target) {
        int leng = nums.length;
    	nodes = new Node[leng];
    	
    	for(int i=0; i<leng; ++i) {
    		nodes[i] = new Node(nums[i], i);
    	}
    	
    	Arrays.sort(nodes, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.value - o2.value;
			}
    	});
    	
    	
    	for(int i=0; i<leng; ++i) {
    		int remain = target - nodes[i].value;
    		int pos = lowerBound(i+1, leng - 1, remain);
    		if (nodes[pos].value == remain) {
    			return new int[]{nodes[i].order, nodes[pos].order};
    		}
    	}
    	
    	return new int[] {0, 0};
    }
    
    public static int lowerBound(int s, int e, int t) {
    	if(s >= e) return s;
    	int m = (s + e) / 2;
    	if(nodes[m].value >= t) return lowerBound(s, m, t);
    	else return lowerBound(m+1, e, t);
    }
    
//    public static int lowerBound(int s, int e, int t) {
//    	while(s < e) {
//    		int m = (s + e) / 2;
//    		if(nodes[m].value >= t) e = m;
//    		else s = m+1;
//    	}
//    	return s;
//    }
    
    public static void main(String args[]) {
    	Leet_1_two_sum_lowerbound inst = new Leet_1_two_sum_lowerbound();
    	int []res = inst.twoSum(new int[]{2,7,11,15}, 9);
//    	int []res = inst.twoSum(new int[]{3,2,4}, 6);
//    	int []res = inst.twoSum(new int[]{3,3}, 6);
    	System.out.println("[" + res[0] + "," + res[1] + "]");
    }
}

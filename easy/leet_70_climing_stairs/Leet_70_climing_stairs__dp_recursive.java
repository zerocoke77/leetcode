package leet_70_climing_stairs;

import java.util.Arrays;

public class Leet_70_climing_stairs__dp_recursive {
    public int []dp = new int[46];
    public int climbStairs(int n) {
        Arrays.fill(dp, -1);
        return getStairs(n);
    }
    
    public int getStairs(int n) {
        if(n <= 0) return 0; 
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(dp[n] != -1) return dp[n];
        
        return dp[n] = getStairs(n-1) + getStairs(n-2);
    }
    
	public static void main(String args[]) {
		Leet_70_climing_stairs__dp_recursive inst = new Leet_70_climing_stairs__dp_recursive();
		System.out.println(inst.climbStairs(2));
//		System.out.println(inst.climbStairs(3));
	}
}

package leet_70_climing_stairs;

public class Leet_70_climing_stairs__dp_forloop {
    public int []dp = new int[46];
    public int climbStairs(int n) {
    	dp[1] = 1; dp[2] = 2;
    	for(int i=3; i<=n; ++i) {    		
    		dp[i] = dp[i-1] + dp[i-2];
    	}
    	return dp[n];
    }
    
	public static void main(String args[]) {
		Leet_70_climing_stairs__dp_forloop inst = new Leet_70_climing_stairs__dp_forloop();
//		System.out.println(inst.climbStairs(2));
		System.out.println(inst.climbStairs(3));
	}
}

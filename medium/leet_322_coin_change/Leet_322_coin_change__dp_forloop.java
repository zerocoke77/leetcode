package leet_322_coin_change;

import java.util.Arrays;

public class Leet_322_coin_change__dp_forloop {
	public static int[]dp;
    public int coinChange(int[] coins, int amount) {
    	dp = new int[10001];
    	int max_value = 1 << 20;
    	Arrays.fill(dp, max_value);
    	dp[0] = 0;
    	
    	for(int i=0; i<coins.length; ++i) {
    		if(amount >= coins[i]) {
    			dp[coins[i]] = 1;	
    		}
    	}

    	for(int i=0; i<=amount; ++i) {
    		for(int j=0; j<coins.length; ++j) {
    			if(i > coins[j]) {
    				dp[i] = Math.min(dp[i], dp[coins[j]] + dp[i - coins[j]]);	
    			}
    		}
    	}
    
    	return dp[amount] >= max_value ? -1 : dp[amount];
    }
    
	public static void main(String args[]) {
		Leet_322_coin_change__dp_forloop inst = new Leet_322_coin_change__dp_forloop();
		
//		int res = inst.coinChange(new int[] {1, 2, 5}, 11);
//		int res = inst.coinChange(new int[] {2}, 3);
//		int res = inst.coinChange(new int[] {1}, 0);
		int res = inst.coinChange(new int[] {2147483647}, 2);
//		int res = inst.coinChange(new int[] {1}, 1);
//		int res = inst.coinChange(new int[] {1}, 2);
		System.out.println(res);
	}
}

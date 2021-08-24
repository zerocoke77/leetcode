package leet_322_coin_change;

import java.util.Arrays;

public class S_Leet_322_coin_change__dp_forloop {
	public int coinChange(int[] coins, int amount) {
		int dp[] = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;

		for (int coin : coins) {
			for (int j = coin; j <= amount; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin] + 1);
			}
		}

		return dp[amount] == amount + 1 ? -1 : dp[amount];
	}
    
	public static void main(String args[]) {
		S_Leet_322_coin_change__dp_forloop inst = new S_Leet_322_coin_change__dp_forloop();
		
		int res = inst.coinChange(new int[] {1, 2, 5}, 11);
//		int res = inst.coinChange(new int[] {2}, 3);
//		int res = inst.coinChange(new int[] {1}, 0);
//		int res = inst.coinChange(new int[] {1}, 1);
//		int res = inst.coinChange(new int[] {1}, 2);
		System.out.println(res);
	}
}

package leet_322_coin_change;

//	https://leetcode.com/problems/coin-change/solution/
//	time complexity: O(S^n)  S=>amount, n=>coins.length

public class Leet_322_coin_change__dp_recursive {
	public static int[]coinsArr;
	public static int[]dp;
	public static int max_value = 1 << 20;
    public int coinChange(int[] coins, int amount) {
        coinsArr = coins;
        dp = new int[10001];
        int recurRes = recur(amount); 
        return recurRes == max_value ? -1 : recurRes;
    }
    
    public int recur(int amount) {
    	if(amount == 0) return 0;
    	if(amount < 0) return max_value;
    	if(dp[amount] != 0) return dp[amount];
    	
    	int min = max_value;
    	for(int i=0; i<coinsArr.length; ++i) {
    		min = Math.min(min, recur(amount - coinsArr[i]) + 1);
    	}
    	
    	return dp[amount] = min >= max_value ? max_value : min;
    }
    
	public static void main(String args[]) {
		Leet_322_coin_change__dp_recursive inst = new Leet_322_coin_change__dp_recursive();
		
//		int res = inst.coinChange(new int[] {1, 2, 5}, 11);
//		int res = inst.coinChange(new int[] {2}, 3);
		int res = inst.coinChange(new int[] {1}, 0);
//		int res = inst.coinChange(new int[] {1}, 1);
//		int res = inst.coinChange(new int[] {1}, 2);
		System.out.println(res);
	}
}

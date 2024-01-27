class Solution {
    private static final int MOD = 1000000007;
    
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n+1][k+1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                int val = 0;
                for (int p = 0; p <= Math.min(j, i - 1); p++) {
                    val = (val + dp[i - 1][j - p]) % MOD;
                }
                dp[i][j] = val;
            }
        }

        return dp[n][k];
    }
}
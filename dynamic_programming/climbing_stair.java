class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return solve(n, memo);
    }

    private int solve(int n, int[] memo) {
        if (n <= 3) return n;
        if (memo[n] != 0) return memo[n];

        memo[n] = solve(n - 1, memo) + solve(n - 2, memo);
        return memo[n];
    }
}
// Recursion with memoization

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

// 

class Solution {
    public int climbStairs(int n) {
        if (n <= 3) return n;

        int a = 2;  
        int b = 3;  

        for (int i = 4; i <= n; i++) {
            int c = a + b; 
            a = b;
            b = c;
        }
        return b;
    }
}
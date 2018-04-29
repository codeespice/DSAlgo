package com.g.ds.trivial;

public class MinimumPath {
    public static void main(String args[])
    {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        MinimumPath minPath = new MinimumPath();
        int path= minPath.minPathSum(grid);
        System.out.println("Minumum Path = "+path);

    }
    //clean version
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Initialize
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                // Calculate DP
                int fromUp = i == 0 ? Integer.MAX_VALUE : dp[i - 1][j];
                int fromLeft = j == 0 ? Integer.MAX_VALUE : dp[i][j - 1];
                dp[i][j] = Math.min(fromUp, fromLeft) + grid[i][j];

            }
        }

        return dp[m - 1][n - 1];
    }
    //rolling array
    public int minPathSumRollingArray(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[2][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Initialize
                if (i == 0 && j == 0) {
                    dp[i % 2][j] = grid[i][j];
                    continue;
                }
                // Calculate DP
                int fromUp = i == 0 ? Integer.MAX_VALUE : dp[(i - 1) % 2][j];
                int fromLeft = j == 0 ? Integer.MAX_VALUE : dp[i % 2][j - 1];
                dp[i % 2][j] = Math.min(fromUp, fromLeft) + grid[i][j];

            }
        }

        return dp[(m - 1) % 2][n - 1];
    }
    //regularDp
    public int minPathSumRegularDp(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        // init:
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // calculate
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
    //lessOptimized
    public int minPathSumLessOptimized(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Initialize
                dp[i][j] = grid[i][j];
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0 && j > 0) {
                    dp[i][j] += dp[i][j - 1];
                } else if (i > 0 && j == 0) {
                    dp[i][j] += dp[i - 1][j];
                } else { // Calculate DP
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m - 1][n - 1];
    }
    //RollingArray)(n)
    public int minPathSumRollingArrayBigON(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[2][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Initialize
                dp[i % 2][j] = grid[i][j];
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0 && j > 0) {
                    dp[i % 2][j] += dp[i % 2][j - 1];
                } else if (i > 0 && j == 0) {
                    dp[i % 2][j] += dp[(i - 1) % 2][j];
                } else { // Calculate DP
                    dp[i % 2][j] += Math.min(dp[(i - 1) % 2][j], dp[i % 2][j - 1]);
                }
            }
        }

        return dp[(m - 1) % 2][n - 1];
    }
}

package com.kb.d22;

/**
 * @Author: Mr.Yang
 * @Description:
 * @Date: Created in 13:59 2021/8/22
 */
public class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = sumPart(mat, i, j, k);
            }
        }
        return ans;
    }
    private int sumPart(int[][] mat, int x, int y, int k){
        int sum = 0;
        for (int i = x - k; i < x + k; i++) {
            for (int j = y - k; j < y + k; j++) {
                if (i < 0 || i >= mat.length || j < 0 || j>= mat[0].length)continue;
                sum += mat[i][j];
            }
        }
        return sum;
    }

    public int[][] matrixBlockSum2(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i+1][j+1] = dp[i][j+1]+dp[i+1][j]-dp[i][j]+mat[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(i-k, 0);
                int c1 = Math.max(j-k, 0);
                int r2 = Math.min(i+k, m-1);
                int c2 = Math.min(j+k, n-1);
                ans[i][j] = dp[r2+1][c2+1] - dp[r1][c2+1]-dp[r2+1][c1]+dp[r1][c1];
            }
        }
        return ans;
    }
}

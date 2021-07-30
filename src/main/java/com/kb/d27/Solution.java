package com.kb.d27;

public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len<2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        for (int i = 2; i <= len; i++) {
            for (int j = 0; j < len; j++) {
                int k = i + j - 1;
                if (k >= len){
                    break;
                }
                if (chars[j] != chars[k]){
                    dp[j][k] = false;
                }else {
                    if (k - j < 3){
                        dp[j][k] = true;
                    }else {
                        dp[j][k] = dp[j+1][k-1];
                    }
                }
                if (dp[j][k] && k-j + 1>maxLen){
                    maxLen = k-j+1;
                    begin= j;
                }
            }
        }
        return s.substring(begin, begin+maxLen);
    }

    public int minPathSum(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        int[][] dp = new int[h][w];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < h; i++) {
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for (int i = 1; i < w; i++) {
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }

        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
            }
        }
        return dp[h-1][w-1];
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();
        if (m + n != t){
            return false;
        }
        boolean[][] dp = new boolean[n+1][m+1];

        dp[0][0] = true;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m ; j++) {
                int p = i+j-1;
                if (i > 0){
                    dp[i][j] = dp[i][j] || (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(p));
                }
                if (j > 0){
                    dp[i][j] = dp[i][j] || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(p));
                }
            }
        }
        return dp[n][m];
    }
}

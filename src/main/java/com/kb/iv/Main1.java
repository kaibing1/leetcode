package com.kb.iv;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    static final int N = 310;
    static int[][][] f = new int[N][N][N];
    static int[] w = new int[N];
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arrays.fill(f, -1);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
        }
        System.out.println(f[1][n][0]);
    }
    public static int dp(int l, int r, int p){
        if (l > r) return 0;
        if (f[l][r][p] != -1) return f[l][r][p];
        int ret = Integer.MAX_VALUE;
        for (int i = l; i <=r ; i++) {
            int left = dp(l, i-1, i);
            int right = dp(i+1, r, i);
            ret = Math.min(ret, left+right+w[i]*w[p]);
        }
        f[l][r][p] = ret;
        return ret;

    }
}

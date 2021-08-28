package com.kb.d26;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2){
            return len;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        int res = dp[0];

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
    public int[] getMaxMatrix(int[][] matrix){
        int[] ans = new int[4];
        int m = matrix.length;
        int n = matrix[0].length;
        int[] b = new int[n];
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int lx = 0;
        int ly = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                b[j] = 0;
            }
            for (int j = i; j < m; j++) {
                sum = 0;
                for (int k = 0; k < n; k++) {
                    b[k] += matrix[j][k];
                    if (sum > 0){
                        sum += b[k];
                    }else {
                        sum = b[k];
                        lx = i;
                        ly = k;
                    }
                    if (sum > maxSum){
                        maxSum = sum;
                        ans[0] = lx;
                        ans[1] = ly;
                        ans[2] = j;
                        ans[3] = k;
                    }
                }
            }
        }
        return ans;
    }

    public int numRescueBoats(int[] people, int limit) {
        int res = 0;
        int right = people.length-1;
        int left = 0;
        Arrays.sort(people);
        while (left <= right){
            if (left == right){
                res++;
                break;
            }
            if (people[left] + people[right] > limit){
                res++;
                right--;
            }else {
                res++;
                left++;
                right--;
            }
        }
        return res;
    }
}

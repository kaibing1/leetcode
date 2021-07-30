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
}

package com.kb.dp;

import org.junit.Test;

public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < n; i++) {
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max((i-j)*j, dp[i-j]*j));
            }
        }
        return dp[n];
    }
    @Test
    public void testCanP(){
        int[] nums = {1, 5, 11, 5};
        Solution solution = new Solution();
        solution.canPartition(nums);
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int[] dp = new int[10001];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i] ; j--) {
                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
            }
        }
        if (dp[target] == target) return true;
        return false;

    }
}

package com.kb.d21;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3};
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        System.out.println(new Solution().rob_3(nums));
    }
    // algorithm 1
    public int rob(int[] nums){
        return dp(nums, 0);
    }

    private int dp(int[] nums, int start){
        if (start >= nums.length){
            return 0;
        }
        int res = Math.max(dp(nums, start+1), nums[start]+dp(nums, start+2));
        return res;
    }
    // algorithm 2
    private int dp(int[] nums, int start, int[] memo){
        if (start >= nums.length){
            return 0;
        }
        if (memo[start] != -1) return memo[start];

        int res = Math.max(dp(nums, start+1), nums[start]+dp(nums, start+2, memo));
        memo[start] = res;
        return  res;
    }
    // algorithm
    public int rob_1(int[] nums){
        int d1 = 0, d2 = 0;
        int di = 0;
        for (int i = nums.length-1; i >=0; i--) {
            di = Math.max(d1, nums[i] + d2);
            d2 = d1;
            d1 = di;
        }
        return di;
    }

    public int rob_2(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }

    // 212
    public int rob_3(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(robRange(nums, 0, n-2), robRange(nums, 1, n-1));
    }
    private int robRange(int[] nums, int start, int end){
        int d_2 = 0;
        int d_1 = 0;
        int rtl = 0;
        for (int i = start; i <= end; i++) {
            rtl = Math.max(d_2+nums[i], d_1);
            d_2 = d_1;
            d_1 = rtl;
        }
        return rtl;
    }
    // 337
    Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob_4(TreeNode root) {
        if (root == null) return 0;
        if (memo.containsKey(root)){
            return memo.get(root);
        }
        int d = root.val+(root.left==null?0:rob_4(root.left.left)+rob_4(root.left.right))
                +(root.right==null? 0 :rob_4(root.right.left)+rob_4(root.right.right));
        int nd = rob_4(root.left) + rob_4(root.right);
        int res = Math.max(d, nd);
        memo.put(root, res);
        return res;
    }
}

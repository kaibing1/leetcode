package com.kb.d21;

import org.junit.Test;

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
    @Test
    public void cTest(){
        char[] chars = new char[]{'a','a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(new Solution().compress(chars));
    }
    public int compress(char[] chars) {
        StringBuffer buffer = new StringBuffer();
        int i = 0;
        while (i < chars.length){
            char c = chars[i];
            int j = 0;
            while (j+i < chars.length && chars[j+i] == c){
                j++;
            }
            buffer.append(c);
            if (j != 1){
                int tmp = j;
                StringBuffer tBuffer = new StringBuffer();
                while (tmp > 0){
                    tBuffer.append(tmp % 10);
                    tmp /= 10;
                }
                buffer.append(tBuffer.reverse());
            }
            i = j+i;
        }
        String s = buffer.toString();
        for (int j = 0; j < s.length(); j++) {
            chars[j] = s.charAt(j);
        }
        for (int j = 0; j < chars.length; j++) {
            System.out.println(chars[j]);
        }
        return s.length();
    }
    @Test
    public void lpsTest(){
        String s = "cbbd";
        Solution solution = new Solution();
        System.out.println(solution.longestPalindromeSubseq(s));
    }
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len-1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
//    public int candy(int[] ratings) {
//        int len = ratings.length;
//        int[] ans = new int[len];
//        for (int i = 0; i < len; i++) {
//            ans[i] = 1;
//        }
//        for (int i = 0; i < len; i++) {
//
//        }
//    }
}

package com.kb.d27;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

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

    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int sum = 0;
            int size = list.size();
            for (int i = 0; i < size-1; i++) {
                sum += list.get(i);
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }
        int ans = Integer.MIN_VALUE;
        for (Integer integer : map.keySet()) {
            ans = Math.max(ans,map.get(integer));
        }
        return wall.size() - ans;
    }

//    public boolean canReach(int[] arr, int start) {
//        boolean[] visited = new boolean[arr.length];
//        return dfs(arr, start, visited);
//    }
//
//    private boolean dfs(int[] arr, int start, boolean[] visited){
//        int x = arr[start];
//        if (x == 0) return true;
//        if (!visited[start]){
//            visited[start] = true;
//            if (start - arr[start] >= 0 && dfs(arr, start - arr[start], visited)) return true;
//            if (start+arr[start]<arr.length && dfs(arr, start + arr[start], visited)) return true;
//        }
//        return false;
//    }

//    public boolean canJump(int[] nums) {
//        return dfs(nums, 0);
//    }
//    public boolean dfs(int[] nums, int start){
//        if (start == nums.length-1){
//            return true;
//        }
//        int len = nums[start];
//        boolean flag = false;
//        for (int i = 1; i <= len; i++) {
//            if (start+i < nums.length){
//                flag = flag ||dfs(nums, start+i);
//            }
//        }
//        return flag;
//    }
    @Test
    public void cjTest(){
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(solution.canJump(nums));
    }
    public boolean canJump(int[] nums) {
        int maxJump = nums[0];
        for (int i = 1; i <= maxJump && i < nums.length; i++) {
            maxJump = Math.max(maxJump, nums[i]+i);
        }
        return maxJump >= nums.length-1;
    }
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        String[] data = preorder.split(",");
        for (String s : data) {
            stack.push(s);
            while (stack.size()>=3){
                String s1 = stack.pop();
                String s2 = stack.pop();
                String s3 = stack.pop();
                if ("#".equals(s1) && "#".equals(s2) && !"#".equals(s3)){
                    stack.push("#");
                }else {
                    stack.push(s3);
                    stack.push(s2);
                    stack.push(s1);
                    break;
                }
            }

        }
        return stack.size() == 1 && "#".equals(stack.peek());
    }

    public boolean judgeSquareSum(int c) {
        for(long a = 0; a * a <= c; a++){
            double b = Math.sqrt(c - a*a);
            if (b == (int)b){
                return true;
            }
        }
        return false;
    }

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums[i]+1; j++) {
                if (i + j < nums.length){
                    dp[i+j] = Math.min(dp[i+j], 1+dp[i]);
                }
            }
        }
        return dp[nums.length-1];
    }
}

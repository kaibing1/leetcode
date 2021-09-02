package com.kb.d28;

import com.kb.algorithm.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 2) return 0;
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }
        return intervals.length - count;
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int start = intervals[0][0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > intervals[i - 1][1]) {
                res.add(new int[]{start, intervals[i - 1][1]});
                start = intervals[i][0];
            } else {
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
            }
        }
        res.add(new int[]{start, intervals[intervals.length - 1][1]});
        return res.toArray(new int[res.size()][]);
    }

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
//    public int cuttingRope(int n) {
//        if(n < 4) return n-1;
//
//        long res= 1;
//        while(n > 4){
//            res *= 3;
//            res = res%1000000007;
//            n -= 3;
//        }
//        return (int)(res*n%1000000007);
//    }

    //    public int[] exchange(int[] nums) {
//        int[] res = new int[nums.length];
//        int s = 0;
//        int e = nums.length-1;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] % 2 == 1){
//                res[s++] = nums[i];
//            }else{
//                res[e--] = nums[i];
//            }
//        }
//        return res;
//    }
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            while (left <= right && nums[left] % 2 == 1) {
                left++;
            }
            while (left <= right && nums[right] % 2 == 0) {
                right--;
            }
            if (left > right) {
                break;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
    }

    public double myPow(double x, int n) {
        boolean flag = false;
        if (n < 0) {
            flag = true;
            n = -n;
        }
        double res = 1;
        while (n > 0) {
            res *= x;
            n--;
        }
        return !flag ? res : -res;
    }

    //    public List<Integer> findDuplicates(int[] nums) {
//        List<Integer> ans = new ArrayList<>();
//        Arrays.sort(nums);
//        int i = 0;
//        while (i < nums.length-1){
//            if (nums[i] == nums[i+1]){
//                ans.add(nums[i]);
//                i+=2;
//            }else {
//                i++;
//            }
//        }
//        return ans;
//    }
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]);
            if (nums[idx - 1] > 0) {
                nums[idx - 1] *= -1;
            } else {
                ans.add(idx);
            }
        }
        return ans;
    }

    private TreeNode pre = null;
    private TreeNode res = null;

    //    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        if (root == null) return null;
//        inorderSuccessor(root.left, p);
//        if (pre != null) {
//            if (pre.val == p.val) {
//                res = root;
//            }
//        }
//        pre = root;
//        inorderSuccessor(root.right, p);
//        return res;
//    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        inorderSuccessor(root.left, p);
        if (pre != null) {
            if (pre.val == p.val) {
                res = root;
            }
        }
        pre = root;
        inorderSuccessor(root.right, p);
        return res;
    }
    private List<Integer> ans;
    private StringBuffer sb;
    public int[] numsSameConsecDiff(int n, int k) {
        sb = new StringBuffer();
        ans = new ArrayList<>();
        dfs(n, k);

        return ans.stream().mapToInt(Integer::intValue).toArray();
//        int[] ints = new int[ans.size()];
//        for (int i = 0; i < ans.size(); i++) {
//            ints[i] = ans.get(i);
//        }
//        return ints;
    }
    private void dfs(int n, int k){
        if (sb.length() == n){
            ans.add(Integer.parseInt(sb.toString()));
            return;
        }
        int i = 0;
        if (sb.length()==0){
            i = 1;
        }
        for(; i < 10; i++){
            if (sb.length() != 0 && Math.abs((sb.charAt(sb.length()-1)-'0')-i)!=k){
                continue;
            }
            sb.append(i);
            dfs(n, k);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

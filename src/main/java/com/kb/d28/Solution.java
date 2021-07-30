package com.kb.d28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length < 2) return 0;
        Arrays.sort(intervals, (o1, o2)->{
            return o1[1] - o2[1];
        });
        int count =1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end){
                count++;
                end = intervals[i][1];
            }
        }
        return intervals.length - count;
    }

    public int[][] merge(int[][] intervals) {
        if (intervals==null || intervals.length <= 1){
            return intervals;
        }
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2)-> o1[0]-o2[0]);
        int start = intervals[0][0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > intervals[i-1][1]){
                res.add(new int[]{start, intervals[i-1][1]});
                start = intervals[i][0];
            }else {
                intervals[i][1] = Math.max(intervals[i][1], intervals[i-1][1]);
            }
        }
        res.add(new int[]{start, intervals[intervals.length - 1][1]});
        return res.toArray(new int[res.size()][]);
    }
    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i <=n ; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j * dp[i-j]));
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
        int left = 0, right = nums.length-1;
        while (left<=right){
            while (left<=right && nums[left] % 2 == 1){
                left++;
            }
            while (left<=right && nums[right] % 2 == 0){
                right--;
            }
            if (left>right){
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
        if (n < 0){
            flag = true;
            n = -n;
        }
        double res = 1;
        while (n > 0){
            res *= x;
            n--;
        }
        return !flag? res:-res;
    }
}

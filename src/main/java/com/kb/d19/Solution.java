package com.kb.d19;

import java.util.Arrays;

public class Solution {
    public int maxFrequency(int[] nums, int k){
        Arrays.sort(nums);
        int n = nums.length;
        long total = 0;
        int l=0,res=1;
        for (int r = 1; r < n; r++) {
            total += (long) (nums[r]-nums[r-1])*(r-l);
            while (total>k){
                total -= nums[r]-nums[l];
                ++l;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}

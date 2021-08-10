package com.kb.d10;

public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length < 3){
            return 0;
        }
        int res = 0;
        int add = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i-1] - nums[i] == nums[i-2] - nums[i-1]){
                res += ++add;
            }else {
                add = 0;
            }
        }
        return res;
    }
}

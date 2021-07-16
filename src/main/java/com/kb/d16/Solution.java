package com.kb.d16;

import org.junit.Test;

import java.util.ArrayList;

public class Solution {
    public int search(int[] nums, int target) {
        int count = 0;
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            int mid = (end-start)/2 + start;
            if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        if(nums[start] != target){
            return count;
        }else{
            for(int i = start; i < nums.length; i++){
                if(nums[i] == target){
                    count++;
                }
            }
            return count;
        }

    }
    @Test
    public void test(){

        int[] nums = {1, 2, 3, 3, 3, 4};
        Solution solution = new Solution();
        int result = solution.search(nums, 3);
        System.out.println(result);
    }
}

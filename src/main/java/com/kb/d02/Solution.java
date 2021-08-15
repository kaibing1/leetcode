package com.kb.d02;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for(int n : nums){
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0){
            div <<= 1;
        }
        int a = 0, b = 0;
        for(int n : nums){
            if ((div & n) != 0){
                a ^= n;
            }else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
    @Test
    public void singleTest(){
        int a = 5;
        int b = 6;
        System.out.println(a ^ a);
    }

    public int singleNumber(int[] nums){
        int[] counts = new int[32];
        for(int num:nums){
            for (int i = 0; i < 32; i++) {
                counts[i] += num&1;
                num >>>=1;
            }
        }
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            res <<=1;
            res |= counts[31-i] % m;
        }
        return res;
    }
    public long numberOfWeeks(int[] milestones) {
        Arrays.sort(milestones);
        int max = milestones[milestones.length-1];
        long total = 0L;
        for (int i = 0; i < milestones.length; i++) {
            total += milestones[i];
        }
        long rest = total - max;
        if (max > rest+1){
            return rest*2 + 1;
        }else {
            return max + rest;
        }

    }
    @Test
    public void numberTest(){
        Solution s = new Solution();
        int[] nums = {5, 2, 1};
        System.out.println(s.numberOfWeeks(nums));

    }

    public long minimumPerimeter(long neededApples) {
        long number = 0L;
        long r = 0L;
        while (number < neededApples){
            r += 1;
            number += 4*(r + 2*r);
        }
        return  2*r;
    }

    public int getLucky(String s, int k) {
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            int number = chars[i] - 'a' + 1;
            res += getSum(number);
        }
        for (int i = 1; i < k; i++) {
            res = getSum(res);
            if (res < 10){
                break;
            }
        }
        return res;
    }
    public int getSum(int i){
        int total = 0;
        while (i > 0){
            total += i % 10;
            i /= 10;
        }
        return total;
    }

    @Test
    public void testGetLucky(){
        String s = "leetcode";
        int k = 2;
        Solution solution = new Solution();
        System.out.println(solution.getLucky(s, k));
    }
//
//    public String maximumNumber(String num, int[] change) {
//        char[] chars = num.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            int index = chars[i];
//            if (change[index] > index){
//
//            }
//        }
//    }
}

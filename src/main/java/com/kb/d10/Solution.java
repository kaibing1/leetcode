package com.kb.d10;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;

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

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (set.remove(num)){
                int currentLongest = 1;
                int current = num;
                while (set.remove(current-1)) current--;
                currentLongest += (num-current);
                current = num;
                while (set.remove(current+1)) current++;
                currentLongest += (current-num);
                res = Math.max(res, currentLongest);
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        Integer integer = new Integer(1);
//        System.out.println(integer instanceof Object);
        int x = 1;
        float y = 2;
        System.out.println(x/y);
//        Arrays.asList()
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

//        byte a1 = 2, a2= 4, a3;
//        short s =16;
//        a2 = s;
//        a3 = a1*a2;
//        String s = "1";
//        int s1 = 1;
//        float s2 = 1.0f;
//        System.out.println(s + s1+s2);
//        System.out.println(17^5);
//        class a{
//            public void show(){
//                System.out.println(super.hashCode());
//            }
//        }
//        class b{
//            public void show(){
//                System.out.println(super.hashCode());
//            }
//        }
//        new a().show();
//        new b().show();
        System.out.println(100 + 5 + "is");

    }
    @Test
    public void test(){
        int[] nums = {3, 2, 1};
        int[] p = {1, 1, 1};
        for (int i = 0; i < p.length; i++) {
            int n = p[i];
            int[] tmp = new int[nums.length];
            for (int j = n; j < nums.length; j++) {
                tmp[j-n] = nums[j];
            }
            for (int j = 0; j < n; j++) {
                tmp[nums.length - n + j] = nums[j];
            }
            nums = tmp;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


}

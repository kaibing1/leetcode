package com.kb.d17;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: Mr.Yang
 * @Description:
 * @Date: Created in 20:38 2021/6/17
 */
public class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for (int i = 0; i < patterns.length; i++) {
            if (word.contains(patterns[i])){
                res++;
            }
        }
        return res;
    }
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length-1; i+=2) {
            int tmp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3, 4, 5};
        int target = 3;
        System.out.println(rightBound(nums, target));
    }

    public static int leftBound(int[] nums, int target){
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if (nums[mid] == target){
                right = mid-1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid-1;
            }
        }
        if (left>= nums.length || nums[left] != target){
            return -1;
        }
        return left;
    }

    public static int rightBound(int[] nums, int target){
        int left = 0, right = nums.length -1;
        while (left <= right){
            int mid = left + (right-left);
            if (nums[mid] == target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid -1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        if (right<0 || nums[right] != target){
            return -1;
        }
        return right;
    }



    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> cnt = new HashMap<>();
    // 76
    public String minWindow(String s, String t){
        int tLength = t.length();
        for (int i = 0; i < tLength; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0)+1);
        }
        int left = 0, right = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLength = s.length();
        while (right < sLength){
            right++;
            if (right < sLength && ori.containsKey(s.charAt(right))){
                cnt.put(s.charAt(right), cnt.getOrDefault(s.charAt(right), 0)+1);
            }
            while (check() && left <= right){
                if (right-left+1 < len){
                    len = right - left + 1;
                    ansL = left;
                    ansR = left + len;
                }
                if (ori.containsKey(s.charAt(left))){
                    cnt.put(s.charAt(left), cnt.getOrDefault(s.charAt(left), 0)-1);
                }
                left++;
            }
        }
        return ansL == -1?"":s.substring(ansL, ansR);

    }

    public boolean check(){
        for (Map.Entry<Character, Integer> entry : ori.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (cnt.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return  true;
    }


    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0;
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }

}

package com.kb.d17;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: Mr.Yang
 * @Description:
 * @Date: Created in 20:38 2021/6/17
 */
public class Solution {
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

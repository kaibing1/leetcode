package com.kb.d18;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.util.*;

public class Solution {
    // 2106
//    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> result = new ArrayList<>();
//        HashMap<String, List<String>> map = new HashMap<>();
//        for(String s : strs){
//            String sortStr = sort(s);
//            if(!map.containsKey(sortStr)){
//                List<String> tmp = new ArrayList<>();
//                tmp.add(s);
//                map.put(sortStr, tmp);
//            }else{
//                List<String> tmp = map.get(sortStr);
//                tmp.add(s);
//            }
//        }
//        map.forEach((key, value) ->{
//            result.add(value);
//        });
//        return result;
//    }
//
//    public String sort(String s){
//        char[] c = s.toCharArray();
//        Arrays.sort(c);
//        return Arrays.toString(c);
//    }
//    public List<List<String>> groupAnagrams(String[] strs) {
//        HashMap<String, List<String>> map = new HashMap<>();
//        for (int i=0; i<strs.length;i++){
//            char[] tmp = strs[i].toCharArray();
//            Arrays.sort(tmp);
//            String key = new String(tmp);
//            List<String> list = map.getOrDefault(key, new ArrayList<>());
//            list.add(strs[i]);
//            map.put(key, list);
//        }
//        return new ArrayList<>(map.values());
//    }
    public static void main(String[] args) {
        String s = "20000000000000000000";
        System.out.println(new Solution().myAtoi(s));
    }

    public int myAtoi(String s) {
        s = s.trim();
        long ans = 0;
        int flag = 1;
        int i = 0;
        if (s.startsWith("-")){
            flag = -1;
            i = 1;
        }else if (s.startsWith("+")){
            i = 1;
        }
        while (i < s.length()){
            if (s.charAt(i) == '0'){
                i++;
            }else {
                break;
            }
        }
        Stack<Integer> stack = new Stack<>();
        for (;i<s.length();i++) {
            char c = s.charAt(i);
            if (c >'9' || c < '0'){
                break;
            }
            stack.push(c - '0');
        }
        long f = 1;
        while (!stack.isEmpty()){
            ans +=  f * stack.pop();
            f *= 10;
            if (f > Integer.MAX_VALUE && !stack.isEmpty()){
                if (flag == 1){
                    ans = Integer.MAX_VALUE;
                }else {
                    ans = -(long) Integer.MIN_VALUE;
                }
                break;
            }
            if (flag==1 && ans > Integer.MAX_VALUE){
                ans = Integer.MAX_VALUE;
                break;
            }else if (flag == -1 && ans>-(long) Integer.MIN_VALUE){
                ans = -(long) Integer.MIN_VALUE;
                break;
            }
        }
        ans *= flag;

        return (int) ans;
    }

}

package com.kb.d12;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s = "HG[3|B[2|CA]]F";
        System.out.println(new Solution().compress(s));
    }
    public String compress(String s){


        return solve(s);
    }
    public String solve(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ']'){
                stack.push(c);
            }else{
                String tmp = "";
                while (stack.peek() != '|'){
                    tmp += stack.pop();
                }
                stack.pop();
                int n = 0, k =1;
                while (stack.peek()!= '['){
                    n += (stack.pop()-'0')*k;
                    k *= 10;
                }
                stack.pop();
                for (int j = 0; j < n; j++) {
                    for (int l = tmp.length()-1; l >=0 ; l--) {
                        stack.push(tmp.charAt(l));
                    }
                }
            }
        }
        int size = stack.size();
        char[] rtl = new char[size];
        for (int i = size -1; i >=0 ; i--) {
            rtl[i] = stack.pop();
        }
        return new String(rtl);
    }

}

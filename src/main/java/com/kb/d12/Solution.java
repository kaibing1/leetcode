package com.kb.d12;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        Arrays.sort(scores);
        List<Integer> rtl = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int threshold = scores[i];
            int win = n - i -1;
            int fail = i + 1;
            if (win>=x && win <= y && fail>=x && fail <= y){
                rtl.add(threshold);
            }
        }
        if (rtl.size() == 0){
            System.out.println(-1);
        }else {
            System.out.println(rtl.get(0));
        }

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

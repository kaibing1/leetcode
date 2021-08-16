package com.kb.d12.q8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        int maxValue = 0;
        int max = 0;
        String s = reader.readLine().trim();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'E'){
                max ++;
            }
            if (c == 'F'){
                max --;
            }
            maxValue = Math.max(max, maxValue);
            max = Math.max(max, 0);
        }
        System.out.println(maxValue);
    }
}

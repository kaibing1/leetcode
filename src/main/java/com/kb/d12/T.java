package com.kb.d12;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class T {
    public static void main(String[] args) {
//        int n, x, y;
//        Scanner scanner = new Scanner(System.in);
//        n = scanner.nextInt();
//        x = scanner.nextInt();
//        y = scanner.nextInt();
//        int[] d = new int[n];
//        for (int i = 0; i < n; i++) {
//            d[i] = scanner.nextInt();
//        }
//        Arrays.sort(d);
//        int left = 0;
//        int right = n;
//        for (int i = 0; i < n; i++) {
//            int num = d[i];
//            left++;
//            right--;
//            if (left<=y && left>=x && right>= x && right<= y){
//                System.out.println(num);
//                return;
//            }
//        }
//        System.out.println(-1);
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        Arrays.sort(d);
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.abs(i+1 - d[i]);
        }
        System.out.println(res);
    }
    @Test
    public void t1(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int read = reader.read();
            System.out.println(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

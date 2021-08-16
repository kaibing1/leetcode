package com.kb.d12.q8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] params = br.readLine().trim().split(" ");
        int a = Integer.parseInt(params[0]);
        int b = Integer.parseInt(params[1]);
        int c = Integer.parseInt(params[2]);
        int d = Integer.parseInt(params[3]);
        int e = Integer.parseInt(params[4]);
        int f = Integer.parseInt(params[5]);
        int g = Integer.parseInt(params[6]);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        maxHeap.offer(new int[]{a, e});
        maxHeap.offer(new int[]{b, f});
        maxHeap.offer(new int[]{c, g});
        long money = 0;
        while (!maxHeap.isEmpty() && d > 0){
            int[] temp = maxHeap.poll();
            money += (long) Math.min(temp[0], d) * temp[1];
            d -= temp[0];
        }
        System.out.println(money);
    }
}

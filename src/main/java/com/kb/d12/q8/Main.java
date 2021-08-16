package com.kb.d12.q8;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] params = reader.readLine().trim().split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);
        int q = Integer.parseInt(params[2]);
        int op, x, y;
        boolean[] locked = new boolean[10001];
        boolean[] hasBook = new boolean[10001];
        int[] pos = new int[10001];
        for (int i = 0; i < q; i++) {
            params = reader.readLine().trim().split(" ");
            if (params.length == 3){
                op = Integer.parseInt(params[0]);
                x = Integer.parseInt(params[1]);
                y = Integer.parseInt(params[2]);
                if (hasBook[x]) continue;
                if (locked[y]) continue;
                if (pos[x] != 0 && locked[pos[x]]) continue;
                pos[x] = y;
            }else {
                op = Integer.parseInt(params[0]);
                if (op == 2){
                    y = Integer.parseInt(params[1]);
                    locked[y] = true;
                }else if (op == 3){
                    y = Integer.parseInt(params[1]);
                    locked[y] = false;
                }else if (op == 4){
                    x = Integer.parseInt(params[1]);
                    if (pos[x] != 0 && !locked[pos[x]]){
                        System.out.println(pos[x]);
                        pos[x] = 0;
                        hasBook[x] = true;
                    }else {
                        System.out.println(-1);
                    }
                }else {
                    x = Integer.parseInt(params[1]);
                    if (!hasBook[x]) continue;
                    hasBook[x] = false;
                }
            }
        }
    }
}

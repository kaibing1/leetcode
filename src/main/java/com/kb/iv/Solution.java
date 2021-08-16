package com.kb.iv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        List<Integer> res;
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(reader.readLine());
            String tables = reader.readLine().trim();
            int M = Integer.parseInt(reader.readLine());
            String cI = reader.readLine().trim();
            res = solve(tables, cI);
            for (int j = 0; j < res.size(); j++) {
                writer.write(Integer.toString(res.get(j)));
                writer.newLine();
            }
            writer.flush();
        }
    }
//    @Test
//    public void test() throws IOException {
//
//    }
    public static List<Integer> solve(String tables, String cI){
        List<Integer> res = new ArrayList<>();
        ArrayList<PriorityQueue<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new PriorityQueue<Integer>());
        }
        for (int i = 0; i < tables.length(); i++) {
            int t = tables.charAt(i) - '0';
            list.get(t).add(i);
        }
        for (int i = 0; i < cI.length(); i++) {
            char gender = cI.charAt(i);
            int table;
            if (gender == 'M'){
                if (!list.get(1).isEmpty()){
                    table = list.get(1).poll();
                    list.get(2).add(table);
                }else {
                    table = list.get(0).poll();
                    list.get(1).add(table);
                }
            }else {
                if (!list.get(0).isEmpty()){
                    table = list.get(0).poll();
                    list.get(1).add(table);
                }else {
                    table = list.get(1).poll();
                    list.get(2).add(table);
                }
            }
            res.add(table + 1);
        }
        return res;
    }
}

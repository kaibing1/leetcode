package com.kb.d12.q9;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cnt = reader.read();
        writer.write(String.valueOf(cnt - '0'));
        writer.flush();
        for (int i = 0; i < cnt; i++) {
            String input = reader.readLine();
            String[] data = input.trim().split(" ");
            int tmp = 0;
            for (int j = 1; j < data.length; j++) {
                tmp += Integer.parseInt(data[j]);
            }
            writer.write(String.valueOf(tmp));
            writer.newLine();
            writer.flush();
        }
    }
}

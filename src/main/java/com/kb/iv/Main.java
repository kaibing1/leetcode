package com.kb.iv;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T;
        T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            int N;
            N = Integer.parseInt(reader.readLine());
            int[] d = new int[N];
            String tmp = reader.readLine();
            char[] chars1 = tmp.toCharArray();
            for (int j = 0; j < N; j++) {
                d[j] = chars1[j] - '0';
            }
            int M;
            M = Integer.parseInt(reader.readLine());
            String s = reader.readLine();
            boolean flag;
            for (int j = 0; j < M; j++) {
                char gender = s.charAt(j);
                flag = false;
                if (gender == 'F'){
                    for (int k = 0; k < N; k++) {
                        if (d[k] == 0){
                            writer.write(Integer.toString(k+1));
                            writer.newLine();
                            d[k] += 1;
                            flag = true;
                            break;
                        }
                    }
                    if (!flag){
                        for (int k = 0; k < N; k++) {
                            if (d[k] == 1){
                                writer.write(Integer.toString(k+1));
                                writer.newLine();
                                d[k] += 1;
                                break;
                            }
                        }
                    }

                }else{
                    for (int k = 0; k < N; k++) {
                        if (d[k] == 1){
                            writer.write(Integer.toString(k+1));
                            writer.newLine();
                            d[k] += 1;
                            flag = true;
                            break;
                        }
                    }
                    if (!flag){
                        for (int k = 0; k < N; k++) {
                            if (d[k] == 0){
                                writer.write(Integer.toString(k+1));
                                writer.newLine();
                                d[k] += 1;
                                break;
                            }
                        }
                    }

                }
            }
            writer.flush();
        }
    }
}

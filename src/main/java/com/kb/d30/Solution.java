package com.kb.d30;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Solution {
    List<String> res;
    StringBuilder path;
    public String[] permutation(String s) {
        res = new ArrayList<>();
        path = new StringBuilder();
        char[] chars = s.toCharArray();
        boolean[] visited = new boolean[chars.length];
        traversal(chars, visited);
        return res.toArray(new String[0]);
    }
    private void traversal(char[] chars, boolean[] visited){
        if (path.length()==chars.length){
            res.add(path.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) continue;
            path.append(chars[i]);
            visited[i] = true;
            traversal(chars, visited);
            path.deleteCharAt(path.length()-1);
            visited[i]=false;
        }
    }
    @Test
    public void test(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(50, 30, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        });

    }
}

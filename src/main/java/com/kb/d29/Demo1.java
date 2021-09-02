package com.kb.d29;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Mr.Yang
 * @Description:
 * @Date: Created in 18:49 2021/8/29
 */
public class Demo1 {
    public static void main(String[] args) {
        File file = new File("./src/main/java/");
//        for (File listFile : file.listFiles()) {
//            System.out.println(listFile.getName());
//        }
        Queue<File> q = new LinkedList<>();
        q.offer(file);
        while (!q.isEmpty()){
            int len = q.size();
            for (int i = 0; i < len; i++) {
                File tmp = q.poll();
                if (tmp.isDirectory()){
                    File[] files = tmp.listFiles();
                    for (File f : files) {
                        q.offer(f);
                    }
                }else {
                    System.out.println(tmp.getAbsolutePath());
                }
            }
        }
    }
}

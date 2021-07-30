package com.kb.thread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ThreadPoolExecutor;

public class c1 {
    boolean flag = true;

    public void show() {
        System.out.println("thread starting");
        Unsafe unsafe = null;
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe)theUnsafe.get(null);
        }catch (Exception e){
            e.printStackTrace();
        }

        while (flag){
            unsafe.loadFence();
        }
        System.out.println("thread ending");
    }

    public static void main(String[] args) throws Exception {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor();
    }
}

package com.kb.d30.Threads;

/**
 * @Author: Mr.Yang
 * @Description:
 * @Date: Created in 16:45 2021/8/30
 */
public class TLDemo01 {
    static ThreadLocal<String> tl = new ThreadLocal<>();
    private volatile String value;

    public static void main(String[] args) {
        TLDemo01 tlDemo01 = new TLDemo01();
        for (int i = 0; i < 50; i++) {
            int finalI = i;
            new Thread(new Runnable(){
                @Override
                public void run() {
                    tlDemo01.value = String.valueOf(finalI);
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName() + tlDemo01.value);
                    tl.set(Thread.currentThread().getName()+finalI);
                    System.out.println(tl.get());
                }
            }, "thread " + finalI +" value is ").start();
        }

    }
}

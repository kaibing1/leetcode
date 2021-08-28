package com.kb.mix.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test2 {
    static class myServer{
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();
        private volatile boolean flag = true;

        public void printOne(){
            try {
                lock.lock();
                while (flag){
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName()+"-------");
                flag = true;
                condition.signal();
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
        public void printTwo(){
            try {
                lock.lock();
                while (!flag){
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName()+"*******");
                flag = false;
                condition.signal();
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) {
        myServer myServer = new myServer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    myServer.printOne();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    myServer.printTwo();
                }
            }
        }).start();
    }
}

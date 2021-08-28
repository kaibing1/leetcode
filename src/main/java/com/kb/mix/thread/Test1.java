package com.kb.mix.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {
    public static void main(String[] args) {
        subThread sub = new subThread(10);
        new Thread(new Runnable() {
            @Override
            public void run() {
                sub.printEven();
            }
        },"Even ").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                sub.printOdd();
            }
        },"Odd ").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                sub.show();
            }
        },"show ").start();
    }
    static class subThread {
        private ReentrantLock lock = new ReentrantLock();
        private Condition c1;
        private Condition c0;
        private Condition c2;
        private volatile int i = 0;
        private volatile int n;
        private volatile boolean flag = false;
        public subThread(int n){
            this.n = n;
            c0 = lock.newCondition();
            c1 = lock.newCondition();
            c2 = lock.newCondition();
        }
        public void show(){
            while (i <= n){
                try {
                    lock.lock();

                    System.out.println(Thread.currentThread().getName()+0);
                    i++;
                    c1.signal();
                    c0.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
        public void printEven(){
            while (i <= n){
                try {
                    lock.lock();
                    if (i % 2 == 0){
                        c1.await();
                    }
                    System.out.println(Thread.currentThread().getName()+i);
                    c0.signal();
                    c1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }

        }
        public void printOdd(){
            while (i <= n){
                try {
                    lock.lock();
                    if (i % 2 != 0){
                        c1.await();
                    }
                    System.out.println(Thread.currentThread().getName()+i);
                    c0.signal();
                    c1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }

        }

    }
}

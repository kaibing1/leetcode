package com.kb.mix;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class threadDemo{
   
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock=new ReentrantLock();
        Condition one =lock.newCondition();
        Condition two=lock.newCondition();
        //第一个线程，从1开始
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                while (i<=20){
                    lock.lock();
                    System.out.print("\nthread--1----:"+i);
                    try {
                        //如果另一个线程等待，则唤醒对方之后，自己等待
                        two.signalAll();
                        i=i+2;
                        if (i > 20){
                            break;
                        }
                        one.await();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        lock.unlock();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 2;
                while (i<=20){
                    lock.lock();
                    System.out.print("\nthread--2----:"+i);
                    try {
                        //如果另一个线程等待，则唤醒对方之后，自己等待
                        one.signalAll();
                        i=i+2;
                        if (i > 20){
                            break;
                        }
                        two.await();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }).start();

    }

   
}

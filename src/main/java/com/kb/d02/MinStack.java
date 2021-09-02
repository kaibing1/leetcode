package com.kb.d02;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: Mr.Yang
 * @Description:
 * @Date: Created in 09:33 2021/9/2
 */
public class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;
    public MinStack(){
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }
    public void push(int x){
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop(){
        xStack.pop();
        minStack.pop();
    }
    public int top(){
        return xStack.peek();
    }
    public int getMin(){
        return minStack.peek();
    }
//    PriorityQueue<Integer> data;
//    LinkedList<Integer> list;
//    public MinStack(){
//        data = new PriorityQueue<>();
//        list = new LinkedList<>();
//    }
//
//    public void push(int x){
//        data.add(x);
//        list.addLast(x);
//    }
//
//    public void pop(){
//        Integer first = list.getLast();
//        data.remove(first);
//        list.removeLast();
//    }
//    public int top(){
//        return list.getLast();
//    }
//
//    public int getMin(){
//        if (!data.isEmpty())
//            return data.peek();
//        else
//            return -1;
//    }
}

package com.kb.d26;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Box<T>{
    private T t;
    public void setT(T t){
        this.t = t;
    }
    public T getT(){
        return this.t;
    }

    @Test
    public void test1(){
        List<String>[] lists = new List[10];

    }
}

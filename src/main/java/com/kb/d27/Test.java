package com.kb.d27;

import java.util.Date;

public class Test extends Date {
    public static void main(String[] args) {
        new Test().show();
    }
    public void show(){

        System.out.println(super.getClass().getName());
    }
}

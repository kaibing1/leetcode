package com.kb.d12.q8;

public class A{
    @Override
    public boolean equals(Object obj) {
        return (this == obj);
    }

    public static void main(String[] args) {
        A a = new A();
        A a1 = new A();
        System.out.println(a.equals(a1));
    }
}

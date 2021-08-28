package com.kb.d26;

public class Man implements Human{
    @Override
    public void show() {
        System.out.println("man");
    }

    public static void main(String[] args) {
        Human human = new Man();
//        Human human;
        System.out.println(human.getClass().getName());
        int[] ints = new int[10];
        System.out.println(ints.getClass().getName());
    }
}

package com.kb.mp;

/**
 * @Author: Mr.Yang
 * @Description:
 * @Date: Created in 09:11 2021/8/20
 */
public class Man implements People{

    @Override
    public void show() {
        System.out.println("man");
    }

    public static void main(String[] args) {
        People p = new Man();
        p.show();
    }
}

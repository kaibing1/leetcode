package com.kb.d30;

import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Mr.Yang
 * @Description:
 * @Date: Created in 15:20 2021/8/30
 */
public class Demo01 {
    public static void main(String[] args) {
//        Mappering o =(Mappering) Proxy.newProxyInstance(Demo01.class.getClassLoader(), new Class[]{Mappering.class}, new Handler());
//        o.show();
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        System.out.println(map.size());
    }
}

package com.kb.d02;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: Mr.Yang
 * @Description:
 * @Date: Created in 09:26 2021/9/2
 */
public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Monkey monkey = new Monkey();
//        monkey.id = 1;
//        Monkey m1 = new Monkey();
//        m1.id = 2;
//        Field id = monkey.getClass().getDeclaredField("id");
//        id.setAccessible(true);
//        int o =(int) id.get(m1);
//        System.out.println(o);
        Field name = monkey.getClass().getDeclaredField("name");
        name.setAccessible(true);
        name.set(monkey, "nihao");
        monkey.show();
        for (Field declaredField : monkey.getClass().getDeclaredFields()) {
            System.out.println(declaredField.getName());
        }
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(Human.class);
//        enhancer.setCallback(new MethodInterceptor() {
//            @Override
//            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                System.out.println(o.getClass());
//                System.out.println(method.getName());
//                System.out.println(methodProxy.getClass());
//                System.out.println("show");
//                return null;
//            }
//        });
//
//        Human o =(Human) enhancer.create();
//        Method show = o.getClass().getMethod("show");
//        System.out.println(show.getDeclaringClass());
//
//        o.show();
    }
}

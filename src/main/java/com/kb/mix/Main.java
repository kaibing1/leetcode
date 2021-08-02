package com.kb.mix;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(null, 1);
        map.put(null, 2);
        System.out.println(map.get(null));
    }
}

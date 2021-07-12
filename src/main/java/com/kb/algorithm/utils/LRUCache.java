package com.kb.algorithm.utils;

import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public LRUCache(int capacity){
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }
    private void makeRecently(int key){
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }

    private void addRecently(int key, int val){
        Node x = new Node(key, val);
        cache.addLast(x);
        map.put(key, x);
    }
    private void deleteKey(int key){
        Node x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }
    private void removeLeastRecently(){
        Node deleteNode = cache.removeFirst();
        int deletedKey = deleteNode.key;
        map.remove(deletedKey);
    }

    public int get(int key){
        if (!map.containsKey(key)){
            return -1;
        }
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int val){
        if (map.containsKey(key)){
            deleteKey(key);
            addRecently(key, val);
            return;
        }
        if (cap == cache.size()){
            removeLeastRecently();
        }
        addRecently(key, val);
    }
}

package com.kb.d12;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import java.util.*;

public class Main {
    static int i = 0;
    public static void main(String[] args) {
        int TOTAL = 10;

        Object lock = new Object();
        new Thread(() -> {
            while (i <= TOTAL){
                synchronized (lock){
                    if (i % 2 == 1){
                        System.out.println(i++);
                        lock.notify();
                    }else{
                        try {
                            lock.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        new Thread(() -> {
            while (i <= TOTAL){
                synchronized (lock){
                    if (i % 2 == 0){
                        System.out.println(i++);
                        lock.notify();
                    }else{
                        try {
                            lock.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass){
        if (map == null){
            return null;
        }
        Object object = null;
        try {
            object = beanClass.newInstance();
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field :
                    fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)){
                    continue;
                }
                field.setAccessible(true);
                field.set(object, map.get(field.getName()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return object;
    }
    public static void quickSort(int[] nums, int left, int right){
        if (left > right){
            return;
        }
        int base = nums[left];
        int i = left, j = right;
        while (i != j){
            // 找到右边第一个值
            while (nums[j] >= base && i < j){
                j--;
            }
            while (nums[i] <= base && i < j){
                i++;
            }
            if (i < j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = nums[i];
            }
        }
        nums[left] = nums[i];
        nums[i] = base;
        quickSort(nums, left, i-1);
        quickSort(nums, i+1, right);
    }
    @Test
    public void test(){
        int[] nums = new int[]{1, -10, 2, 49, 8, 2};
        Arrays.sort(nums);
//        quickSort(nums, 0, nums.length-1);
        for (int num:
             nums) {
            System.out.println(num);
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        HashSet<ListNode> rtl = new HashSet<>();
        ListNode cur = head;
        while (cur!=null){
            if (!rtl.contains(cur)){
                rtl.add(cur);
                cur = cur.next;
            }else {
                return cur;
            }
        }
        return null;
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = g.length-1;
        int j = s.length-1;
        int rtl = 0;
        while (i >= 0 && j >= 0) {
            if (g[i] <= s[j]) {
                rtl++;
                i--;
                j--;
            } else {
                i--;
            }
        }
        return rtl;
    }
    List<List<Integer>> results;
    List<Integer> path;
    int[] selects = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    public List<List<Integer>> combinationSum3(int k, int n) {
        results = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(n, k, 0, 0);
        return results;
    }

    public void backtracking(int n, int k, int startIndex, int tmp){
        if (path.size() == k && tmp == n){
            results.add(new ArrayList<>(path));
            return;
        }
        for (int j = startIndex; j < selects.length; j++) {
            int number = selects[j];
            tmp += number;
            path.add(number);
            backtracking(n, k, j+1, tmp);
            path.remove(path.size()-1);
            tmp -= number;
        }
    }


//    public List<List<Integer>> combine(int n, int k) {
//        results = new ArrayList<>();
//        path = new ArrayList<>();
//        backtracking(n, k, 1);
//        return results;
//    }
//    public void backtracking(int n, int k, int startIndex){
//        if (path.size() == k){
//            results.add(new ArrayList<>(path));
//            return;
//        }
//        for (int j = startIndex; j <= n; j++) {
//            path.add(j);
//            backtracking(n, k, j+1);
//            path.remove(path.size()-1);
//        }
//    }
}

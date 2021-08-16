package com.kb.d10;

public class A {
    public static void main(String[] args) {
//        System.out.println(test());
//        String s = null;
//        if ((s != null) &(s.length() > 0)){
//            System.out.println(s);
//        }
        int[] nums = {3, 2, 1};
        int[] p = {1, 1, 1};
        int ind = 0;
        for (int i = 0; i < p.length; i++) {
            ind += p[i];
            ind %= nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[ind++]);
            ind %= nums.length;
        }
    }
    public static void reverse(int[] nums, int s, int e){
        while (s < e){
            int tmp = nums[s];
            nums[s] = nums[e];
            nums[e] = tmp;
            s++;
            e--;
        }
    }

    public static int test() {
        int temp = 1;
        try {
            System.out.println(temp);
            return ++temp;
        } catch (Exception e) {
            System.out.println(temp);
            return ++temp;
        } finally {
            ++temp;
            System.out.println(temp);
        }
    }

    static int update(int x[], int y) {
        for (int i = 1; i < x.length; i++)
            if (y < x.length) x[i] = x[i - 1] + 1;
        return x[1];
    }
}

package com.kb.algorithm.utils;

import org.junit.Test;

import java.util.Arrays;

public class Sort {
    public void quickSort(int[] nums, int start, int end){
        if (end < start){
            return;
        }
        int base = nums[start];
        int i = start, j = end;
        while (i < j){
            while (nums[j]>= base && j > i){
                j--;
            }
            while (nums[i] <= base && i < j){
                i++;
            }
            if (i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[start] = nums[i];
        nums[i] = base;
        quickSort(nums, start, i-1);
        quickSort(nums, i+1, end);
    }
    @Test
    public void testQuickSort(){
        int[] nums = {5,4,4,5,62,99,98,54,56,17,18,23,34,15,35,25,53,51};;
        Sort sort = new Sort();
        sort.quickSort(nums, 0, nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public void bubbleSort(int[] nums){
        boolean swapped = true;
        int total = nums.length-2;
        int temp;
        while (swapped){
            swapped = false;
            for (int i = 0; i <= total; i++) {
                if (nums[i] > nums[i+1])
                {
                    temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                    swapped = true;
                }
            }
            total--;
        }
    }
    @Test
    public void testBubbleSort(){
        int[] nums = {1, 2, 2, 3, 4, 5};
        Sort sort = new Sort();
        sort.bubbleSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public void selectSort(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[min]){
                    min = j;
                }
            }
            if (i != min){
                int tmp = nums[i];
                nums[i] = nums[min];
                nums[min] = tmp;
            }
        }
    }
    @Test
    public void testSelectSort(){
        int[] nums = {1, 2, 2, 3, 4, -5};
        Sort sort = new Sort();
        sort.selectSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public void insertSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];

            int j = i;
            while (j > 0 && tmp < nums[j-1]){
                nums[j] = nums[j-1];
                j--;
            }
            if (j != i){
                nums[j] = tmp;
            }
        }
    }

    @Test
    public void testInsertSort(){
//        boolean[] flag = new boolean[10];
//        System.out.println(flag[0]);
        int[] nums = {1, 2, 2, 3, 4, -5};
        Sort sort = new Sort();
        sort.insertSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}

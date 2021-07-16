package com.kb.backtracking;

import java.nio.file.Path;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    // 17
//    String[] map = {"", "", "abc", "def", "ghi","jkl","mno", "pgrs", "tuv","wxyz"};
//    List<String> results;
//    StringBuffer sb;
//    public List<String> letterCombinations(String digits) {
//
//        results = new ArrayList<>();
//        sb = new StringBuffer();
//        if (digits.length() == 0){
//            return results;
//        }
//        backtracking(digits, 0);
//        return results;
//    }
//    public void backtracking(String digits, int startIndex){
//        if (sb.length() > digits.length()){
//            return;
//        }
//        if (sb.length() == digits.length()){
//            results.add(sb.toString());
//            return;
//        }
//        int digit = digits.charAt(startIndex) - '0';
//        String item = map[digit];
//        for (int i = 0; i < item.length(); i++) {
//            sb.append(item.charAt(i));
//            backtracking(digits, startIndex+1);
//            sb.deleteCharAt(sb.length()-1);
//        }
//
//    }
//    // 39
//    List<List<Integer>> items;
//    List<Integer> item;
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        items = new ArrayList<>();
//        item = new ArrayList<>();
//        if (candidates.length== 0){
//            return items;
//        }
//        backtracking(candidates, target, 0, 0);
//        return items;
//    }
//    public void backtracking(int[] candidates, int target, int sum, int index){
//        if (sum > target){
//            return;
//        }
//        if (target == sum){
//            items.add(new ArrayList<>(item));
//            return;
//        }
//
//        for (int i = index; i < candidates.length; i++) {
//            int number = candidates[i];
//            sum += number;
//            item.add(number);
//            backtracking(candidates, target, sum, i);
//            sum -= number;
//            item.remove(item.size()-1);
//        }
//    }

    // 131
//    List<List<String>> items;
//    List<String> item;
//    public List<List<String>> partition(String s) {
//        item = new ArrayList<>();
//        items = new ArrayList<>();
//        if (s.length()==0){
//            return items;
//        }
//        backtracking(s, 0);
//        return items;
//    }
//    public void backtracking(String s, int index){
//        if (index >= s.length()){
//            items.add(new ArrayList<>(item));
//            return;
//        }
//        for (int i = index; i < s.length(); i++){
//            if (isPalindrome(s, index, i)){
//                String temp = s.substring(index, i+1);
//                item.add(temp);
//            }else{
//                continue;
//            }
//            backtracking(s, i+1);
//            item.remove(item.size()-1);
//        }
//    }
//    private boolean isPalindrome(String s, int start, int end){
//        for (int i=start,j=end; i <j; i++,j--){
//            if (s.charAt(i) != s.charAt(j)){
//                return false;
//            }
//        }
//        return true;
//    }

    public List<String> restoreIpAddresses(String s) {
        return null;
    }
    public boolean flag = true;
    public void show(){
        System.out.println("Starting");
        while (flag){

        }
        System.out.println("ending");
    }
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        synchronized (solution){
            System.out.println("hello");
        }
        new Thread(solution::show, "t1").start();
        Thread.sleep(1000);
        solution.flag = false;
    }
}

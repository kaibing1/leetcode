package com.kb.backtracking;

import org.junit.Test;


import java.nio.file.Path;
import java.time.OffsetDateTime;
import java.util.*;

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

//    public List<String> restoreIpAddresses(String s) {
//        return null;
//    }
//    public boolean flag = true;
//    public void show(){
//        System.out.println("Starting");
//        while (flag){
//
//        }
//        System.out.println("ending");
//    }
//    public static void main(String[] args) throws InterruptedException {
//        Solution solution = new Solution();
//        synchronized (solution){
//            System.out.println("hello");
//        }
//        new Thread(solution::show, "t1").start();
//        Thread.sleep(1000);
//        solution.flag = false;
//    }
    // 491
//    List<List<Integer>> results;
//    List<Integer> path;
//
//    public List<List<Integer>> findSubsequences(int[] nums) {
//        results = new ArrayList<>();
//        path = new ArrayList<>();
//        backTracking(nums, 0);
//        return results;
//    }
//
//    public void backTracking(int[] nums, int startIndex){
//        if (path.size() > 1){
//            results.add(new ArrayList<>(path));
//        }
//
//        HashSet<Integer> records = new HashSet<>();
//        for (int i = startIndex; i < nums.length; i++) {
//            if ((path.size() != 0 && path.get(path.size()-1) > nums[i]) || records.contains(nums[i])){
//                continue;
//            }
//            records.add(nums[i]);
//            path.add(nums[i]);
//            backTracking(nums, i+1);
//            path.remove(path.size()-1);
//        }
//    }
    // 46
//    List<List<Integer>> results;
//    List<Integer> path;
//    public List<List<Integer>> permute(int[] nums) {
//        results = new ArrayList<>();
//        path = new ArrayList<>();
//        backTracking(nums);
//        return results;
//    }
//    public void backTracking(int[] nums){
//        if (path.size() == nums.length){
//            results.add(new ArrayList<>(path));
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (path.contains(nums[i])){
//                continue;
//            }
//            path.add(nums[i]);
//            backTracking(nums);
//            path.remove(path.size()-1);
//        }
//    }
    // 47
//    List<List<Integer>> results;
//    List<Integer> path;
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        results = new ArrayList<>();
//        path = new ArrayList<>();
//        Arrays.sort(nums);
//        boolean[] flag = new boolean[nums.length];
//        backTracking(nums, flag);
//        return results;
//    }
//    public void backTracking(int[] nums, boolean[] flag){
//        if (path.size() == nums.length){
//            results.add(new ArrayList<>(path));
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (i > 0 && nums[i-1] == nums[i] && !flag[i - 1]){
//                continue;
//            }
//            path.add(nums[i]);
//            flag[i] = true;
//            backTracking(nums, flag);
//            path.remove(path.size()-1);
//            flag[i] = false;
//        }
//    }
//    @Test
//    public void  algo47(){
//        int[] nums = {1, 1, 3};
//        Solution solution = new Solution();
//        solution.permuteUnique(nums);
//    }
    //51
    List<List<String>> result;
    public void algo51(){
        String s = "abc";

    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        backTracking(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }
    private void backTracking(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2){
        if(row==n){
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        }else{
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)){
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)){
                    continue;
                }

                int diagonal2 = row+i;
                if (diagonals2.contains(diagonal2)){
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backTracking(solutions, queens, n, row+1, columns, diagonals1, diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }
    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

}

package com.kb.d20;

import org.junit.Test;

import java.text.BreakIterator;
import java.util.*;

public class Solution {
    @Test
    public void rsTest(){
        String s = "abcd";

        int k = 2;
        System.out.println(new Solution().reverseStr(s, k));
    }
    public String reverseStr(String s, int k) {
        int len = s.length();
        int i = 0;
        Stack<Character> stack = new Stack<>();
        StringBuffer stringBuffer = new StringBuffer();
        while (i < len){
            int rl = len - i;
            if (rl >= 2*k){
                for (int j = 0; j < k; j++) {
                    stack.push(s.charAt(i++));
                }
                while (!stack.isEmpty()){
                    stringBuffer.append(stack.pop());
                }
                for (int j = 0; j < k; j++) {
                    stringBuffer.append(s.charAt(i++));
                }
            }else if (rl >= k){
                for (int j = 0; j < k; j++) {
                    stack.push(s.charAt(i++));
                }
                while (!stack.isEmpty()){
                    stringBuffer.append(stack.pop());
                }
                for (int j = 0; j < rl-k; j++) {
                    stringBuffer.append(s.charAt(i++));
                }
            }else {
                for (int j = 0; j < rl; j++) {
                    stack.push(s.charAt(i++));
                }
                while (!stack.isEmpty()){
                    stringBuffer.append(stack.pop());
                }
            }
        }
        return stringBuffer.toString();
    }
    @Test
    public void llTest(){
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("tog");
        wordList.add("cog");
        System.out.println(new Solution().ladderLength(beginWord, endWord, wordList));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        int len = wordList.size();
        for (int i = 0; i < len; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j)continue;
                if (isLink(wordList.get(i), wordList.get(j))){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        List<Integer> startIndex = new ArrayList<>();
        int left = 1;
        for (int i = 0; i < len; i++) {
//            if (beginWord.equals(wordList.get(i))){
//                left = 0;
//            }
            if (isLink(beginWord, wordList.get(i))){
                startIndex.add(i);
            }
        }
        if (startIndex.size() == 0){
            return 0;
        }

        int right = -1;
        for (int i = 0; i < len; i++) {
            if (endWord.equals(wordList.get(i))){
                right = i;
            }
        }
        if (right == -1){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < startIndex.size(); i++) {
            int tmp = traverse(startIndex.get(i), right, graph);
            if (tmp != -1){
                ans = Math.min(ans, tmp);
            }
        }
        return ans==Integer.MAX_VALUE? 0:ans + left;
    }
    public int traverse(int s, int e, HashMap<Integer, HashSet<Integer>> graph){
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        int depth = 0;
        boolean[] visited = new boolean[graph.size()];
        visited[s] = true;
        while (!q.isEmpty()){
            int size = q.size();
            depth++;
            for (int i = 0; i < size; i++) {
                int f = q.poll();
                if (f == e){
                    return depth;
                }
                HashSet<Integer> adj = graph.get(f);

                for (Integer integer : adj) {
                    if (visited[integer]){
                        continue;
                    }
                    q.offer(integer);
                    visited[integer] = true;
                }
            }
        }
        return -1;
    }
    public boolean isLink(String s1, String s2){
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                cnt++;
                if (cnt > 1){
                    return false;
                }
            }
        }
        return true;
    }
    @Test
    public void nilTest(){
        char[][] chars = new char[][]{{'1', '1', '1', '1', '0'},{'1', '1', '1', '1', '0'}};
        System.out.println(new Solution().numIslands(chars));
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j])continue;
                if (grid[i][j] == '1'){
                    ans++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] grid, int x, int y, boolean[][] visited){
        if (x <0 || y <0 || x >=grid.length||y>=grid[0].length)return;
        if (visited[x][y])return;
        if (grid[x][y] == '1'){
            visited[x][y] = true;
        }else {
            return;
        }
        int[][] ori = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] ints : ori) {
            int tx = x + ints[0];
            int ty = y + ints[1];
            dfs(grid, tx, ty, visited);
        }
    }


}

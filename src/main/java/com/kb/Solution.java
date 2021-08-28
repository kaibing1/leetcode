package com.kb;

import org.junit.Test;

import java.util.*;

public class Solution {
//    HashMap<Integer, Integer> weight;
//    HashMap<Integer, List<Integer>> adj;
//    private int path;
//    private int ans = Integer.MAX_VALUE;
//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        weight = new HashMap<>();
//        adj = new HashMap<>();
//        for (int i = 0; i < flights.length; i++) {
//            int f = flights[i][0];
//            int t = flights[i][1];
//            int val = flights[i][2];
//            int map = f*1000+t;
//            weight.put(map, val);
//            List<Integer> list = adj.getOrDefault(f, new ArrayList<>());
//            list.add(t);
//            adj.put(f, list);
//        }
//        dfs(src, dst, k+1);
//        return ans==Integer.MAX_VALUE?-1:ans;
//    }
//    private void dfs(int src, int dst, int k){
//        if (k < 0){
//            return;
//        }
//
//        if (src == dst){
//            ans = Math.min(ans, path);
//            return;
//        }
//        List<Integer> list = adj.getOrDefault(src, new ArrayList<>());
//        for (int i = 0; i < list.size(); i++) {
//            Integer t = list.get(i);
//
//            int map = src*1000+t;
//            path += weight.get(map);
//            if (path > ans){
//                path -= weight.get(map);
//                continue;
//            }
//            dfs(t, dst, k-1);
//            path -= weight.get(map);
//        }
//    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]>[] edge = new List[n];
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            edge[i] = new ArrayList<>();
            prices[i] = Integer.MAX_VALUE;
        }
        for (int[] flight : flights) {
            edge[flight[0]].add(new int[]{flight[1], flight[2]});
        }
        prices[src] = 0;
        queue.add(new int[]{src, 0, prices[src]});
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            if (poll[1] > k) break;
            for(int[] next : edge[poll[0]]){
                if (prices[next[0]] > poll[2]+next[1]){
                    prices[next[0]] = poll[2]+next[1];
                    queue.add(new int[]{next[0], poll[1]+1, prices[next[0]]});
                }
            }
        }
        return prices[dst] == Integer.MAX_VALUE?-1:prices[dst];
    }
    @Test
    public void fcpTest(){
        int[][] edges = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int n = 3;
        int src = 0;
        int dst = 2;
        int k = 1;
        Solution solution = new Solution();
        System.out.println(solution.findCheapestPrice(n,edges,src, dst, k));
    }

//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        final int INF = 10000*101+1;
//        int[][] f = new int[k+2][n];
//        for (int i = 0; i < k+2; i++) {
//            Arrays.fill(f[i], INF);
//        }
//        f[0][src] = 0;
//        for(int t = 1; t <= k+1; t++){
//            for (int[] flight : flights) {
//                int j = flight[0], i = flight[1], cost = flight[2];
//                f[t][i] = Math.min(f[t][i], f[t-1][j]+cost);
//            }
//        }
//        int ans = INF;
//        for(int t=1;t<=k+1;t++){
//            ans = Math.min(ans, f[t][dst]);
//        }
//        return ans == INF?-1:ans;
//    }

    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        StringBuffer buffer = new StringBuffer();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            set.add(c);
            if (map.containsKey(c)){
                Integer cnt = map.get(c);
                for (int j = 0; j < cnt; j++) {
                    buffer.append(c);
                }
            }
        }
        for (Character character : map.keySet()) {
            if (!set.contains(character)){
                Integer integer = map.get(character);
                for (int i = 0; i < integer; i++) {
                    buffer.append(character);
                }
            }
        }
        return buffer.toString();
    }
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int left = 0, res = 0, maxCnt = 0;
        char[] data = s.toCharArray();
        for (int i = 0; i < data.length; i++) {
            char c = data[i];
            counts[c-'A']++;
            maxCnt = Math.max(maxCnt, counts[c-'A']);
            while (i-left+1-maxCnt>k){
                counts[data[left]-'A']--;
                left++;
            }
            res = Math.max(res, i-left+1);
        }
        return res;
    }
    List<List<Integer>> ans;
    List<Integer> path;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        int start = 0;
        int target = graph.length-1;
        path.add(0);
        dfs(graph, target);
        return ans;
    }
    public void dfs(int[][] graph, int target){
        if (path.get(path.size()-1) == target){
            ans.add(new ArrayList<>(path));
            return;
        }
        int s = path.get(path.size()-1);
        for (int i : graph[s]) {
            path.add(i);
            dfs(graph, target);
            path.remove(path.size()-1);
        }
    }
    @Test
    public void nsTest(){
        int[] nums = {3, 5, 6, 7};
        int target = 9;
        System.out.println(new Solution().numSubseq(nums, target));
    }
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int MOD = 1000000007;
        int len = nums.length;
        int[] cnts = new int[len];
        cnts[0] = 1;
        for (int i = 1; i < len; i++) {
            cnts[i] = (cnts[i-1]<<1)%MOD;
        }
        int l = 0, r = len-1;
        int res = 0;
        while (l <= r){
            int sum = nums[l]+nums[r];
            if (sum > target){
                r--;
            }else {
                res = (res + cnts[r-l])%MOD;
                l++;
            }
        }
        return res;
    }
}

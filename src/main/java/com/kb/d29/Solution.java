package com.kb.d29;


import com.kb.algorithm.utils.ListNode;
import com.kb.algorithm.utils.TreeNode;
import org.junit.Test;

import java.util.*;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (n > 0){
            fast = fast.next;
            n--;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
//    List<List<Integer>> res;
//    List<Integer> path;
//    public List<List<Integer>> pathSum(TreeNode root, int target) {
//        res =  new ArrayList<>();
//        path = new ArrayList<>();
//        dfs(root, target);
//        return res;
//    }
//    public void dfs(TreeNode root, int target){
//        if (root == null){
//            return;
//        }
//        int val = root.val;
//        target -= val;
//        path.add(val);
//        if (root.left == null && root.right==null && target==0){
//            res.add(new ArrayList<>(path));
//        }else{
//            dfs(root.left, target);
//            dfs(root.right, target);
//        }
//        path.remove(path.size()-1);
//    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p==null || q==null || root==null) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left!=null && right!=null) return root;
        if (left==null&&right!=null)return right;
        else if (left!=null && right==null)return left;
        else return null;
    }
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
//        int ans = Integer.MIN_VALUE;
//        for (int i = 0; i < arr1.length; i++) {
//            for (int j = 0; j < arr1.length; j++) {
//                int tmp = Math.abs(arr1[i]-arr1[j])+Math.abs(arr2[i]-arr2[j])+Math.abs(i-j);
//                if (tmp > ans){
//                    ans = tmp;
//                }
//            }
//        }
//        return ans;
        int amin = Integer.MAX_VALUE, bmin = Integer.MAX_VALUE, cmin = Integer.MAX_VALUE, dmin = Integer.MAX_VALUE;
        int amax = Integer.MIN_VALUE, bmax = Integer.MIN_VALUE, cmax = Integer.MIN_VALUE, dmax = Integer.MIN_VALUE;

        for(int i = 0; i < arr1.length; i++) {
            amin = Math.min(amin, arr1[i]+arr2[i]+i);
            amax = Math.max(amax, arr1[i]+arr2[i]+i);

            bmin = Math.min(bmin, arr1[i]+arr2[i]-i);
            bmax = Math.max(bmax, arr1[i]+arr2[i]-i);

            cmin = Math.min(cmin, arr1[i]-arr2[i]+i);
            cmax = Math.max(cmax, arr1[i]-arr2[i]+i);

            dmin = Math.min(dmin, arr1[i]-arr2[i]-i);
            dmax = Math.max(dmax, arr1[i]-arr2[i]-i);
        }

        return Math.max(Math.max(amax-amin, bmax-bmin), Math.max(cmax-cmin, dmax-dmin));
    }
    @Test
    public void sosTest(){
        Solution solution = new Solution();
        int[] arr = {1,4,2,5,3};
        System.out.println(solution.sumOddLengthSubarrays2(arr));
    }
    public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0;
        int len = arr.length;
        for (int i = 0; i < arr.length; i++) {
            ans += arr[i];
        }
        int step = 3;
        while (step <= len){
            for (int i = 0; i <= len-step; i++) {
                int tmp = 0;
                for (int j = i; j < i+step; j++) {
                    tmp += arr[j];
                }
                ans+=tmp;
            }
            step+= 2;
        }
        return ans;
    }
    public int sumOddLengthSubarrays2(int[] arr) {
        int len = arr.length;
        int[] prefixSums = new int[len+1];
        for (int i = 0; i < len; i++) {
            prefixSums[i+1] = prefixSums[i]+arr[i];
        }
        int sum = 0;
        for (int start = 0; start < len; start++) {
            for (int length = 1; length+start <=len ; length+=2) {
                int end = start+length-1;
                sum += prefixSums[end+1] - prefixSums[start];
            }
        }
        return sum;
    }
    @Test
    public void mvTest(){
        String s = "weallloveyou";
        int k = 7;
        Solution solution = new Solution();
        System.out.println(solution.maxVowels2(s, k));
    }
    public int maxVowels(String s, int k) {
        int ans = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] prefix = new int[len + 1];
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('i');
        set.add('o');
        set.add('e');
        set.add('u');
        for (int i = 0; i < len; i++) {
            if (set.contains(chars[i])){
                prefix[i+1] = prefix[i]+1;
            }else {
                prefix[i+1] = prefix[i];
            }
        }

        for (int i = 0; i+k <= len; i++) {
            int end = i + k;
            ans = Math.max(prefix[end]-prefix[i], ans);
        }
        return ans;
    }
    public int maxVowels2(String s, int k) {
        int ans = 0;
        int cnt = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('i');
        set.add('o');
        set.add('e');
        set.add('u');
        while (right < s.length()){
            char tmp = s.charAt(right);
            if (set.contains(tmp)){
                cnt++;
            }
            right++;
            if (right - left == k){
                ans = Math.max(ans, cnt);
                char c = s.charAt(left);
                if (set.contains(c)){
                    cnt--;
                }
                left++;
            }
        }
        return ans;
    }
    @Test
    public void crTest(){
        int[] chalk = {3, 4, 1, 2};
        int k = 25;
        Solution solution = new Solution();
        System.out.println(solution.chalkReplacer(chalk, k));
    }
    public int chalkReplacer(int[] chalk, int k) {
        int len = chalk.length;
        long[] dp = new long[len];
        dp[0] = chalk[0];
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i-1]+chalk[i];
        }
        k %= dp[len-1];
        int i = 0;
        while (dp[i] < k){
            i++;
        }
        return i;
    }
    //753
//    @Test
//    public void csTest(){
//        Solution solution = new Solution();
//        System.out.println(solution.crackSafe(2, 2));
//    }
//    Set<Integer> seen = new HashSet<>();
//    StringBuffer ans = new StringBuffer();
//    int highest;
//    int k;
//    public String crackSafe(int n, int k) {
//        highest = (int) Math.pow(10, n-1);
//        this.k = k;
//        dfs(0);
//        for (int i = 1; i < n; i++) {
//            ans.append('0');
//        }
//        return ans.toString();
//    }
//    public void dfs(int node){
//        for (int i = 0; i < k; i++) {
//            int nei = node * 10 + i;
//            if (!seen.contains(nei)){
//                seen.add(nei);
//                dfs(nei % highest);
//                ans.append(i);
//            }
//        }
//    }
//    private Map<String, PriorityQueue<String>> map = new HashMap<>();
//    private List<String> resList = new LinkedList<>();
//    public List<String> findItinerary(List<List<String>> tickets) {
//        for (List<String> ticket : tickets) {
//            String src = ticket.get(0);
//            String dst = ticket.get(1);
//            if (!map.containsKey(src)){
//                PriorityQueue<String> pq = new PriorityQueue<>();
//                map.put(src, pq);
//            }
//            map.get(src).add(dst);
//        }
//        dfs("JFK");
//        return resList;
//    }
//    private void dfs(String src){
//        PriorityQueue<String> pq = map.get(src);
//        while (pq!=null && !pq.isEmpty()){
//            dfs(pq.poll());
//        }
//        ((LinkedList<String>)resList).addFirst(src);
//    }
    List<String> res = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets){
        Map<String, TreeMap<String, Integer>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            map.putIfAbsent(from, new TreeMap<>());
            TreeMap<String, Integer> treeMap = map.get(from);
            treeMap.put(to, treeMap.getOrDefault(to, 0)+1);
        }
        res.add("JFK");
        backtrack(tickets, map, 0);
        return res;
    }
    private boolean backtrack(List<List<String>> tickets, Map<String, TreeMap<String, Integer>> map, int progress){
        if (progress == tickets.size()){
            return true;
        }
        TreeMap<String, Integer> tos = map.get(res.get(res.size() - 1));
        if (tos==null || tos.isEmpty() ){
            return false;
        }
        for (String str : tos.keySet()) {
            if (tos.get(str)==0){
                continue;
            }
            res.add(str);
            tos.put(str,  tos.get(str)-1);
            if (backtrack(tickets, map, progress+1))
                return true;
            res.remove(res.size()-1);
            tos.put(str, tos.get(str)+1);
        }
        return false;
    }

    public boolean sequenceReconstruction(int[] org, List<List<Integer>>seqs){
        int cnt = org.length;
        int[] node2inCnt = new int[cnt + 1];
        boolean[] exist = new boolean[cnt+1];
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < cnt+1 ; i++) {
            graph.add(new HashSet<>());
        }
        for (List<Integer> seq : seqs) {
            int lastNode = seq.get(0);
            for (int i = 0; i < seq.size(); i++) {
                int curNode = seq.get(i);
                if (curNode<=0 || curNode > cnt) return false;
                exist[curNode] = true;
                if (i > 0 && graph.get(lastNode).add(curNode)){
                    node2inCnt[curNode]++;
                }
                lastNode = curNode;
            }
        }
        Queue<Integer> bfs = new LinkedList<>();
        for (int i = 1; i < cnt+1; i++) {
            if (!exist[i]) return false;
            if (node2inCnt[i] == 0) bfs.offer(i);
        }
        int sameCnt = 0;
        while (!bfs.isEmpty()){
            int size = bfs.size();
            if (size > 1) return false;
            while (size-- > 0){
                int curNode = bfs.poll();
                if (curNode != org[sameCnt++]) return false;
                for (Integer nxNode : graph.get(curNode)) {
                    node2inCnt[nxNode]--;
                    if (node2inCnt[nxNode] == 0){
                        bfs.offer(nxNode);
                    }
                }
            }
        }
        return sameCnt == cnt;
    }
    @Test
    public void randomTest(){
        Random random = new Random();
        double[] pect = {0.1, 0.4, 0.8, 1.0};
        int i = 0;
        double val = 0.7;
        while (pect[i] <= val){
            i++;
        }
        System.out.println(i);
    }
}

package com.kb.d30;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Solution {
    List<String> res;
    StringBuilder path;
    public String[] permutation(String s) {
        res = new ArrayList<>();
        path = new StringBuilder();
        char[] chars = s.toCharArray();
        boolean[] visited = new boolean[chars.length];
        traversal(chars, visited);
        return res.toArray(new String[0]);
    }
    private void traversal(char[] chars, boolean[] visited){
        if (path.length()==chars.length){
            res.add(path.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) continue;
            path.append(chars[i]);
            visited[i] = true;
            traversal(chars, visited);
            path.deleteCharAt(path.length()-1);
            visited[i]=false;
        }
    }
    @Test
    public void test(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(50, 30, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        });

    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int[][] ints = new int[map.size()][2];
        int i = 0;
        for (Integer integer : map.keySet()) {
            ints[i][0] = integer;
            ints[i][1] = map.get(integer);
            i++;
        }
        Arrays.sort(ints, (a, b)->{
            return b[1] - a[1];
        });
        int[] ans = new int[k];
        for (i = 0; i < k; i++) {
            ans[i] = ints[i][0];
        }
        return ans;
    }
    int cnt = 0;
    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, new boolean[nums.length], 0, -1);
        return cnt;
    }
    private void backtrack(int[] nums, boolean[] visited, int index, int preNum){
        if (index == nums.length){
            cnt++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]){
                continue;
            }
            if (preNum > 0  && !isSquare(preNum+nums[i])){
                continue;
            }
            if (i > 0 && nums[i]==nums[i-1] && !visited[i-1]){
                continue;
            }
            visited[i] = true;
            backtrack(nums, visited, index+1, nums[i]);
            visited[i] = false;
        }
    }
    private boolean isSquare(int value){
        int n = (int) Math.sqrt(value);
        return n * n == value;
    }
    @Test
    public void qsTest(){
        Solution s = new Solution();
        int[] nums = {9, 3, 6, 1, 2, 5};
        s.quickSort(nums, 0, nums.length-1);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public void quickSort(int[] nums, int left, int right){
        int l = left, r = right;
        if (l < r){
            int base = nums[l];
            while (l < r){
                while (l < r && nums[r] >= base) r--;
                if (l < r) nums[l] = nums[r];
                while (l < r && nums[l] < base) l++;
                if (l < r) nums[r] = nums[l];
            }
            nums[l] = base;
            quickSort(nums, left, l);
            quickSort(nums, l+1, right);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cnt = m + n - 1;
        int l = m-1;
        int r = n-1;
        while (l >= 0 && r >= 0){
            if (nums1[l]>=nums2[r]){
                nums1[cnt--] = nums1[l--];
            }else {
                nums1[cnt--] = nums2[r--];
            }
        }
        while (l >= 0){
            nums1[cnt--] = nums1[l--];
        }
        while (r>=0){
            nums1[cnt--] = nums2[r--];
        }
    }
    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        int res = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index]+1);
            res = Math.max(res, i - start+1);
            last[index] = i;
        }
        return res;
    }
    @Test
    public void hdTest(){
        Solution solution = new Solution();
        System.out.println(solution.hammingDistance(1, 3));
    }
    public int hammingDistance(int x, int y) {
        int ans = 0;
        while (x > 0 && y > 0){
            int xL = x & 1;
            int yL = y & 1;
            if ((xL ^ yL) ==1){
                ans++;
            }
            x >>= 1;
            y >>= 1;
        }
        while (x > 0){
            if ((x & 1) == 1){
                ans++;
            }
            x >>= 1;
        }
        while (y > 0){
            if ((y & 1) == 1){
                ans++;
            }
            y >>= 1;
        }
        return ans;
    }
    public int hammingDistance2(int x, int y) {
        int z = x ^ y;
        int ans = 0;
        while (z > 0){
            ans += z & 1;
            z >>= 1;
        }
        return ans;
    }
    @Test
    public void itTest(){
        int i = 0;
        LinkedList<Integer> list = new LinkedList<>();

        Solution solution = new Solution();
        System.out.println(solution.isInterleave2("ab", "a", "aba"));
    }

    public boolean flag = false;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return flag;
        }
        dfs(s1, 0, s2, 0, s3, 0);
        return flag;
    }
    public void dfs(String s1, int i1, String s2, int i2, String s3, int i3){
        if (flag)return;
        if (s1.length() == i1 && s2.length() == i2 && s3.length() == i3){
            flag = true;
            return;
        }
        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)){
            dfs(s1, i1+1, s2, i2, s3, i3+1);
        }
        if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)){
            dfs(s1, i1, s2, i2+1, s3, i3+1);
        }
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()){
            return false;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i < m+1; i++) {
            if (s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][0]){
                dp[i][0] = true;
            }
        }
        for (int i = 1; i < n+1; i++) {
            if (s2.charAt(i-1) == s3.charAt(i-1) && dp[0][i-1]){
                dp[0][i] = true;
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n+1; j++) {
                if ((s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j]) || (s2.charAt(j-1) == s3.charAt(i+j-1) &&dp[i][j-1])){
                    dp[i][j] = true;
                }
            }
        }
        return dp[m][n];
    }
    @Test
    public void cvTest(){
        Solution solution = new Solution();
        String s1 = "1.0.1";
        String s2 = "1";
        System.out.println(solution.compareVersion(s1, s2));
    }
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int cnt = Math.max(s1.length, s2.length);
        int weight = (int) Math.pow(10, cnt-1);
        int a1 = 0;
        int a2 = 0;
        for (int i = 0; i < cnt; i++) {
            int v1 = 0;
            if (i < s1.length){
                v1 = Integer.parseInt(s1[i]) * weight;
            }
            int v2 = 0;
            if (i < s2.length){
                v2 = Integer.parseInt(s2[i])*weight;
            }
            a1 += v1;
            a2 += v2;
            weight /= 10;
        }
        return Integer.compare(a1, a2);
    }
    public int maximum(int a, int b) {
        return  (int)(((long)a + (long)b + Math.abs((long)a-(long)b))/2.0);
    }

    public int[] beautifulArray(int n) {
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        part(ans, 0, n-1);
        return ans;
    }
    private void part(int[] ans, int s, int e){
        if (e <= s) return;;
        int mid = s + (e-s)/2;
        part(ans, s, mid);
        part(ans, mid+1, e);
        for (int i = s; i <=mid ; i++) {
            ans[i] = 2*ans[i]-1;
        }
        for (int i = mid+1; i <= e; i++) {
            ans[i] = 2*ans[i];
        }
    }

}

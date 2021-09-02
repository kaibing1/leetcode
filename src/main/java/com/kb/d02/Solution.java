package com.kb.d02;

import com.kb.algorithm.utils.ListNode;
import org.junit.Test;

import java.security.Provider;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution {
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for(int n : nums){
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0){
            div <<= 1;
        }
        int a = 0, b = 0;
        for(int n : nums){
            if ((div & n) != 0){
                a ^= n;
            }else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
    @Test
    public void singleTest(){
        int a = 5;
        int b = 6;
        System.out.println(a ^ a);
    }

    public int singleNumber(int[] nums){
        int[] counts = new int[32];
        for(int num:nums){
            for (int i = 0; i < 32; i++) {
                counts[i] += num&1;
                num >>>=1;
            }
        }
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            res <<=1;
            res |= counts[31-i] % m;
        }
        return res;
    }
    public long numberOfWeeks(int[] milestones) {
        Arrays.sort(milestones);
        int max = milestones[milestones.length-1];
        long total = 0L;
        for (int i = 0; i < milestones.length; i++) {
            total += milestones[i];
        }
        long rest = total - max;
        if (max > rest+1){
            return rest*2 + 1;
        }else {
            return max + rest;
        }

    }
    @Test
    public void numberTest(){
        Solution s = new Solution();
        int[] nums = {5, 2, 1};
        System.out.println(s.numberOfWeeks(nums));

    }

    public long minimumPerimeter(long neededApples) {
        long number = 0L;
        long r = 0L;
        while (number < neededApples){
            r += 1;
            number += 4*(r + 2*r);
        }
        return  2*r;
    }

    public int getLucky(String s, int k) {
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            int number = chars[i] - 'a' + 1;
            res += getSum(number);
        }
        for (int i = 1; i < k; i++) {
            res = getSum(res);
            if (res < 10){
                break;
            }
        }
        return res;
    }
    public int getSum(int i){
        int total = 0;
        while (i > 0){
            total += i % 10;
            i /= 10;
        }
        return total;
    }

    @Test
    public void testGetLucky(){
        String s = "leetcode";
        int k = 2;
        Solution solution = new Solution();
        System.out.println(solution.getLucky(s, k));
    }
//
//    public String maximumNumber(String num, int[] change) {
//        char[] chars = num.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            int index = chars[i];
//            if (change[index] > index){
//
//            }
//        }
//    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fastNode = head;
        int index = k;
        while (--index > 0){
            fastNode = fastNode.next;
        }
        ListNode cur = head;
        while (fastNode != null){
            fastNode = fastNode.next;
            cur = cur.next;
        }
        return cur;
    }
    @Test
    public void crsTest(){
        Solution solution = new Solution();
        int[] nums = {0};
        int lower = 0;
        int upper = 0;
        System.out.println(solution.countRangeSum(nums, lower, upper));
    }
    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        long[] preSum = new long[len];
        preSum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSum[i] = preSum[i-1] + nums[i];
        }
        long pre = 0;
        long cur = 0;
        int ans = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j+i <= len; j++) {
                if (j == 0){
                    pre = 0;
                }else {
                    pre = preSum[j-1];
                }
                cur = preSum[j+i-1];
                long val = cur - pre;
                if (val <= upper && val >= lower){
                    ans++;
                }
            }
        }
        return ans;
    }
    public int calPoints(String[] ops) {
        LinkedList<Integer> list = new LinkedList<>();
        for (String op : ops) {
            if ("C".equals(op)){
                list.removeLast();
            }else if ("D".equals(op)){
                int val = list.getLast();
                list.removeLast();
                list.addLast(val*2);
            }else if ("+".equals(op)){
                int v1 = list.get(list.size()-1);
                int v2 = list.get(list.size()-2);
                list.addLast(v1+v2);
            }else {
                list.addLast(Integer.valueOf(op));
            }
        }
        int ans = 0;
        for (Integer integer : list) {
            ans += integer;
        }
        return ans;
    }
    class ServerState{
        int idx;
        int weight;
        int ending;
        public ServerState(int i, int w, int e){
            idx = i;
            weight = w;
            ending = e;
        }
    }
    public int[] assignTasks(int[] servers, int[] tasks){
        int n = servers.length, m = tasks.length;
        int[] ans = new int[m];
        PriorityQueue<ServerState> ready = new PriorityQueue<>((a,b)-> (a.weight==b.weight)? a.idx-b.idx:a.weight-b.weight);
        for (int i = 0; i < n; i++) {
            ready.offer(new ServerState(i, servers[i], 0));
        }
        PriorityQueue<ServerState> busy = new PriorityQueue<>((a, b)-> (a.ending == b.ending)? ((a.weight==b.weight)?a.idx-b.idx:a.weight-b.weight):a.ending-b.weight);
        for (int i = 0; i < m; i++) {
            while (!busy.isEmpty() && busy.peek().ending <= i){
                ready.offer(busy.poll());
            }
            if (ready.isEmpty()){
                ServerState top = busy.poll();
                top.ending += tasks[i];
                ans[i]=top.idx;
                busy.offer(top);
            }else {
                ServerState serv = ready.poll();
                serv.ending = i + tasks[i];
                ans[i] = serv.idx;
                busy.offer(serv);
            }
        }
        return ans;
    }
}

package com.kb.d16;

import com.kb.common.ListNode;
import org.junit.Test;

import java.util.*;

public class Solution {
    public int search(int[] nums, int target) {
        int count = 0;
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            int mid = (end-start)/2 + start;
            if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        if(nums[start] != target){
            return count;
        }else{
            for(int i = start; i < nums.length; i++){
                if(nums[i] == target){
                    count++;
                }
            }
            return count;
        }

    }
    @Test
    public void test(){
        String s = "a";
        String t = "a";
        Solution solution = new Solution();

        System.out.println(solution.minWindow(s, t));
    }
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen < tLen){
            return "";
        }
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) +1);
        }
        int r = 0;
        int l = 0;
        int maxLen = Integer.MAX_VALUE;
        int start = 0;
        int cnt = 0;
        HashMap<Character, Integer> sMap = new HashMap<>();
        while (r < sLen){
            char c = s.charAt(r);
            if (tMap.containsKey(c)){
                int sCnt = sMap.getOrDefault(c, 0);
                if (sCnt < tMap.get(c)){
                    cnt++;
                }
                sMap.put(c,sCnt+1);
            }
            r++;
            while (cnt >= tLen){
                if (r - l < maxLen){
                    maxLen = r - l;
                    start = l;
                }
                char lc = s.charAt(l);
                if (tMap.containsKey(lc)){
                    int lCnt = sMap.getOrDefault(lc, 0);
                    if (lCnt <= tMap.get(lc)){
                        cnt--;
                    }
                    sMap.put(lc, lCnt-1);
                }
                l++;
            }
        }
        return maxLen == Integer.MAX_VALUE?"":s.substring(start, maxLen+start);
    }
    Map<String, Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s)){
            return true;
        }
        if (map.containsKey(s)){
            return map.get(s);
        }
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            if (wordDict.contains(left) && wordBreak(s.substring(i), wordDict)){
                map.put(left, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
    @Test
    public void wordBreakTest(){
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        Solution solution = new Solution();
        System.out.println(solution.wordBreak(s, wordDict));
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        HashSet<String> set = new HashSet<>(wordDict);
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (set.contains(s.substring(j,i)) && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i]!=null){
                queue.add(lists[i]);
            }
        }
        ListNode cur = dummy;
        while (!queue.isEmpty()){
            ListNode node = queue.poll();
            if (node.next!=null){
                queue.add(node.next);
            }
            cur.next = node;
            cur = node;
        }
        return dummy.next;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            int left = i+1, right = nums.length-1;
            while (left < right){
                if (nums[left] + nums[right] == target){
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while (left<right && nums[left] == nums[left-1]) left++;
                    while (left< right && nums[right] == nums[right+1]) right--;
                }else if (nums[left] + nums[right] < target){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return ans;
    }

}

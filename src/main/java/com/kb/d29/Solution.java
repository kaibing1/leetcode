package com.kb.d29;


import com.kb.algorithm.utils.ListNode;
import com.kb.algorithm.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res =  new ArrayList<>();
        path = new ArrayList<>();
        dfs(root, target);
        return res;
    }
    public void dfs(TreeNode root, int target){
        if (root == null){
            return;
        }
        int val = root.val;
        target -= val;
        path.add(val);
        if (root.left == null && root.right==null && target==0){
            res.add(new ArrayList<>(path));
        }else{
            dfs(root.left, target);
            dfs(root.right, target);
        }
        path.remove(path.size()-1);
    }

}

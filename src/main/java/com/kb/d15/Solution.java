package com.kb.d15;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    // 82
    public ListNode deleteDuplicates1(ListNode head) {
        int count = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        boolean[] flag = new boolean[count];
        cur = head;
        int index = 0;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                flag[index] = true;
                flag[index + 1] = true;
            }
            cur = cur.next;
            index++;
        }
        cur = dummy;
        index = 0;
        while (cur != null && cur.next != null) {
            if (flag[index]) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;

            }
            index++;
        }
        return dummy.next;
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next!=null && cur.next.next!=null){
            if (cur.next.val == cur.next.next.val){
                int val = cur.next.val;
                while (cur.next!=null && cur.next.val == val){
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}

package com.kb.tree;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val= val;
        this.left = left;
        this.right = right;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
//class Node {
//    public int val;
//    public Node left;
//    public Node right;
//    public Node next;
//
//    public Node() {}
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, Node _left, Node _right, Node _next) {
//        val = _val;
//        left = _left;
//        right = _right;
//        next = _next;
//    }
//}
public class Solution {
    // 102
    public List<List<Integer>> levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> lines = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                lines.add(tmp.val);
                if (tmp.left!= null) queue.add(tmp.left);
                if (tmp.right!=null) queue.add(tmp.right);
            }
            res.add(lines);
        }
        return res;
    }
    // 104
    public List<List<Integer>> levelOrderBottom(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> lines = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                assert tmp != null;
                lines.add(tmp.val);
                if (tmp.left!= null) queue.add(tmp.left);
                if (tmp.right!=null) queue.add(tmp.right);
            }
            res.add(0, lines);
        }
//        List<List<Integer>> result = new ArrayList<>();
//        for (int i = res.size()-1; i >= 0 ; i--) {
//            result.add(res.get(i));
//        }
        return res;
    }

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> lines = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                lines.add(tmp.val);
                if (tmp.left!= null) queue.add(tmp.left);
                if (tmp.right!=null) queue.add(tmp.right);
            }
            res.add(lines.get(lines.size()-1));
        }
        return res;
    }
    // 637
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            double number = 0;
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                number += node.val;
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
            }
            res.add(number/count);
        }
        return res;
    }

    // 429
//    public List<List<Integer>> levelOrder(Node root) {
//        Queue<Node> queue = new LinkedList<>();
//        List<List<Integer>> res = new ArrayList<>();
//        if (root == null) return res;
//        queue.offer(root);
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            List<Integer> tmp = new ArrayList<>();
//            for (int i = 0; i < size; i++) {
//                Node node = queue.poll();
//                tmp.add(node.val);
//                if (node.children!=null){
//                    for (Node child:
//                         node.children) {
//                        queue.offer(child);
//                    }
//                }
//            }
//            res.add(tmp);
//        }
//        return res;
//    }
    // 515
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        queue.offer(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            int maxValue = queue.peek().val;
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                maxValue = Math.max(node.val, maxValue);
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
            }
            res.add(maxValue);
        }
        return res;
    }
    // 116
//    public Node connect(Node root) {
//        traversal(root, null);
//        return root;
//    }
//    private void traversal(Node left, Node right){
//        Node ll = null;
//        Node lr = null;
//        if (left!= null){
//            left.next = right;
//            ll = left.left;
//            lr = left.right;
//            traversal(ll, lr);
//        }
//        if (right!= null){
//            if (right.left!= null){
//                traversal(lr, right.left);
//                traversal(right.left, right.right);
//            }else if (right.right!=null){
//                traversal(lr, right.right);
//            }
//        }
//    }
//    public Node connect(Node root) {
//        Queue<Node> queue = new LinkedList<>();
//        if (root == null){
//            return null;
//        }
//        queue.offer(root);
//        while (!queue.isEmpty()){
//            int count = queue.size();
//            Node pre = null;
//            Node cur = null;
//            for (int i = 0; i < count; i++) {
//                if (i==0){
//                    pre = queue.poll();
//                    if (pre.left!= null) queue.add(pre.left);
//                    if (pre.right!=null) queue.add(pre.right);
//                }else {
//                    cur = queue.poll();
//                    pre.next = cur;
//                    pre = cur;
//                    if (cur.left!=null) queue.add(cur.left);
//                    if (cur.right!=null) queue.add(cur.right);
//                }
//            }
//        }
//        return root;
//    }
    // 559

//    public int maxDepth(TreeNode root) {
//        if (root==null) return 0;
//        return getDepth(root);
//    }
//    public int getDepth(TreeNode node){
//        if (node == null) return 0;
//        int left = getDepth(node.left);
//        int right = getDepth(node.right);
//        int res = Math.max(left, right)+1;
//        return res;
//    }
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root==null) return 0;
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left!= null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
            }
        }
        return depth;
    }
    // 222
    public int countNodes(TreeNode root) {
        if (root==null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftHeight = 0, rightHeight=0;
        while (left != null){
            leftHeight++;
            left = left.left;
        }
        while (right!=null){
            rightHeight++;
            right = right.right;
        }
        if (leftHeight == rightHeight)
        {
            return (2 << leftHeight) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}

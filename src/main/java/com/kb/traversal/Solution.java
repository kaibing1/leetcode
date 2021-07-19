package com.kb.traversal;

import com.kb.algorithm.utils.Node;
import com.kb.d21.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root==null) return result;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right!=null) stack.push(node.right);
            if (node.left!= null) stack.push(node.left);
        }
        return result;
    }
    
    // 94
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (stack.size()>0 || root!=null){
            if(root != null){
                stack.add(root);
                root = root.left;
            }else{
                TreeNode tmp = stack.pop();
                result.add(tmp.val);
                root = tmp.right;
            }
        }
        return result;
    }
    @Test
    public void algo94(){
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        r5.left = r4;
        r5.right = r6;
        r4.left = r1;
        r4.right = r2;
        Solution solution = new Solution();
        solution.inorderTraversal(r5);
    }

    public List<Integer> postorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            result.add(tmp.val);
            if (tmp.left!= null) stack.push(tmp.left);
            if (tmp.right!=null) stack.push(tmp.right);
        }
        Collections.reverse(result);
        return result;
    }
}

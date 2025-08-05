/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int depth = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        d(root);
        return depth;
    }

    private int d(TreeNode n) {
        if (n == null) {
            return 0;
        }

        int leftDep = d(n.left);
        int rightDep = d(n.right);
        
        if (leftDep + rightDep> depth) {
            depth = leftDep + rightDep;
        }

        return Math.max(leftDep, rightDep) + 1;
    }
}
// @lc code=end

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
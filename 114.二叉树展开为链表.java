/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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

    TreeNode temp = new TreeNode();
    

    public void flatten(TreeNode root) {
        // 如果脚下的平台是空的，那就没什么好做的啦，直接回家喵~
        if (root == null) {
            return;
        }

        // Neko酱的递归魔法第一步：
        // 先把自己派到左边的杆子和右边的杆子，把它们各自拉直！
        // (先改造左子树，再改造右子树)
        flatten(root.left);
        flatten(root.right);

        // ---- 哼喵！现在进入最关键的“移花接木”环节！ ----
        // 此时，root.left 和 root.right 都已经是拉直的链表了喵！

        // 1. 先把原来右边那根杆子（链表）暂存起来，别弄丢了。
        TreeNode tempRight = root.right;

        // 2. 把拉直后的左边那根杆子，整个接到右边来！
        root.right = root.left;
        
        // 3. 按照题目要求，把左边的连接断开，打扫干净喵~
        root.left = null;

        // 4. 找到现在这个新接上的右杆子的最末端。
        // 我们需要一路小跑（循环）到这根新杆子的尽头。
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }

        // 5. 太棒了！在尽头把我们之前暂存的、原来的右杆子接上去！大功告成！
        p.right = tempRight;
    }

    public TreeNode copy(TreeNode root, TreeNode copy) {
        if (root == null) {
            return null;
        }

        copy = new TreeNode();
        copy.val = root.val;
        copy.left = copy(root.left, copy.left);
        copy.right = copy(root.right, copy.right);

        return copy;
    }
    
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        temp.val = root.val;
        TreeNode node = new TreeNode();
        temp.right = node;
        temp = node;
        preOrder(root.left);
        preOrder(root.right);
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
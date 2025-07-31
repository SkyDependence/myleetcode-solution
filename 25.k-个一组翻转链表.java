/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        boolean flag = true; // 是否是第一次循环
        ListNode res = head; // 结果
        ListNode prev = null; // 前驱
        ListNode cur = head; // 当前
        ListNode idx = head; // 计数指针
        ListNode lastFirst = null; // 上一轮第一个节点
        ListNode first = null; // 这轮第一个节点
        int c = 0;
        while (idx != null) {
            idx = idx.next;
            c++;
            if (c == k) {
                // 反转组内
                lastFirst = first;
                first = cur;
                prev = idx;
                for (int i = 0; i < k; i++) {
                    ListNode next = cur.next;
                    cur.next = prev;
                    prev = cur;
                    cur = next;
                }
                // 是否是第一次循环
                if (flag) {
                    res = prev;
                    flag = false;
                } else {
                    lastFirst.next = prev;
                }
                c = 0;
            }
        }
        return res;
    }
}
// @lc code=end

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
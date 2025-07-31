/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
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
            if (c == 2) {
                // 反转组内
                lastFirst = first;
                first = cur;
                prev = idx;
                for (int i = 0; i < 2; i++) {
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


/*
 * @lc app=leetcode.cn id=2181 lang=java
 *
 * [2181] 合并零之间的节点
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
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
    public ListNode mergeNodes(ListNode head) {
        ListNode list = new ListNode();
        ListNode heaNode = list;
        int sum = 0;
        while (head.next != null) {
            head = head.next;
            if (head.val != 0) {
                sum += head.val;
            } else {
                list.val = sum;
                sum = 0;
                ListNode next = new ListNode();
                if (head.next != null) {
                    list.next = next;
                    list = list.next;
                }
            }
        }
        return heaNode;
    }
}
// @lc code=end


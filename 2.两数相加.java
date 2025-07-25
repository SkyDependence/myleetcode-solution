/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode node = new ListNode();
        ListNode first = node;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            node.val = sum % 10;
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null && l2 == null) {
                break;
            }
            node.next = new ListNode();
            node = node.next;
        }
        while (l1 != null) {
            int sum = carry + l1.val;
            node.val = sum % 10;
            carry = sum / 10;
            l1 = l1.next;
            if (l1 == null) {
                break;
            }
            node.next = new ListNode();
            node = node.next;
        }
        while (l2 != null) {
            int sum = carry + l2.val;
            node.val = sum % 10;
            carry = sum / 10;
            l2 = l2.next;
            if (l2 == null) {
                break;
            }
            node.next = new ListNode();
            node = node.next;
        }

        if (carry > 0) {
            node.next = new ListNode(carry);
        }
        return first;
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
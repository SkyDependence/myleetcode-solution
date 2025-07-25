/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode node = new ListNode();
        ListNode first = node;
        while (list1 != null || list2 != null) {
            if (list1 == null && list2 != null) {
                node.val = list2.val;
                list2 = list2.next;
                if (list2 == null)
                    continue;
                node.next = new ListNode();
                node = node.next;
                continue;
            } else if (list1 != null && list2 == null) {
                node.val = list1.val;
                list1 = list1.next;
                if (list1 == null)
                    continue;
                node.next = new ListNode();
                node = node.next;
                continue;
            }
            if (list1.val > list2.val) {
                node.val = list2.val;
                list2 = list2.next;
            } else {
                node.val = list1.val;
                list1 = list1.next;
            }
            
            node.next = new ListNode();
            node = node.next;
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
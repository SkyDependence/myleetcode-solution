/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并 K 个升序链表
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

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
    public ListNode mergeKLists(ListNode[] lists) {
        /*if (lists == null || lists.length == 0) {
            return null;
        }
        
        if (lists.length == 1) {
            return lists[0];
        }
        
        List<ListNode> arrayList = new ArrayList<>(Arrays.asList(lists));
        
        ListNode head = new ListNode();
        ListNode f = head;
        
        while (arrayList.size() != 0) {
            int min = Integer.MAX_VALUE;
            int idx = 0;
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) == null) {
                    arrayList.remove(i);
                    i--;
                    continue;
                }
                if (arrayList.get(i).val < min) {
                    idx = i;
                    min = arrayList.get(i).val;
                }
            }
            if (arrayList.size() == 0 || arrayList.get(idx) == null) {
                break;
            }
            arrayList.set(idx, arrayList.get(idx).next);
            if (arrayList.get(idx) == null) {
                arrayList.remove(idx);
            }
            f.next = new ListNode(min);
            f = f.next;
        }
        
        return head.next; */
        
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> min = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node != null) {
                min.add(node);
            }
        }

        ListNode head = new ListNode();
        ListNode cur = head;

        while (min.size() != 0) {
            ListNode minNode = min.poll();

            cur.next = minNode;
            cur = cur.next;

            if (minNode.next != null) {
                min.add(minNode.next);
            }
        }

        return head.next;
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
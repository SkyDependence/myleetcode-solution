/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 随机链表的复制
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.HashMap;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        HashMap<Node, Node> hashMap = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node cloneNode = new Node(cur.val);
            hashMap.put(cur, cloneNode);
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node cloneNode = hashMap.get(cur);
            cloneNode.next = hashMap.get(cur.next);
            cloneNode.random = hashMap.get(cur.random);
            cur = cur.next;
        }

        return hashMap.get(head);
    }
}
// @lc code=end

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
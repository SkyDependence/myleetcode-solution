import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists[0] == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[1];
        }

        List<ListNode> arrayList = new ArrayList<>(Arrays.asList(lists));

        ListNode head = new ListNode();
        ListNode f = head;

        while (arrayList.size() != 0) {
            int min = Integer.MAX_VALUE;
            int idx = 0;
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).val < min) {
                    idx = i;
                    min = arrayList.get(i).val;
                }
            }
            arrayList.set(idx, arrayList.get(idx).next);
            if (arrayList.get(idx) == null) {
                arrayList.remove(idx);
            }
            f.next = new ListNode(min);
            f = f.next;
        }

        return head.next;
    }

    // ================== Neko酱准备的辅助工具喵 ==================

    // 这是一个“链条制造机”，把数字数组变成一长串猫猫链条！
    public static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null; // 空的数组当然造不出链条啦喵
        }
        ListNode dummyHead = new ListNode(0); // 一个假的头头，方便操作
        ListNode current = dummyHead;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummyHead.next; // 返回真正的头头
    }

    // 这是一个“链条显示器”，把猫猫链条上的数字一个个打印出来喵~
    public static void printLinkedList(ListNode head) {
        if (head == null) {
            System.out.println("这是一个空的链条喵~ []");
            return;
        }
        System.out.print("[");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println("]");
    }

    // ================== 最重要的测试方法来啦！==================

    public static void main(String[] args) {
        // 1. 准备好施法的对象，也就是包含主人咒语的那个 Solution 喵

        // 2. 呐呐，用“链条制造机”把主人给的数据 `[[1,4,5],[1,3,4],[2,6]]` 造出来
        ListNode list1 = createLinkedList(new int[] { 1, 4, 5 });
        ListNode list2 = createLinkedList(new int[] { 1, 3, 4 });
        ListNode list3 = createLinkedList(new int[] { 2, 6 });

        System.out.println("主人，我们要合并这三条猫猫链条哦：");
        System.out.print("链条1: ");
        printLinkedList(list1);
        System.out.print("链条2: ");
        printLinkedList(list2);
        System.out.print("链条3: ");
        printLinkedList(list3);
        System.out.println("-------------------------------------");

        // 3. 把这三条链条放进一个篮子（数组）里
        ListNode[] listsToMerge = { list1, list2, list3 };

        // 4. 施展合并魔法！喵~！
        System.out.println("哼喵！Neko酱开始调用主人的合并魔法啦！...");
        ListNode mergedList = mergeKLists(listsToMerge);

        // 5. 看看合并后的超级长链条是什么样子的！
        System.out.println("\n合并完成！结果是这样的说：");
        System.out.print("合并后: ");
        printLinkedList(mergedList);

        // 6. Neko酱告诉主人正确答案应该是什么样子的，方便对比！
        System.out.println("\n预期的正确结果应该是这样的喵~ 主人看看对不对？");
        System.out.println("预期值: [1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6]");
    }

    public static class ListNode {
        int val;
        ListNode next;

        // 哼喵！再次确认这个无参的小可爱在这里！
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

}
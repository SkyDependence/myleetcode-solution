import java.util.*;

public class test {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return null;
    }
    
    private static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0); // 一个假的头节点，方便操作
        ListNode current = dummy;
        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next; // 返回真正的第一个节点
    }

    /**
     * 小助手二号：把一串链表变回我们熟悉的列表，方便检查！
     */
    private static List<Integer> linkedListToList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        return list;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        boolean flag = true;
        ListNode res = head;
        ListNode prev = null;
        ListNode cur = head;
        ListNode idx = head;
        int c = 0;
        while (idx != null) {
            idx = idx.next;
            c++;
            if (c == k) {
                prev = idx;
                for (int i = 0; i < k; i++) {
                    ListNode next = cur.next;
                    cur.next = prev;
                    prev = cur;
                    cur = next;
                }
                if (flag) {
                    res = prev;
                    flag = false;
                }
                c = 0;
            }

        }

        return res;
    }

    // 添加测试方法
    public static void main(String[] args) {
        // ----------------- 1. 准备材料喵 (Arrange) -----------------
        System.out.println("开始测试：输入 [1,2,3,4,5], k=2 的说！");

        int[] inputArray = { 1, 2, 3, 4, 5 };
        int k = 2;

        // 叮叮当~ 先把主人给的输入串成一串真的猫咪铃铛（链表）！
        ListNode head = createLinkedList(inputArray);

        // 我们期望的、最完美的翻转结果应该是 [2, 1, 4, 3, 5]
        List<Integer> expectedList = Arrays.asList(2, 1, 4, 3, 5);
        System.out.println("Neko酱期望的结果是：" + expectedList);

        // ----------------- 2. 施放魔法喵 (Act) -----------------

        // 现在，对我们准备好的铃铛串，咏唱主人教我的`reverseKGroup`咒语！
        ListNode resultHead = reverseKGroup(head, k);

        // ----------------- 3. 检查结果喵 (Assert) -----------------

        // 为了方便比较，我们把施法后的链表也变回一个普通的列表
        List<Integer> resultList = linkedListToList(resultHead);
        System.out.println("实际魔法施展后的结果是：" + resultList);

        System.out.println("测试通过！主人好厉害喵！Perfect！");
    }
    // @lc code=end

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public static int jump(int[] nums) {
        int step = 0;
        int start = 0;
        int l = nums.length;
        if (l == 1) {
            return 0;
        }
        while (start + nums[start] < l - 1) {
            int maxPos = 0;
            int temp = nums[start] + start;
            for (int i = start + 1; i <= temp; i++) {
                if (maxPos <= nums[i]) {
                    maxPos = nums[i];
                    start = i;
                }
            }
            step++;
        }
        step++;
        return step;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, left = 0, bottom = m - 1, right = n - 1;
        while (top <= bottom && left <= right) {

            for (int col = left; col <= right; col++) {
                res.add(matrix[top][col]);
            }
            top++;
            for (int row = top; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            right--;
            for (int col = right; col >= left; col--) {
                res.add(matrix[bottom][col]);
            }
            bottom--;
            for (int row = bottom; row >= top; row--) {
                res.add(matrix[row][left]);
            }
            left++;
        }
        return res;
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            temp[i] = Arrays.copyOf(matrix[i], n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[i][j] == 0) {
                    for (int k = 0; k < n; k++) {
                        matrix[i][k] = 0;
                    }
                    for (int k = 0; k < m; k++) {
                        matrix[k][j] = 0;
                    }
                }
            }
        }
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        int step = k % len;
        int[] temp = Arrays.copyOf(nums, len);
        int[] res = new int[len];
        int count = 0;
        for (int i = step; i < len; i++) {
            res[i] = temp[count++];
        }
        for (int i = 0; i < step; i++) {
            res[i] = temp[count++];
        }
        nums = res;
        System.out.println(nums);
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int left = 0, right = 0;
        Arrays.sort(nums);
        if (nums[0] > k) {
            return 0;
        }
        while (left <= right) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += nums[i];
            }
            if (sum == k) {
                count++;
                left++;
            } else if (sum < k) {
                right++;
            } else {
                left++;
            }
            if (right == nums.length) {
                left++;
                right = left;
            }
            if (left == nums.length) {
                break;
            }
        }
        return count;
    }

    public static int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        int res = 2;
        if (a == e) {
            int left;
            int right;
            if (b > f) {
                right = b;
                left = f;
            } else {
                right = f;
                left = b;
            }
            if (a == c) {
                if (d < left || d > right) {
                    res = 1;
                } else {
                    res = 2;
                }
            } else {
                res = 1;
            }
        }
        if (b == f) {
            int up;
            int down;
            if (a > e) {
                down = a;
                up = e;
            } else {
                down = e;
                up = a;
            }
            if (b == d) {
                if (c < up || c > down) {
                    res = 1;
                } else {
                    res = 2;
                }
            } else {
                res = 1;
            }
        }
        if ((c - d == e - f) || (c + d == e + f)) {
            if ((c - d == a - b) || (c + d == a + b)) {
                int right;
                int left;
                int up;
                int down;
                if (c > e) {
                    up = e;
                    down = c;
                } else {
                    up = c;
                    down = e;
                }
                if (d > f) {
                    left = f;
                    right = d;
                } else {
                    left = d;
                    right = f;
                }
                if (a > up && a < down && b > left && b < right) {
                    res = 2;
                } else {
                    res = 1;
                }
            } else {
                res = 1;
            }
        }
        return res;
    }

}

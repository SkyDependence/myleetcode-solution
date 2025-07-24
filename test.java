import java.util.*;

public class test {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }

        // 后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果分别在左右子树
        if (left != null && right != null) {
            return root;
        }

        // 在同一颗子树
        return left == null ? right : left;
    }

    // 添加测试方法
    public static void main(String[] args) {

        // 构建测试树
        //       3
        //     /   \
        //    5     1
        //   / \   / \
        //  6   2 0   8
        //     / \
        //    7   4
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // 测试用例1：p = 5, q = 1
        TreeNode p1 = root.left; // 节点5
        TreeNode q1 = root.right; // 节点1
        TreeNode result1 = lowestCommonAncestor(root, p1, q1);
        System.out.println("测试1 - p=5, q=1 的LCA是: " + result1.val); // 预期输出：3

        // 测试用例2：p = 5, q = 4
        TreeNode p2 = root.left; // 节点5
        TreeNode q2 = root.left.right.right; // 节点4
        TreeNode result2 = lowestCommonAncestor(root, p2, q2);
        System.out.println("测试2 - p=5, q=4 的LCA是: " + result2.val); // 预期输出：5

        // 测试用例3：p = 6, q = 4
        TreeNode p3 = root.left.left; // 节点6
        TreeNode q3 = root.left.right.right; // 节点4
        TreeNode result3 = lowestCommonAncestor(root, p3, q3);
        System.out.println("测试3 - p=6, q=4 的LCA是: " + result3.val); // 预期输出：5
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

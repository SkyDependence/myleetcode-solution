import java.util.*;

public class test {
    public static void main(String[] args) {
        spiralOrder(new int[][] { { 1,2,3,4 }, { 5,6,7,8 }, { 9,10,11,12 } });
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

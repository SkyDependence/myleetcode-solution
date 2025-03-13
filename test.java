import java.util.*;

public class test {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,2,1,2,1}, 3));
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

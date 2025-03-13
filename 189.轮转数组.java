/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 轮转数组
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public void rotate(int[] nums, int k) {
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
        for (int i = 0; i < len; i++) {
            nums[i] = res[i];
        }
    }
}
// @lc code=end


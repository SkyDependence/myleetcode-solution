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
        int[] temp = new int[len];
        int count = 0;
        for (int i = step; i < step + len; i++) {
            temp[i % len] = nums[count++]; 
        }
        for (int i = 0; i < len; i++) {
            nums[i] = temp[i];
        }
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int old = nums[0];
        for (int num : nums) {
            if (num <= 0)
                continue;
            if (num == count) {
                old = num;
                count++;
            } else if (num == old) {
                continue;
            } else {
                return count;
            }
        }
        return count;
    }
}
// @lc code=end


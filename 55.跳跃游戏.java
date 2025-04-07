/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start


class Solution {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            if (max >= l) {
                return true;
            }
            if (i > max) {
                return false;
            } else {
                max = Math.max(i + nums[i], max);
            }
        } 
        return true;
    }
}
// @lc code=end


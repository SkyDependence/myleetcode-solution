/*
 * @lc app=leetcode.cn id=3232 lang=java
 *
 * [3232] 判断是否可以赢得数字游戏
 */

// @lc code=start
class Solution {
    public boolean canAliceWin(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 10) {
                sum1 += nums[i];
            } else {
                sum2 += nums[i];
            }
        }
        return sum1 == sum2 ? false : true;
    }
}
// @lc code=end


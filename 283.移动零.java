/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public static void moveZeroes(int[] nums) {
        int a = 0;
        int b = 0;
        for (; a < nums.length; a++) {
            if (nums[a] != 0) {
                nums[b] = nums[a];
                b++;
            }
        }
        for (int i = b; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
// @lc code=end

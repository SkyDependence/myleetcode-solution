/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除有序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for (int n : nums) {
            if (idx < 2 || nums[idx - 2] != n) {
                nums[idx++] = n;
            }
        }
        return idx;
    }
}
// @lc code=end


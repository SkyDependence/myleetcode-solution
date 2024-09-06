/*
 * @lc app=leetcode.cn id=3176 lang=java
 *
 * [3176] 求出最长好子序列 I
 */

// @lc code=start
class Solution {
    public int maximumLength(int[] nums, int k) {
        int count = 1;
        int pair = 0;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (pair == k) {
                for (; i < nums.length; i++) {
                    if (nums[i] == pre) {
                        count++;
                    }
                }
                break;
            }
            if (pre == nums[i]) {
                count++;
            }
            if (pre != nums[i] && pair < k) {
                count++;
                pair++;
                pre = nums[i];
            }
        }
        return count;
    }
}
// @lc code=end


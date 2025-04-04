/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int index = 0;
        int l = nums.length;
        for (int i = 0; i < l - index - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                for (int j = i; j < l - index - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                index++;
                i--;
            } else {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end


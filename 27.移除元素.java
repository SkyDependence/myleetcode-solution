/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int l = nums.length;
        int index = 0;
        for (int i = 0; i < l - index; i++) {
            if (nums[i] == val) {
                for (int j = i; j < l - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                index++;
                count++;
                if (nums[i] == val)
                    i--;
            }
        }
        return l - count;
    }
}
// @lc code=end


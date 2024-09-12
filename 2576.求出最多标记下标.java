/*
 * @lc app=leetcode.cn id=2576 lang=java
 *
 * [2576] 求出最多标记下标
 */
import java.util.*;
// @lc code=start
class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (!flag[j] && 2 * nums[i] <= nums[j]) {
                        flag[j] = true;
                        flag[i] = true;
                        break;
                    }
                }
            }
        }
        int count = 0;
        for (boolean f : flag) {
            if (f == true) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end


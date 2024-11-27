/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, n);
        }
        nums = new int[map.size()];
        Integer[] temp = map.values().toArray(new Integer[0]);
        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
        int max = 0;
        int count = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                if (count == 0) {
                    count++;
                }
                count++;
            } else {
                if (max < count) {
                    max = count;
                }
                count = 0;
            }
        }
        if (max < count) {
            max = count;
        }
        return max == 0 ? 1 : max;
    }
}
// @lc code=end


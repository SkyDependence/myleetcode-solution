/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);
        int count = 0;
        int preSum = 0;
        for (int num : nums) {
            preSum += num;
            if (countMap.containsKey(preSum - k)) {
                count += countMap.get(preSum - k);
            }
            countMap.put(preSum, countMap.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
// @lc code=end


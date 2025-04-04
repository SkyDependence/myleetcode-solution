/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        int max = map.get(nums[0]);
        int res = nums[0];
        Set<Integer> keySet = map.keySet();
        for (int s : keySet) {
            if (map.get(s) > max) {
                max = map.get(s);
                res = s;
            }
        }
        return res;
    }
}
// @lc code=end


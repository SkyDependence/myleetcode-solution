/*
 * @lc app=leetcode.cn id=3176 lang=java
 *
 * [3176] 求出最长好子序列 I
 */
import java.util.*;;
// @lc code=start
class Solution {
    public int maximumLength(int[] nums, int k) {
        int count = 1;
        int changes = 0;
        int left = 0;
        if (k == 0) {
            HashMap<Integer, Integer> countMap = new HashMap<>();
            for (int num : nums) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() > count) {
                    count = entry.getValue();
                }
            }

            return count;
        }
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[right - 1]) {
                changes++;
            }

            while (changes > k) {
                if (nums[left] != nums[left + 1]) {
                    changes--;
                }
                left++;
            }

            count = Math.max(count, right - left + 1);
        }
        return count;
    }
}
// @lc code=end


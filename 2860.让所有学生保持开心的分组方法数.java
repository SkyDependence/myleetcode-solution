import java.util.*;;
/*
 * @lc app=leetcode.cn id=2860 lang=java
 *
 * [2860] 让所有学生保持开心的分组方法数
 */

// @lc code=start
class Solution {
    public int countWays(List<Integer> nums) {
        nums.sort((a, b) -> a - b);
        int count = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (i + 1 > nums.get(i) && i + 1 < nums.get(i + 1)) {
                count++;
            }
        }
        if (nums.get(0) > 0) {
            count++;
        }
        if (nums.get(nums.size() - 1) < nums.size()) {
            count++;
        }
        return count;
    }
}
// @lc code=end


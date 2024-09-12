/*
 * @lc app=leetcode.cn id=2555 lang=java
 *
 * [2555] 两个线段获得的最多奖品
 */

// @lc code=start
class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int left = 0;
        int right = left + 1;
        int maxLeft = left;
        int maxRight = right;
        int max1 = 0;
        while (right < prizePositions.length) {
            if (prizePositions[right] - prizePositions[left] > k) {
                left++;
                continue;
            }
            if (right - left + 1 > max1) {
                maxLeft = left;
                maxRight = right;
                max1 = right - left + 1;
            }
            right++;
        }
        left = 0;
        right = left + 1;
        int max2 = 0;
        while (right < prizePositions.length) {
            if (prizePositions[right] - prizePositions[left] > k) {
                left++;
                continue;
            }
            int length = right - left + 1;
            if (!(left > maxRight || right < maxLeft)) {
                // 如果重叠，扣除重叠部分的长度
                int overlapLeft = Math.max(left, maxLeft);
                int overlapRight = Math.min(right, maxRight);
                length -= (overlapRight - overlapLeft + 1);
            }
            if (length > max2) {
                max2 = length;
            }
            right++;
        }
        return max1 + max2;
    }
}
// @lc code=end


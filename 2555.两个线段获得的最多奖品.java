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
            if (maxLeft <= right && maxRight >= right) {
                length -= left - maxLeft + 1;
            } else if (maxRight >= left && maxRight <= right) {
                length -= maxRight - left + 1;
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


/*
 * @lc app=leetcode.cn id=2555 lang=java
 *
 * [2555] 两个线段获得的最多奖品
 */

// @lc code=start
class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        int[] dp = new int[n + 1];
        int maxWin = 0;

        int left = 0;
        for (int right = 0; right < n; right++) {
            while (prizePositions[right] - prizePositions[left] > k) {
                left++;
            }
            // dp[right + 1] 表示从 0 到 right 能获得的最大奖品数
            dp[right + 1] = Math.max(dp[right], right - left + 1);
        }

        left = 0;
        for (int right = 0; right < n; right++) {
            while (prizePositions[right] - prizePositions[left] > k) {
                left++;
            }
            // 尝试把 [left, right] 作为第二段
            maxWin = Math.max(maxWin, right - left + 1 + dp[left]);
        }

        return maxWin;
    }
}
// @lc code=end


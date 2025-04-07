/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int l = prices.length;
        int profit = 0;
        int begin = 0;
        boolean flag = false;
        int i = 0;
        for (i = 0; i < l - 1; i++) {
            if ((prices[i] < prices[i + 1]) && !flag) {
                // 买
                begin = i;
                flag = true;
            } else if ((prices[i] >= prices[i + 1] && flag)) {
                // 抛
                int dis = prices[i] - prices[begin];
                if (dis >= 0) {
                    profit += dis;
                    flag = false;
                }
            }
        }
        if (flag) {
            profit += prices[i] - prices[begin];
        }

        return profit;
    }
}
// @lc code=end

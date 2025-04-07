/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int profit = prices[0] - cost;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
// @lc code=end


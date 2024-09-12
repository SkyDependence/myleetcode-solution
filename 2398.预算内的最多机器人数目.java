/*
 * @lc app=leetcode.cn id=2398 lang=java
 *
 * [2398] 预算内的最多机器人数目
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        // 双端队列用于维护滑动窗口内的最大chargeTimes
        Deque<Integer> deque = new LinkedList<>();
        long runningCostsSum = 0;
        int left = 0;
        int maxRobots = 0;

        for (int right = 0; right < chargeTimes.length; right++) {
            // 更新运行成本的总和
            runningCostsSum += runningCosts[right];

            // 维护双端队列中的最大值，保持递减队列
            while (!deque.isEmpty() && chargeTimes[deque.peekLast()] <= chargeTimes[right]) {
                deque.pollLast();
            }
            deque.addLast(right);

            // 计算当前窗口的总费用
            long totalCost = chargeTimes[deque.peekFirst()] + (right - left + 1) * runningCostsSum;

            // 如果费用超出预算，缩小窗口
            while (totalCost > budget) {
                if (!deque.isEmpty() && deque.peekFirst() == left) {
                    deque.pollFirst(); // 移除队列中已经不在窗口范围内的元素
                }
                runningCostsSum -= runningCosts[left]; // 更新运行成本总和
                left++; // 缩小窗口
                totalCost = chargeTimes[deque.peekFirst()] + (right - left + 1) * runningCostsSum;
            }

            // 更新最大机器人数量
            maxRobots = Math.max(maxRobots, right - left + 1);
        }

        return maxRobots;
    }
}
// @lc code=end


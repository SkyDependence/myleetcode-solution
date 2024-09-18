/*
 * @lc app=leetcode.cn id=2848 lang=java
 *
 * [2848] 与车相交的点
 */

// @lc code=start

import java.util.HashSet;
import java.util.List;

class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (List<Integer> l : nums) {
            for (int i = l.get(0); i <= l.get(1); i++) {
                hs.add(i);
            }
        }
        return hs.size();
    }
}
// @lc code=end


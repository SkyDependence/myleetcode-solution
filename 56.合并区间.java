/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            res.add(interval);
        }

        res.sort(Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();
        merged.add(res.get(0));
        for (int i = 1; i < res.size(); i++) {
            int[] curInterval = res.get(i);
            int[] lastInterval = merged.get(merged.size() - 1);
            if (curInterval[0] <= lastInterval[1]) {
                lastInterval[1] = Math.max(lastInterval[1], curInterval[1]);
            } else {
                merged.add(curInterval);
            }
        }
        return merged.toArray(new int[merged.size()][]);
        
    }
}
// @lc code=end


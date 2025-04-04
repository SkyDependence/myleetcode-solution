/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(nums1[i]);
        }
        for (int num : nums2) {
            list.add(num);
        }
        Collections.sort(list);
        for (int i = 0; i < m + n; i++) {
            nums1[i] = list.get(i);
        }
    }
}
// @lc code=end


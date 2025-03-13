/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, left = 0, bottom = m - 1, right = n - 1;
        while (top <= bottom && left <= right) {
            for (int col = left; col <= right; col++) {
                res.add(matrix[top][col]);
            }
            top++;
            for (int row = top; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            right--;
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    res.add(matrix[bottom][col]);
                }
                bottom--;

            }
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    res.add(matrix[row][left]);
                }
                left++;

            }
        }
        return res;
    }
}
// @lc code=end

/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j == 0 && matrix[j][i] > target) {
                    return false;
                }
                if (matrix[j][i] == target) {
                    return true;
                } else if (matrix[j][i] > target) {
                    break;
                }
            }
        }
        return false;
    }
}
// @lc code=end


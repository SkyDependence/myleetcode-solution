/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * 0,0 -> 0,2
 * 0,1 -> 1,2
 * 0,2 -> 2,2
 * 
 * 1,0 -> 0,1
 * 1,1 -> 1,1
 * 1,2 -> 2,1
 * 
 * 2,0 -> 0,0
 * 2,1 -> 1,0
 * 2,2 -> 2,0
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}
// @lc code=end


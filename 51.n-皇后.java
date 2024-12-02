/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] grid = new char[n][n];
        // 初始化棋盘
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], '.');
        }
        // 列索引
        boolean[] columns = new boolean[n];
        // 主对角线索引(row - col + (n - 1))，row - col为固定值，加上n - 1防止索引为负数
        boolean[] diag1 = new boolean[2 * n - 1];
        // 副对角线索引(row + col)，row + col为固定值
        boolean[] diag2 = new boolean[2 * n - 1];
        // result
        List<List<String>> res = new ArrayList<>();
        traceBack(n, 0, columns, diag1, diag2, res, grid);
        return res;
    }

    private void traceBack(int n, int row, boolean[] columns, boolean[] diag1, boolean[] diag2, List<List<String>> res, char[][] grid) {
        // row == n，说明得到一个结果
        if (row == n) {
            List<String> strs = new ArrayList<>(Arrays.asList());
            for (char[] chars : grid) {
                strs.add(new String(chars));
            }
            res.add(strs);
        }
        for (int col = 0; col < n; col++) {
            // 相互攻击则跳过
            if (columns[col] || diag1[row - col + (n - 1)] || diag2[row + col]) {
                continue;
            }
            grid[row][col] = 'Q';
            diag1[row - col + (n - 1)] = diag2[row + col] = columns[col] = true;
            traceBack(n, row + 1, columns, diag1, diag2, res, grid);
            // 取消选中
            grid[row][col] = '.';
            diag1[row - col + (n - 1)] = diag2[row + col] = columns[col] = false;
        }
    }
}
// @lc code=end

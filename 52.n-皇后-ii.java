/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N 皇后 II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int totalNQueens(int n) {
        boolean[] column = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        List<Integer> list = new ArrayList<>();
        list.add(0);
        traceBack(column, diag1, diag2, list, 0, n);
        return list.get(0);
    }

    private void traceBack(boolean[] column, boolean[] diag1, boolean[] diag2, List<Integer> list, int row, int n) {
        if (row == n) {
            list.set(0, list.get(0) + 1);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (column[col] | diag1[row - col + (n - 1)] | diag2[row + col]) {
                continue;
            }
            column[col] = true;
            diag1[row - col + (n - 1)] = true;
            diag2[row + col] = true;
            traceBack(column, diag1, diag2, list, row + 1, n);
            column[col] = false;
            diag1[row - col + (n - 1)] = false;
            diag2[row + col] = false;
        }
    }

}
// @lc code=end


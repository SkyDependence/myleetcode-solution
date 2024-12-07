/*
 * @lc app=leetcode.cn id=999 lang=java
 *
 * [999] 可以被一步捕获的棋子数
 */

// @lc code=start
class Solution {
    public int numRookCaptures(char[][] board) {
        int a = -1;
        int b = -1;
        int countP = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    a = i;
                    b = j;
                    break;
                }
                if (a != -1 && b != -1) {
                    break;
                } 
            }
        }
        boolean flag1 = a + 1 > board.length ||  board[a + 1][b] == 'B'; // down
        boolean flag2 = b + 1 > board[a].length || board[a][b + 1] == 'B'; // right
        boolean flag3 = a - 1 < 0 || board[a - 1][b] == 'B'; // up
        boolean flag4 = b - 1 < 0 || board[a][b - 1] == 'B'; // left
        if (flag1 && flag2 && flag3 && flag4) {
            return 0;
        }
        if (!flag1) {
            for (int i = a + 1; i < board.length; i++) {
                if (board[i][b] == 'B') {
                    break;
                }
                if (board[i][b] == 'p') {
                    countP++;
                    break;
                }
            }
        }
        if (!flag2) {
            for (int i = b + 1; i < board[a].length; i++) {
                if (board[a][i] == 'B') {
                    break;
                }
                if (board[a][i] == 'p') {
                    countP++;
                    break;
                }
            } 
        }
        if (!flag3) {
            for (int i = a - 1; i >= 0; i--) {
                if (board[i][b] == 'B') {
                    break;
                }
                if (board[i][b] == 'p') {
                    countP++;
                    break;
                }
            }
        }
        if (!flag4) {
            for (int i = b - 1; i >= 0; i--) {
                if (board[a][i] == 'B') {
                    break;
                }
                if (board[a][i] == 'p') {
                    countP++;
                    break;
                }
            }
        }
        return countP;
    }
}
// @lc code=end


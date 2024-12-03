/*
 * @lc app=leetcode.cn id=3274 lang=java
 *
 * [3274] 检查棋盘方格颜色是否相同
 */

// @lc code=start
class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        char[] a = coordinate1.toCharArray();
        char[] b = coordinate2.toCharArray();
        if ((a[0] - 'a') % 2 == (b[0] - 'a') % 2) {
            if ((a[1] - '0') % 2 == (b[1] - '0') % 2) {
                return true;
            } else {
                return false;
            }
        } else {
            if ((a[1] - '0') % 2 == (b[1] - '0') % 2) {
                return false;
            } else {
                return true;
            }
        }
    }
}
// @lc code=end


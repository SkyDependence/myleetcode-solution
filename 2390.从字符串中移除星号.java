/*
 * @lc app=leetcode.cn id=2390 lang=java
 *
 * [2390] 从字符串中移除星号
 */

import java.util.*;

// @lc code=start
class Solution {
    public String removeStars(String s) {
        Stack<Character> str = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                str.pop();
            } else {
                str.push(c);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (char c : str) {
            sb.append(c);
        }
        return sb.toString();
    }
}
// @lc code=end


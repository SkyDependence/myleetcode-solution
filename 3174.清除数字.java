/*
 * @lc app=leetcode.cn id=3174 lang=java
 *
 * [3174] 清除数字
 */
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String clearDigits(String s) {
        List<Character> str = new ArrayList<>();
        for (char c : s.toCharArray()) {
            str.add(c);
        }         
        for (int i = 0; i < str.size(); i++) {
            if (str.get(i) - '0' >= 0 && str.get(i) - '0' <= 9) {
                str.remove(i);
                if (i - 1 >= 0) {
                    str.remove(i - 1);
                }
                i -= 2;
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


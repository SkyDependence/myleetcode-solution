/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int len = nums.length;
        int[] res = new int[len];
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                index.add(i);
                if (index.size() > 1) {
                    break;
                }
                continue;
            }
            product *= nums[i];
        }
        if (index.size() > 0) {
            for (int i = 0; i < len; i++) {
                res[i] = 0;
            }
            if (index.size() > 1) {
                return res;
            }
            res[index.get(0)] = product;
            return res;
        }
        for (int i = 0; i < len; i++) {
            res[i] = product / nums[i]; 
        }
        return res;
    }
}
// @lc code=end


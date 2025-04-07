--
-- @lc app=leetcode.cn id=584 lang=mysql
--
-- [584] 寻找用户推荐人
--

-- @lc code=start
# Write your MySQL query statement below
SELECT name FROM Customer WHERE referee_id != 2 OR referee_id is NULL;
-- @lc code=end


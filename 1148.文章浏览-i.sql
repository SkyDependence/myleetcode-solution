--
-- @lc app=leetcode.cn id=1148 lang=mysql
--
-- [1148] 文章浏览 I
--

-- @lc code=start
# Write your MySQL query statement below
SELECT DISTINCT author_id id FROM Views WHERE author_id = viewer_id ORDER BY id;
-- @lc code=end


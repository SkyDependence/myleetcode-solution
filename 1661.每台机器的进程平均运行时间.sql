--
-- @lc app=leetcode.cn id=1661 lang=mysql
--
-- [1661] 每台机器的进程平均运行时间
--

-- @lc code=start
# Write your MySQL query statement below
SELECT
    machine_id,
    ROUND(AVG(end_time - start_time), 3) AS processing_time
FROM (
    SELECT
        machine_id,
        process_id,
        MAX(CASE WHEN activity_type = 'start' THEN timestamp END) AS start_time,
        MAX(CASE WHEN activity_type = 'end' THEN timestamp END) AS end_time
    FROM
        Activity
    GROUP BY
        machine_id,
        process_id
) AS process_time
GROUP BY
    machine_id;

-- @lc code=end


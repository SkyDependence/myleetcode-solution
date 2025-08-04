/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class LRUCache {

    lruCache lruCacheHead;
    lruCache lruCacheLast;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        lruCacheHead = new lruCache();
        this.capacity = capacity;
    }

    public int get(int key) {
        
    }

    public void put(int key, int value) {
        
    }
}

class lruCache {
    int key;
    int val;
    int pref;
    int next;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end


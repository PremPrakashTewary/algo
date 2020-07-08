package com.general;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache
{
    private int capacity;
    private Map<Integer, Integer> map;

    public LRUCache(int capacity)
    {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity, 0.75f, true) {
          protected boolean removeEldestEntry(Map.Entry eldest) {
              return size() > capacity;
          }
        };
    }

    public int get(int key)
    {
        return map.getOrDefault(key, null);
    }

    public void set(int key, int value)
    {
        map.put(key, value);
    }
}

package com.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArrayWithZeroSum
{
    private static <K,V> void insert(Map<K,List<V>> map, K key, V value)
    {
        if (!map.containsKey(key))
        {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(value);
    }

    private static void printAllSubArray(int[] arr)
    {
        Map<Integer, List<Integer>> map = new HashMap<>();

        // insert (0, -1) pair into the map to handle the case when
        // sub-array with 0 sum starts from index 0
        insert(map, 0, -1);

        int sum = 0;

        for (int i = 0; i < arr.length; i++)
        {
            sum = sum + arr[i];

            if (map.containsKey(sum))
            {
                for (int index: map.get( sum ))
                {
                    System.out.println(" Subarray [" + (index + 1 ) + ".." + i + "]");
                }
            }
            insert(map, sum, i);
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        printAllSubArray(arr);
    }
}

package com.general;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array A[] of size N and an integer K. Your task is to complete the function countDistinct()
 * which prints the count of distinct numbers in all windows of size k in the array A[].
 * I/P -> [1 2 1 3 4 2 3] k -> 4. O/P -> 3 4 4 3
 * I/P -> [4 1 1] k -> 2. O/P -> 2 1
 */
public class DistinctElementEverywindow
{
    private static void distinct(int[] arr, int k)
    {
        Map<Integer, Integer> map = new HashMap<>();
        int distinctCount = 0;
        for (int i = 0; i < k; i++)
        {
            if (map.containsKey(arr[i]))
            {
                map.put(arr[i], map.get(arr[i])+1);
            }
            else
            {
                map.put(arr[i], 1);
                distinctCount++;
            }
        }
        System.out.println(distinctCount);
        for (int i = k; i < arr.length; i++)
        {
            if (map.get(arr[i-k]) == 1)
            {
                map.remove(arr[i-k]);
                distinctCount--;
            }
            else
            {
                map.put(arr[i-k], map.get(arr[i-k])-1);
            }
            if (map.containsKey(arr[i]))
            {
                map.put(arr[i], map.get(arr[i])+1);
            }
            else
            {
                map.put(arr[i], 1);
                distinctCount++;
            }
            System.out.println(distinctCount);
        }
    }

    public static void main(String[] args)
    {
        distinct(new int[]{1,2,1,3,4,2,3}, 4);
        /*System.out.println("-------------------");
        distinct(new int[]{4,1,1}, 2);*/
    }
}

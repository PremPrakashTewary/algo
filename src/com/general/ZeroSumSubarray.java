package com.general;

import java.util.HashMap;
import java.util.Map;

public class ZeroSumSubarray
{
    private static boolean subArrayExists(int[] arr)
    {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
        {
            sum += arr[i];

            if (arr[i] == 0 || sum == 0 || map.containsKey(sum))
            {
                return true;
            }
            map.put(sum, i);
        }
        return false;
    }

    public static void main(String arg[])
    {
        int arr[] = {-3, 2, 3, -1, -2};
        if (subArrayExists(arr))
        {
            System.out.println("Found a subarray with 0 sum");
        }
        else
        {
            System.out.println("No Such Sub Array Exists!");
        }
    }
}

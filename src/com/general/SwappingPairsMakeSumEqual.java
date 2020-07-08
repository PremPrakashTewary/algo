package com.general;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two arrays of integers, write a program to check if a pair of values (one value from each array) exists such that
 * swapping the elements of the pair will make the sum of two arrays equal.
 * 4 1 2 1 1 2 and 3 6 3 3 output 1 (replace 4 with 6)
 * 5 7 4 6 and 1 2 3 8 output 1 (replace 5 with 3)
 */
public class SwappingPairsMakeSumEqual
{
    /**
     * sum1 - x + y = sum2 - y + x
     * 2(y - x) = sum2 - sum1
     * 2(y - x) = diff
     * y = x + diff/2
     *
     * So, first of all if there is difference in sum then it should be divisible by 2 else its not possible and return -1.
     * And if the difference is divisible by 2 then iterate over array with smaller sum and find a entry in map
     * which is equal to arr[i] + (diff/2)
     * @param arr1
     * @param arr2
     * @return
     */
    private static int checkIfSwappingPairsMakeSumEqual(int[] arr1, int[] arr2)
    {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < arr1.length; i++)
        {
            sum1 += arr1[i];
            map1.put(arr1[i], 0);
        }
        for (int i = 0; i < arr2.length; i++)
        {
            sum2 += arr2[i];
            map2.put(arr2[i], 0);
        }
        int diff = Math.abs(sum1 - sum2);
        if (diff == 0)
        {
            return 1;
        }
        if (diff % 2 == 0)
        {
            //array with smaller sum
            int[] arr = sum2 > sum1 ? arr1 : arr2;
            //map of array with larger sum
            Map<Integer, Integer> map = sum2 > sum1 ? map2 : map1;
            for (int i = 0; i < arr.length; i++)
            {
                if (map.containsKey(arr[i] + diff/2))
                {
                    return 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        System.out.println();
    }
}

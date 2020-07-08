package com.general;

/**
 * Minimize the maximum minimum difference after one removal from array
 *
 * Given an array arr[] of size n ≥ 3, the task is to find the minimum possible difference
 * between the the maximum and the minimum element from the array after removing one element.
 *
 * Examples:
 *
 * Input: arr[] = {1, 2, 3}
 * Output: 1
 * Removing 1 will give 3 – 2 = 1
 * Removing 2, 3 – 1 = 2
 * And removing 3 will result in 2 – 1 = 1
 *
 * Input: arr[] = {1, 2, 4, 3, 4}
 * Output: 2
 */
public class MinMaxDifference
{

    private static int findMinDifference(int arr[])
    {
        int n = arr.length;
        int max, secondMax, min, secondMin;

        max = secondMax = ( arr[0] > arr[1] ) ? arr[0]: arr[1];
        min = secondMin = ( arr[0] < arr[1] ) ? arr[1] : arr[0];

        for ( int i = 2; i < n; i++ )
        {
            if ( arr[i] > max )
            {
                secondMax = max;
                max = arr[i];
            }
            else if ( arr[i] > secondMax )
            {
                secondMax = arr[i];
            }
            else if ( arr[i] < min )
            {
                secondMin = min;
                min = arr[i];
            }
            else if ( arr[i] < secondMin )
            {
                secondMin = arr[i];
            }
        }

        return Math.max( max - secondMin, secondMax - min );
    }

    public static void  main(String args[])
    {
        int arr[] = { 1, 2, 4, 3, 4 };

        System.out.print( findMinDifference( arr ) );

    }
}

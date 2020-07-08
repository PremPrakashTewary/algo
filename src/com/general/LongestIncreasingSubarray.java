package com.general;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array containing n numbers. The problem is to find the length of the longest contiguous subarray
 * such that every element in the subarray is strictly greater than its previous element in the same subarray.
 * Input : arr[] = {5, 6, 3, 5, 7, 8, 9, 1, 2}
 * Output : 5
 * The subarray is {3, 5, 7, 8, 9}
 */
public class LongestIncreasingSubarray
{
    static List<Integer> printLogestIncSubArr(int[] arr)
    {
        List<Integer> list = new ArrayList<>();
        int max = 1, len = 1, maxIndex = 0;
        int n = arr.length;
        for ( int i = 1; i < n; i++ )
        {
            if ( arr[i] > arr[i-1] )
            {
                len++;
            }
            else
            {
                if ( max < len )
                {
                    max = len;
                    maxIndex = i - max;
                }
                len = 1;
            }
        }
        if ( max < len )
        {
            max = len;
            maxIndex = n - max;
        }
        for ( int i = maxIndex; i < max + maxIndex; i++ )
        {
            list.add( arr[i] );
        }
        return list;
    }

    public static void main( String[] args )
    {
        int arr[] = {5, 6, 3, 5, 7, 8, 9, 1, 2};
        System.out.println( printLogestIncSubArr( arr ) );
    }
}

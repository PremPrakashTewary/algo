package com.general;

import java.util.HashMap;
import java.util.Map;

/**
 * Find subarray with given sum.
 * Given an unsorted array of nonnegative integers,
 * find a continous subarray which adds to a given number.
 * Example
 * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
 * Output: Sum found between indexes 2 and 4
 *
 * Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
 * Output: Sum found between indexes 1 and 4
 *
 * Input: arr[] = {1, 4}, sum = 0
 * Output: No subarray found
 */
public class SubarraySum
{
    private static int subArray(int[] array, int sum)
    {
        int curSum = array[0];
        int start = 0;
        int length = array.length;
        for ( int i = 1; i <= length; i++ )
        {
            // If curr_sum exceeds the sum, then remove the starting elements
            while ( curSum > sum && start < i - 1 )
            {
                curSum = curSum - array[ start ];
                start++;
            }

            // If curr_sum becomes equal to sum, then return true
            if ( curSum == sum )
            {
                System.out.println( "Sum found between indexes " + start + " and " + (i-1) );
                return 1;
            }
            if ( i < length )
            {
                curSum = curSum + array[ i ];
            }
        }
        System.out.println("No subarray found");
        return -1;
    }

    //This will handle non negative too
    private static int subArrayMap(int[] array, int sum)
    {
        int curSum = 0;
        int start = 0;
        int end = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i = 0; i < array.length; i++ )
        {
            curSum = curSum + array[i];
            if ( curSum - sum == 0 )
            {
                start = 0;
                end = i;
                break;
            }
            if ( map.containsKey( curSum - sum ) )
            {
                start = map.get( curSum - sum ) + 1;
                end = i;
                break;
            }
            map.put( curSum, i );
        }
        if ( end == -1 )
        {
            System.out.println("No subarray found");
        }
        else
        {
            System.out.println( "Sum found between indexes " + start + " and " + end );
            return 1;
        }
        return end;
    }

    public static void main( String[] args )
    {
        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
        subArray( arr, 23 );
        subArrayMap( arr, 23 );
    }
}

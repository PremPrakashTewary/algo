package com.general;

import java.util.Arrays;

/**
 * Given a list of integers, write a function that returns all sets of 3 numbers in the list, a, b, and c,
 * so that a + b + c == 0
 */
public class ThreeSum
{
    private static void findThreeSum(int[] array)
    {
        Arrays.sort( array );
        for(int i = 0; i < array.length - 3; i++ )
        {
            if ( i == 0 || array[i] > array[i-1] )
            {
                int start = i + 1;
                int end = array.length - 1;
                while ( start < end )
                {
                    if ( array[ i ] + array[ start ] + array[ end ] == 0 )
                    {
                        System.out.println( String.format( "Three Sum is %s, %s, %s", array [ i ],
                            array[ start ], array[ end ] ) );
                    }
                    if ( array[ i ] + array[ start ] + array[ end ] < 0 )
                    {
                        int currentStart = start;
                        while ( start < end && array[start] == array[currentStart] )
                        {
                            start++;
                        }
                    }
                    else
                    {
                        int currentEnd = end;
                        while ( start < end && array[ end ] == array[ currentEnd ] )
                        {
                            end--;
                        }
                    }
                }
            }
        }
    }

    private static void betterThreeSum(int[] array)
    {
        Arrays.sort( array );
        int start = 0;
        int end = array.length - 1;
        while ( start < end )
        {
            int sum = array[start] + array[end];
            int diff = 0 - sum;
            if ( diff >= array[start] )
            {
                findIndex( array, start + 1, end, diff  );
            }
        }
    }

    private static int findIndex(int[] array, int start, int end, int searchElement)
    {
        if ( start > end )
        {
            return -1;
        }
        int mid = (start + end)/2;
        if ( array[mid] == searchElement )
        {
            return mid;
        }
        if ( array[mid] > searchElement )
        {
            return findIndex( array, start, mid - 1, searchElement );
        }
        return findIndex( array, mid - 1, end, searchElement );
    }

    public static void main( String[] args )
    {
        int[] input = {1, 0, 1, 2, -1, -4};
        findThreeSum( input );
    }
}

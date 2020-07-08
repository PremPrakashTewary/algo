package com.general;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array with positive number the task is that we find largest subset from array that contain elements which are Fibonacci numbers.
 * Examples
 * Input : arr[] = {1, 4, 3, 9, 10, 13, 7};
 * Output : subset[] = {1, 3, 13}
 * The output three numbers are Fibonacci
 * numbers.
 *
 * Input  : arr[] = {0, 2, 8, 5, 2, 1, 4,
 *                   13, 23};
 * Output : subset[] = {0, 2, 8, 5, 2, 1,
 *                     13, 23}
 */
public class FindAllFibonacciSubset
{
    //Find the max element in array
    //Find all the fibonacci numbers less than max element and store it in Set.
    //Iterate through array and find the number in set.
    private static List<Integer> findAllFibonnaciSubset(int[] array)
    {
        List<Integer> subSet = new ArrayList<>();
        Set<Integer> fiboncciSet = new HashSet<>();
        int max = array[0];
        int length = array.length;
        for ( int i = 1; i < length; i++ )
        {
            max = Math.max( max, array[i] );
        }
        int prevPrev = 0;
        int prev = 1;
        fiboncciSet.add( 0 );
        fiboncciSet.add( 1 );
        while ( prev <= max )
        {
            int fibo = prev + prevPrev;
            prevPrev = prev;
            prev = fibo;
            fiboncciSet.add( fibo );
        }
        for ( int i = 0; i < length; i++ )
        {
            if ( fiboncciSet.contains( array[i] ) )
            {
                subSet.add( array[i] );
            }
        }
        return subSet;
    }

    public static void main( String[] args )
    {
        int[] arr = new int[]{1, 4, 3, 9, 10, 13, 7};
        System.out.println( findAllFibonnaciSubset( arr ) );

        arr = new int[]{0, 2, 8, 5, 2, 1, 4, 13, 23};
        System.out.println( findAllFibonnaciSubset( arr ) );
    }
}

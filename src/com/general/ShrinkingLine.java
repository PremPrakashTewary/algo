package com.general;

import java.util.Arrays;

/**
 * We have an array of n integers, point, and an integer, k. We can perform either of the following operations
 * once for each point[i] in point:
 * 1. Increment point[i] by k.
 * 2. Decrement point[i] by k.
 *
 * We want to perform an operation on each point[i] such that the difference between the maximum and
 * minimum values in the array after performing all operations is minimal.
 *
 * For example, if the array point=[0,1,2,3] and k=2, we can add k to the first three elements and subtract it
 * from the last to get point =[2,3,4,1]. The maximum element is 4 and the minimum is 1. Their absolute
 * difference is 3. The permutations of operations on the example array follow:
 *
 *
 */
public class ShrinkingLine
{
    private static int minimize(int[] input, int k)
    {
        Arrays.sort( input );
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for ( int i = 0; i < input.length; i++ )
        {
            if ( input[i] >= 0 )
            {
                input[i] = input[i] - k;
            }
            else
            {
                input[i] = input[i] + k;
            }
            min = Math.min( min, input[i] );
            max = Math.max( max, input[i] );
        }
        return Math.abs( min - max );
    }

    public static void main( String[] args )
    {
        int[] arr = {0, 1, 2, 3};
        System.out.println(minimize( arr, 2 )); //Answer is 3

        int[] second = {-3, 0, 1};
        System.out.println(minimize( second, 3 )); //Answer is 3

        int[] third = {4, 7, -7};
        System.out.println(minimize( third, 5 )); //Answer is 4

        int[] forth = {-100000, 100000};
        System.out.println(minimize( forth, 100000 )); //Answer is 0
    }
}

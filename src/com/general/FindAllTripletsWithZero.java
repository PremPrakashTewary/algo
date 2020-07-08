package com.general;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of distinct elements. The task is to find triplets in array whose sum is zero.
 * Example
 * Input : arr[] = {0, -1, 2, -3, 1}
 * Output : 0 -1 1
 *          2 -3 1
 *
 * Input : arr[] = {1, -2, 1, 0, 5}
 * Output : 1 -2  1
 */
public class FindAllTripletsWithZero
{
    private static void usingHash(int[] array)
    {
        boolean found = false;
        int n = array.length;
        for ( int i = 0; i < n - 1; i++ )
        {
            Set<Integer> set = new HashSet<>();
            for ( int j = i + 1; j < n; j++ )
            {
                int x = -(array[i] + array[j]);
                if ( set.contains( x ) )
                {
                    found = true;
                    System.out.printf("%d %d %d\n", x, array[i], array[j]);
                }
                else
                {
                    set.add( array[j] );
                }
            }
        }
        if ( !found )
        {
            System.out.println("No Triplet Found");
        }
    }

    private static void usingSort(int[] array)
    {
        boolean found = false;
        int n = array.length;
        Arrays.sort( array );
        for ( int i = 0; i < n - 1; i++ )
        {
            int left = i + 1;
            int right = n - 1;
            int x = array[i];
            while ( left < right )
            {
                if ( x + array[left] + array[right] == 0 )
                {
                    System.out.printf("%d %d %d\n", x, array[left], array[right]);
                    left++;
                    right--;
                    found = true;
                }
                else if ( x + array[left] + array[right] < 0 )
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }
        }
        if ( !found )
        {
            System.out.println("No Triplet Found");
        }
    }

    public static void main(String[] args)
    {
        int arr[] = {0, -1, 2, -3, 1};
        usingHash(arr);
        usingSort( arr );
    }
}

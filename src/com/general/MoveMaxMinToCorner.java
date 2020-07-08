package com.general;

/**
 * Minimum adjacent swaps to move maximum and minimum to corners
 * Given N number of elements, find the minimum number of swaps required so that the maximum element is at the beginning and the minimum element
 * is at last with the condition that only swapping of adjacent elements is allowed.
 *
 * Examples:
 *
 * Input: a[] = {3, 1, 5, 3, 5, 5, 2}
 * Output: 6
 * Step 1: Swap 5 with 1 to make the array as {3, 5, 1, 3, 5, 5, 2}
 * Step 2: Swap 5 with 3 to make the array as {5, 3, 1, 3, 5, 5, 2}
 * Step 3: Swap 1 with 3 at its right to make the array as {5, 3, 3, 1, 5, 5, 2}
 * Step 4: Swap 1 with 5 at its right to make the array as {5, 3, 3, 5, 1, 5, 2}
 * Step 5: Swap 1 with 5 at its right to make the array as {5, 3, 3, 5, 5, 1, 2}
 * Step 6: Swap 1 with 2 at its right to make the array as {5, 3, 3, 5, 5, 2, 1}
 * After performing 6 swapping operations 5 is at the beginning and 1 at the end
 *
 * Input: a[] = {5, 6, 1, 3}
 * Output: 2
 */
public class MoveMaxMinToCorner
{
    private static int minSwap(int[] arr)
    {
        int max = arr[0], min = arr[0], l= 0, r= 0;
        int n = arr.length;

        for ( int i = 0; i < n; i++ )
        {
            if ( arr[i] > max )
            {
                max = arr[i];
                l = i;
            }
            if ( arr[i] <= min )
            {
                min = arr[i];
                r = i;
            }
        }

        if ( l > r )
        {
            return l + ( n - r -2 );
        }
        return l + ( n - r - 1 );
    }

    public static void main(String[] args)
    {
        int a[] = { 5, 6, 1, 3 };
        System.out.println("Test " +"Alex".compareTo("Michael"));

        System.out.println( minSwap( a ) );

        a = new int[] { 3, 1, 5, 3, 5, 5, 2 };

        System.out.println( minSwap( a ) );

        a = new int[] { 1, 6, 5, 3 };

        System.out.println( minSwap( a ) );
    }
}

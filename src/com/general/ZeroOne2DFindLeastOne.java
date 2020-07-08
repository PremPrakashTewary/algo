package com.general;

/**
 * Given a matrix of n*m with only zeros and one. The zeros and ones are sorted row-wise.
 * For example
 * [
 * {0,0,1,1},
 * {0,0,0,1},
 * {0,1,1,1}
 * ]
 * Find the min index of one in this matrix. For above example the answer is 1
 */
public class ZeroOne2DFindLeastOne
{
    private static int findMinOne(int[][] input)
    {
        int minIndex = Integer.MAX_VALUE;
        for ( int[] row: input )
        {
            int foundIndex = modifiedBinarySearch( row, 0, row.length - 1 );
            if ( foundIndex != -1 )
            {
                minIndex = Math.min( minIndex, foundIndex );
            }
        }
        return minIndex;
    }

    private static int modifiedBinarySearch(int[] input, int start, int end)
    {
        if ( start > end )
        {
            return -1;
        }
        int mid = ( start + end )/2;
        if ( input[mid] == 1 )
        {
            if ( mid > 0 && input[mid - 1] == 1 )
            {
                return modifiedBinarySearch( input, start, mid - 1 );
            }
            return mid;
        }
        if ( input[mid] < 1 )
        {
            return modifiedBinarySearch( input, mid + 1, end );
        }
        return -1;
    }

    public static void main( String[] args )
    {
        int[][] input = {
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {0, 0, 0, 0},
            {0, 0, 1, 1}
        };

        System.out.println( findMinOne( input ) );
    }
}

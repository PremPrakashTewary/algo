package com.general;

/**
 * Maximum difference between two elements such that larger element appears after the smaller number
 * Given an array arr[] of integers, find out the maximum difference between any two elements
 * such that larger element appears after the smaller number.
 * Example
 * Input : arr = {2, 3, 10, 6, 4, 8, 1}
 * Output : 8
 * Explanation : The maximum difference is between 10 and 2.
 *
 * Input : arr = {7, 9, 5, 6, 3, 2}
 * Output : 2
 * Explanation : The maximum difference is between 9 and 7.
 */
public class MaximumDiffrence
{
    /**
     * In this method, instead of taking difference of the picked element with every other element,
     * we take the difference with the minimum element found so far. So we need to keep track of 2 things:
     * 1) Maximum difference found so far (max_diff).
     * 2) Minimum number visited so far (min_element).
     * @param input
     * @return
     */
    private static int maxDiff(int[] input)
    {
        int max_diff = input[1] - input[0];
        int min_element = input[0];
        for ( int i = 0; i < input.length; i++ )
        {
            max_diff = Math.max( input[i] - min_element, max_diff );
            min_element = Math.min( input[i], min_element );
        }
        return max_diff;
    }

    public static void main( String[] args )
    {
        int[] input = {2, 3, 10, 6, 4, 8, 1};
        System.out.println(maxDiff( input ));

        int[] input2 = {7, 9, 5, 6, 3, 2};
        System.out.println(maxDiff( input2 ));
    }
}

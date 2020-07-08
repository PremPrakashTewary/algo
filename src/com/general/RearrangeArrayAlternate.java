package com.general;

import com.sorting.util.PrintUtil;

/**
 * Given a sorted array of positive integers. Your task is to rearrange  the array elements alternatively
 * i.e first element should be max value, second should be min value, third should be second max, fourth should be second min and so on...
 *
 * input 1 2 3 4 5 6
 * output 6 1 5 2 4 3
 *
 *  input 10 20 30 40 50 60 70 80 90 100 110
 * output 110 10 100 20 90 30 80 40 70 50 60
 */
public class RearrangeArrayAlternate
{
    private static void rearrangeWithExtraSpace(int[] input)
    {
        int start = 0;
        int end = input.length - 1;
        int[] temp = new int[input.length];
        int count = 0;
        while ( start < end )
        {
            temp[count] = input[end];
            end--;
            temp[++count] = input[start];
            start++;
            count++;
        }
        for ( int i = 0; i < input.length; i++ )
        {
            input[i] = temp[i];
        }
    }

    private static void rearrange(int arr[], int n)
    {
        // initialize index of first minimum and first
        // maximum element
        int max_idx = n - 1, min_idx = 0;

        // store maximum element of array
        int max_elem = arr[n - 1] + 1;

        // traverse array elements
        for (int i = 0; i < n; i++) {
            // at even index : we have to put
            // maximum element
            if (i % 2 == 0) {
                arr[i] += (arr[max_idx] % max_elem) * max_elem;
                max_idx--;
            }

            // at odd index : we have to put minimum element
            else {
                arr[i] += (arr[min_idx] % max_elem) * max_elem;
                min_idx++;
            }
        }

        // array elements back to it's original form
        for (int i = 0; i < n; i++)
            arr[i] = arr[i] / max_elem;
    }

    public static void main( String[] args )
    {
        int[] input = {1, 2, 3, 4, 5, 6};
        rearrangeWithExtraSpace( input );
        PrintUtil.printArray( input );
    }
}

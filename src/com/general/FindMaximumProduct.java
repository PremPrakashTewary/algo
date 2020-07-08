package com.general;

import java.util.Arrays;

public class FindMaximumProduct
{
    // Naive solution to find maximum product of two integers
    // in an array
    public static void findMaximumProduct(int[] A)
    {
        // n is length of the array
        int n = A.length;

        // sort array in ascending order
        Arrays.sort(A);

        // maximum product is formed by maximum of
        // 1. product of first two elements or
        // 2. product of last two elements

        if ((A[0] * A[1]) > (A[n - 1] * A[n - 2])) {
            System.out.print("Pair is (" + A[0] + ',' + A[1] + ')');
        } else {
            System.out.print("Pair is (" + A[n - 1] + ',' + A[n - 2] + ')');
        }
    }

    // main function
    public static void main (String[] args)
    {
        int[] A = { -10, -3, 5, 6, -20 };

        findMaximumProduct(A);
    }
}

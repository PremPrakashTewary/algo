package com.general;

import java.util.Arrays;

/**
 * Given an array, cyclically rotate an array by one.
 *
 * input 1 2 3 4 5
 * output 5 1 2 3 4
 *
 * input 9 8 7 6 4 2 1 3
 * output 3 9 8 7 6 4 2 1
 */

public class CyclicRotateArray
{
    public static void main(String[] args)
    {
        int[] firstInput = {1, 2, 3, 4, 5};
        cyclicRotate(firstInput);
        System.out.println(Arrays.toString(firstInput));

        int[] secondInput = {9, 8, 7, 6, 4, 2, 1, 3};
        cyclicRotate(secondInput);
        System.out.println(Arrays.toString(secondInput));
    }

    private static void cyclicRotate(int[] input)
    {
        int end = input.length;
        for (int index = 0; index < end; index++)
        {
            swap(input, index, end - 1);
        }
    }

    private static void swap(int[] input, int indexOne, int indexTwo)
    {
        int temp = input[indexOne];
        input[indexOne] = input[indexTwo];
        input[indexTwo] = temp;
    }

}

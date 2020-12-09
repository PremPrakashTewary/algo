package com.general;

import java.util.Arrays;

/**
 * Move all negative numbers to beginning and positive to end with constant extra space
 *
 * An array contains both positive and negative numbers in random order.
 * Rearrange the array elements so that all negative numbers appear before all positive numbers.
 *
 * Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
 * Output: -12 -13 -5 -7 -3 -6 11 6 5
 */

public class MoveNegativeToStart
{
    public static void main(String[] args)
    {
        int[] input = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        moveNegativeToStart(input);
        System.out.println(Arrays.toString(input));
    }

    private static void moveNegativeToStart(int[] input)
    {
        int j = 0, temp;
        for (int i = 0; i < input.length; i++) {
            if (input[i] < 0) {
                if (i != j) {
                    temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
                j++;
            }
        }
    }


    private static void swap(int[] input, int indexOne, int indexTwo)
    {
        int temp = input[indexOne];
        input[indexOne] = input[indexTwo];
        input[indexTwo] = temp;
    }

}

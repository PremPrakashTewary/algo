package com.sorting.client;

import java.util.Arrays;

public class ZeroOneSorting
{
    public static void main(String[] args)
    {
        int INPUT[] = {1, 0, 0, 1, 1, 0, 0};
        int OUTPUT[] = {0, 0, 0, 0, 1, 1, 1};
        sortZeroOne(INPUT);
        if (Arrays.equals(INPUT, OUTPUT))
        {
            System.out.println("Zero One sorting success");
        }
        else
        {
            throw new RuntimeException("Zero One sorting wrong");
        }
    }

    private static void sortZeroOne(int[] input)
    {
        int start = 0;
        int end = input.length - 1;
        while (start <= end)
        {
            switch (input[end])
            {
                case 0:
                    int temp = input[start];
                    input[start] = input[end];
                    input[end] = temp;
                    start++;
                    break;
                case 1:
                    end--;
            }
        }
    }
}

package com.sorting.client;

import java.util.Arrays;

public class DutchFlagProblem
{
    public static void main(String[] args)
    {
        int[] INPUT = {2, 1, 0, 0, 2, 2, 1, 0, 0, 1, 2, 1};
        int[] OUTPUT = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2};
        solve(INPUT);
        System.out.println();
        if (Arrays.equals(INPUT, OUTPUT))
        {
            System.out.println("Dutch flag success");
        }
        else
        {
            throw new RuntimeException("Dutch flag wrong");
        }
    }

    private static void solve(int[] input)
    {
        int low = 0;
        int mid = 0;
        int high = input.length - 1;
        int temp = 0;
        while (mid <= high)
        {
            switch (input[mid])
            {
                case 0:
                    temp = input[low];
                    input[low] = input[mid];
                    input[mid] = temp;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = input[mid];
                    input[mid] = input[high];
                    input[high] = temp;
                    high--;
                    break;
            }
        }
    }
}

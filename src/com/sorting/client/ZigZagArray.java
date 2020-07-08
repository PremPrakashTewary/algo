package com.sorting.client;

import java.util.Arrays;

public class ZigZagArray
{
    public static void main(String[] args)
    {
        int INPUT[] = {4, 3, 7, 8, 6, 2, 1};
        int OUTPUT[] = {3, 7, 4, 8, 2, 6, 1};
        zizagEfficient(INPUT);
        if (Arrays.equals(INPUT, OUTPUT))
        {
            System.out.println(Arrays.toString(INPUT));
            System.out.println("zigzag sorting success");
        }
        else
        {
            System.out.println(Arrays.toString(INPUT));
            throw new RuntimeException("zigzag sorting wrong");
        }
    }

    private static void zizagEfficient(int[] arr)
    {
        boolean flag = true;

        int temp;

        for (int i=0; i<=arr.length-2; i++)
        {
            if (flag)  /* "<" relation expected */
            {
                /* If we have a situation like A > B > C,
                   we get A > B < C by swapping B and C */
                if (arr[i] > arr[i+1])
                {
                    // swap
                    temp  = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }

            }
            else /* ">" relation expected */
            {
                /* If we have a situation like A < B < C,
                   we get A < C > B by swapping B and C */
                if (arr[i] < arr[i+1])
                {
                    // swap
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            flag = !flag; /* flip flag */
        }
    }
}

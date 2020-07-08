package com.general;

import com.sorting.util.PrintUtil;

public class MoveZeroToEnd
{
    private static void moveZeroToEnd(int[] arr)
    {
        int len = arr.length;
        for (int i = 0; i < len; i++)
        {
            if (arr[i] == 0)
            {
                int nonZeroIndex = findNonZero(arr, i);
                if (nonZeroIndex != -1)
                {
                    int temp = arr[nonZeroIndex];
                    arr[nonZeroIndex] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    private static void moveZeroToEndFast(int[] arr)
    {
        int start = 0;
        for (int index = 0; index < arr.length; index++)
        {
            if (arr[index] != 0)
            {
                int temp = arr[start];
                arr[start] = arr[index];
                arr[index] = temp;
                start++;
            }
        }
    }

    private static int findNonZero(int[] arr, int curIndex)
    {
        int nonZeroIndex = -1;
        for (int i = curIndex + 1; i < arr.length; i++)
        {
            if (arr[i] != 0)
            {
                nonZeroIndex = i;
                break;
            }
        }
        return nonZeroIndex;
    }

    public static void main(String[] args)
    {
        int[] arr = {0, 1, 2, 0, 3, 0};
        moveZeroToEnd(arr);
        PrintUtil.printArray(arr);
    }
}

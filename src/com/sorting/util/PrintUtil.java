package com.sorting.util;

public final class PrintUtil
{
    private PrintUtil()
    {

    }

    public static void printArray(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " \t");
        }
        System.out.println();
    }
}

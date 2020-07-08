package com.sorting.client;

import com.sorting.SortType;
import com.sorting.context.SortContext;

import java.util.Arrays;

public class SortClient
{
    private static final int[] input = {12, 25, 64, 22, 11};

    private static final int[] expectedOutput = {11, 12, 22, 25, 64};

    public static void main(String[] args)
    {
        SortContext sortContext = new SortContext();
        sort(SortType.SELECTIONSORT, sortContext);
        sort(SortType.BUBBLESORT, sortContext);
        sort(SortType.ENHANCEDBUBBLESORT, sortContext);
        sort(SortType.INSERTIONSORT, sortContext);
        sort(SortType.QUICKSORT, sortContext);
        sort(SortType.HEAPSORT, sortContext);
        sort( SortType.COUNTINGSORT, sortContext );
    }

    private static void printMessage(int[] sortedResult, SortType sortType)
    {
        System.out.println();
        if (Arrays.equals(sortedResult, expectedOutput))
        {
            System.out.println("Sorting is correct for " + sortType);
        }
        else
        {
            throw new RuntimeException("Sorting is wrong for " + sortType);
        }
    }

    private static void sort(SortType sortType, SortContext sortContext)
    {
        int[] sortedResult = sortContext.sort(input, sortType);
        printMessage(sortedResult, sortType);
    }

}

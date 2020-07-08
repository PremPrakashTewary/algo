package com.sorting.impl;

import com.sorting.SortType;

public class SelectionSort extends AbstractSort
{

    public SelectionSort()
    {
        super(SortType.SELECTIONSORT);
    }

    @Override
    public int[] sortData(int[] input)
    {
        for (int i = 0; i < input.length; i++)
        {
            int minIndex = i;

            for (int j = i + 1; j < input.length; j++)
            {
                if (input[j] < input[minIndex])
                {
                    minIndex = j;
                }
            }
            int temp = input[minIndex];
            input[minIndex] = input[i];
            input[i] = temp;
        }
        return input;
    }
}

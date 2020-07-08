package com.sorting.impl;

import com.sorting.SortType;

public class InsertionSort extends AbstractSort
{

    public InsertionSort()
    {
        super(SortType.INSERTIONSORT);
    }

    @Override
    public int[] sortData(int[] input)
    {
        int len = input.length;
        for (int i = 1; i < len; i++)
        {
            int key = input[i];
            int j = i - 1;
            while (j >=0 && input[j] > key)
            {
                input[j + 1] = input[j];
                j--;
            }
            input[j + 1] = key;
        }
        return input;
    }
}

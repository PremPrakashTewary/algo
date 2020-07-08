package com.sorting.impl;

import com.sorting.SortType;

public class BubbleSort extends AbstractSort
{
    public BubbleSort()
    {
        super(SortType.BUBBLESORT);
    }

    @Override
    public int[] sortData(int[] input)
    {
        for (int i = 0; i < input.length - 1; i++)
        {
            for (int j = 0; j < input.length -i -1; j++)
            {
                if (input[j] > input[j+1])
                {
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }
        return input;
    }
}

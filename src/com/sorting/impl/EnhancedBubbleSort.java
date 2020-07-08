package com.sorting.impl;

import com.sorting.SortType;

public class EnhancedBubbleSort extends AbstractSort
{

    public EnhancedBubbleSort()
    {
        super(SortType.ENHANCEDBUBBLESORT);
    }

    @Override
    public int[] sortData(int[] input)
    {
        boolean swapped = false;
        for (int i = 0; i < input.length - 1; i++)
        {
            swapped = false;
            for (int j = 0; j < input.length -i -1; j++)
            {
                if (input[j] > input[j+1])
                {
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
            {
                break;
            }
        }
        return input;
    }
}

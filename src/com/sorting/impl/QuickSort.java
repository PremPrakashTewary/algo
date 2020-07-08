package com.sorting.impl;

import com.sorting.SortType;

public class QuickSort extends AbstractSort
{
    public QuickSort()
    {
        super(SortType.QUICKSORT);
    }


    @Override
    protected int[] sortData(int[] input)
    {
        sort(input, 0, input.length - 1);
        return input;
    }

    private void sort(int[] input, int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(input, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(input, low, pi - 1);
            sort(input, pi + 1, high);
        }
    }

    private int partition(int[] input, int low, int high)
    {
        int pivot = input[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (input[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = input[i + 1];
        input[i + 1] = input[high];
        input[high] = temp;

        return i + 1;
    }
}

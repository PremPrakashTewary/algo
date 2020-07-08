package com.sorting.impl;

import com.sorting.SortType;

public class HeapSort extends AbstractSort
{

    public HeapSort()
    {
        super(SortType.HEAPSORT);
    }

    @Override
    protected int[] sortData(int[] input)
    {
        int n = input.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
        {
            heapify(input, n, i);
        }

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = input[0];
            input[0] = input[i];
            input[i] = temp;

            // call max heapify on the reduced heap
            heapify(input, i, 0);
        }
        return input;
    }

    private void heapify(int[] arr, int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
        {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
        {
            largest = r;
        }

        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}

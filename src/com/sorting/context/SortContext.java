package com.sorting.context;

import com.sorting.SortType;
import com.sorting.factory.SortFactory;

public class SortContext
{
    private final SortFactory sortFactory;

    public SortContext()
    {
        this.sortFactory = new SortFactory();
    }

    public int[] sort(int[] input, SortType sortType)
    {
        int[] sortInput = new int[input.length];
        System.arraycopy(input, 0, sortInput, 0, input.length);
        sortInput = sortFactory.getSort(sortType).sort(sortInput);
        return sortInput;
    }
}

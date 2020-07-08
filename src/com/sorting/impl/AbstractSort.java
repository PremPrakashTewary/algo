package com.sorting.impl;

import com.sorting.Sort;
import com.sorting.SortType;
import com.sorting.util.PrintUtil;

public abstract class AbstractSort implements Sort
{
    private final SortType sortType;

    protected AbstractSort(SortType sortType)
    {
        this.sortType = sortType;
    }

    @Override
    public int[] sort(int[] input)
    {
        long startTime = System.currentTimeMillis();
        int[] sorted = sortData(input);
        System.out.println("-------- Time taken for sorting using sort type " + sortType + " --------- " + (System.currentTimeMillis() - startTime));
        System.out.println("-------------- " + sortType + " RESULT PRINT --------------------");
        PrintUtil.printArray(sorted);
        return sorted;
    }

    protected abstract int[] sortData(int[] input);
}

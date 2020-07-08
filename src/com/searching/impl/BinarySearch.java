package com.searching.impl;

import com.searching.SearchType;
import com.sorting.SortType;
import com.sorting.context.SortContext;

public class BinarySearch extends AbstractSearch
{
    private static final SortContext SORT_CONTEXT = new SortContext();

    public BinarySearch()
    {
        super(SearchType.BINARYSEARCH);
    }

    @Override
    protected int searchInput(int[] input, int search)
    {
        int[] sortedInput = SORT_CONTEXT.sort(input, SortType.HEAPSORT);
        int l = 0;
        int u = sortedInput.length - 1;
        int m;
        while (l <= u)
        {
            m = l + u / 2;
            if (sortedInput[m] < search)
            {
                l = m + 1;
            }
            else if (sortedInput[m] == search)
            {
                return m;
            }
            else
            {
                l = m -1;
            }
        }
        return -1;
    }
}

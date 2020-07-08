package com.searching.impl;

import com.searching.Search;
import com.searching.SearchType;

public abstract class AbstractSearch implements Search
{
    private final SearchType searchType;

    protected AbstractSearch(SearchType searchType)
    {
        this.searchType = searchType;
    }

    @Override
    public int search(int[] input, int search)
    {
        long startTime = System.currentTimeMillis();
        int[] sortedInput = input;
        int result = searchInput(sortedInput, search);
        System.out.println("-------- Time taken for searching " +search+ " using search type " + searchType + " --------- " + (System.currentTimeMillis() - startTime));
        System.out.println("-------------- " + searchType + " RESULT PRINT --------------------");
        return result;
    }

    protected abstract int searchInput(int[] input, int search);
}

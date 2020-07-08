package com.searching.context;

import com.searching.SearchType;
import com.searching.factory.SearchFactory;

public class SearchContext
{
    private final static SearchFactory SEARCH_FACTORY = new SearchFactory();

    public int search(int[] input, int search, SearchType searchType)
    {
        return SEARCH_FACTORY.getSearch(searchType).search(input, search);
    }
}

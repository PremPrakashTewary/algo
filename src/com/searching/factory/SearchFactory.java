package com.searching.factory;

import com.searching.Search;
import com.searching.SearchType;
import com.searching.impl.BinarySearch;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SearchFactory
{
    private static final Map<SearchType, Optional<Search>> SEARCH_MAP = new HashMap<>();

    public SearchFactory()
    {
        SEARCH_MAP.put(SearchType.BINARYSEARCH, Optional.of(new BinarySearch()));
    }

    public Search getSearch(SearchType searchType)
    {
        return SEARCH_MAP.get(searchType).orElseThrow(() ->
            new RuntimeException("No search defined for type " + searchType)
        );
    }
}

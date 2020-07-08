package com.sorting.factory;

import com.sorting.Sort;
import com.sorting.SortType;
import com.sorting.impl.BubbleSort;
import com.sorting.impl.CountingSort;
import com.sorting.impl.EnhancedBubbleSort;
import com.sorting.impl.HeapSort;
import com.sorting.impl.InsertionSort;
import com.sorting.impl.QuickSort;
import com.sorting.impl.SelectionSort;

import java.util.HashMap;
import java.util.Map;

public class SortFactory
{
    private Map<SortType, Sort> sortTypeSortMap = new HashMap<>();

    public SortFactory()
    {
        sortTypeSortMap.put(SortType.SELECTIONSORT, new SelectionSort());
        sortTypeSortMap.put(SortType.BUBBLESORT, new BubbleSort());
        sortTypeSortMap.put(SortType.ENHANCEDBUBBLESORT, new EnhancedBubbleSort());
        sortTypeSortMap.put(SortType.INSERTIONSORT, new InsertionSort());
        sortTypeSortMap.put(SortType.QUICKSORT, new QuickSort());
        sortTypeSortMap.put(SortType.HEAPSORT, new HeapSort());
        sortTypeSortMap.put( SortType.COUNTINGSORT, new CountingSort() );
    }

    public Sort getSort(SortType sortType)
    {
        Sort sort = sortTypeSortMap.get(sortType);
        if (null == sort)
        {
            throw new RuntimeException("Not Sort defined for " + sortType);
        }
        return sort;
    }
}

package com.sorting.impl;

import com.sorting.SortType;

public class CountingSort extends AbstractSort
{

    public CountingSort()
    {
        super( SortType.COUNTINGSORT );
    }

    @Override
    protected int[] sortData(int[] input)
    {
        int[] potions = new int[ input.length ];
        int[] output = new int[ input.length ];
        for ( int i = 0; i < input.length; i++ )
        {
            for ( int j = i + 1; j < input.length; j++ )
            {
                if ( input[ i ] < input[ j ] )
                {
                    potions[ j ] = potions[ j ] + 1;
                }
                else
                {
                    potions[ i ] = potions[ i ] + 1;
                }
            }
        }
        for ( int i = 0; i < input.length; i++ )
        {
            output[ potions[ i ] ] = input[ i ];
        }
        return output;
    }
}

package com.general;

import java.util.ArrayList;
import java.util.List;

/**
 * The input list contains many numbers. You are required to process this list and update the list based on the
 * following rules:
 * 1) If a number is smaller than its preceding number and the number immediately following, then remove the
 * number from the list.
 * 2) Retain all other numbers that do not fall in the above category
 * 3) Retain the first and the last number of the list
 */
public class NumberList
{
    private static void updateList(List<Integer> list)
    {
        if ( list != null )
        {
            int idx = updateListUtil( list );
            while ( idx != -1 )
            {
                list.remove( idx );
                idx = updateListUtil( list );
            }
        }
    }

    private static int updateListUtil(List<Integer> list)
    {
        for ( int i = 1; i < list.size() - 1; i++ )
        {
            int prev = list.get( i - 1 );
            int cur = list.get( i );
            int next = list.get( i + 1 );
            if ( cur < prev && cur < next )
            {
                return i;
            }
        }
        return -1;
    }

    public static void main( String[] args )
    {
        List<Integer> input = new ArrayList<>();
        input.add( 10 );
        input.add( 20 );
        input.add( 5 );
        input.add( 30 );
        input.add( 4 );
        input.add( 20 );
        input.add( 60 );
        updateList( input );
        System.out.println( "Updated List is " + input );

        input = new ArrayList<>();
        input.add( 40 );
        input.add( 8 );
        input.add( 6 );
        input.add( 22 );
        input.add( 9 );
        input.add( 7 );
        input.add( 50 );
        updateList( input );
        System.out.println( "Updated List is " + input );
    }
}

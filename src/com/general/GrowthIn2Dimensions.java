package com.general;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Start with an infinite two dimensional grid filled with zeros, indexed from (1,1) at the bottom left corner.
 * Given a series of coordinates (i, j), add 1 to each element in the range from (1,1) to (i,j). Once you have
 * processed all coordinates, determine how many cells contain the maximal value in the grid.
 * For example, upRight = [(1,4), (2,3), (4,1)]. The following diagrams show each iteration starting at zero.
 * The maximal value in the grid is 3, and there is 1 occurrence at cell (1, 1).
 */
public class GrowthIn2Dimensions
{
    private static long countMax(List<String> upRight)
    {
        Map<Long, Integer> map = new TreeMap<>( Collections.reverseOrder() );
        Map<String, Long> storeMap = new HashMap<>();

        for ( String str: upRight )
        {
            String[] split = str.split( " " );
            int up = Integer.parseInt( split[0] );
            int right = Integer.parseInt ( split[1] );
            for ( int i = 0; i < up; i++ )
            {
                for ( int j = 0; j < right; j++ )
                {
                    String key = i + "_" + j;
                    Long storeValue = storeMap.getOrDefault( key, 0L );
                    storeValue = storeValue + 1;
                    storeMap.put( key, storeValue );
                    updateMap( map, storeValue );
                }

            }
        }
        return map.entrySet().iterator().next().getValue();
    }

    private static void updateMap( Map<Long, Integer> map, long key )
    {
        Integer value = map.getOrDefault( key, 0 );
        map.put( key, value +1 );
    }

    public static void main( String[] args )
    {
        List<String> upRight = List.of( "1 4", "2 3", "4 1" );
        System.out.println( countMax( upRight ) );

        upRight = List.of( "2 3", "3 7", "4 1" );
        System.out.println( countMax( upRight ) );
    }
}

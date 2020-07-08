package com.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindBiggestNo
{
    private static String largest(List<String> number)
    {
        Collections.sort(number, new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                String o1o2 = o1 + o2;
                String o2o1 = o2 + o1;
                return o1o2.compareTo( o2o1 ) > 0 ? -1 : 1;
            }
        });
        return number.stream().collect(Collectors.joining(""));
    }

    public static void main(String[] args)
    {
        List<String> numbers = new ArrayList<>();
        numbers.add( "3" );
        numbers.add( "30" );
        numbers.add( "34" );
        numbers.add( "5" );
        numbers.add( "9" );

        System.out.println(largest(numbers));
    }
}

package com.general;

public class OddElement
{
    private static void findOdd(int[] arr)
    {
        int result = -1;
        for ( int i = 0; i < arr.length - 1; i++ )
        {
            result = arr[ i ] ^ arr[ i + 1 ];
        }
        System.out.println( "Result " + result );
    }

    public static void main( String[] args )
    {
        int[] arr = {-10, 8, -9, -10, 11, 8, 11, -9, 11};
        findOdd( arr );
    }
}

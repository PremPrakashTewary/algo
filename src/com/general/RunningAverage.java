package com.general;

public class RunningAverage
{
    private static void runningAverage(int[] arr, int k)
    {
        if ( k > arr.length )
        {
            throw new IllegalArgumentException( "K greater than " + arr.length );
        }
        float sum = 0;
        int i = 0;
        int j = 0;
        for ( i = 0; i < k; i++ )
        {
            sum = sum + arr[ i ];
        }
        System.out.println( "Print average " + ( sum/k ) );
        while ( i < arr.length )
        {
            sum = sum - arr[ j ] + arr [ i ];
            System.out.println( "Print average " + ( sum/k ) );
            j = j + 1;
            i = i + 1;
        }
    }

    public static void main( String[] args )
    {
        int[] input = { 2, 10, 4, 20, 8, 4 };
        //6, 7, 12, 14, 6
        runningAverage( input, 2 );
        System.out.println( "-------Break--------" );
        //5.33333, 11.33333, 10.66667, 10.666667
        runningAverage( input, 3 );

        System.out.println( "-------Break--------" );
        //9, 10.5, 9
        runningAverage( input, 4 );

        System.out.println( "-------Break--------" );
        //8.8, 9.2
        runningAverage( input, 5 );

        System.out.println( "-------Break--------" );
        //8
        runningAverage( input, 6 );
    }
}

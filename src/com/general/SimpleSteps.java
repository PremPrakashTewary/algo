package com.general;

/**
 * You have staircase of n steps. You can take only following steps
 * 1. Either take one step or take 2 steps. Count the number of ways to reach to top
 */
public class SimpleSteps
{
    /**
     * The relationship is f(n) = f(n-1) + f(n-2)
     * @param n
     * @return
     */
    private static int recursiveSolution(int n)
    {
        if ( n == 0 || n == 1 )
        {
            return 1;
        }
        return recursiveSolution( n-1 ) + recursiveSolution( n-2 );
    }

    private static int dynamicSolution(int n)
    {
        if ( n == 0 || n == 1 )
        {
            return 1;
        }
        int[] arr = new int[ n + 1 ];
        arr[0] = 1;
        arr[1] = 1;
        for ( int i = 2; i <= n; i++ )
        {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    public static void main( String[] args )
    {
        System.out.println( "No of ways " + recursiveSolution( 6 ) );
        System.out.println( "No of ways " + dynamicSolution( 6 ) );
    }
}

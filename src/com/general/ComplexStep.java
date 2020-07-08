package com.general;

/**
 * You have staircase of n steps. You can take only following steps provided as input array
 * Count the number of ways to reach to top
 */
public class ComplexStep
{
    private static int recursiveSolution(int n, int[] steps)
    {
        if ( n == 0 )
        {
            return 1;
        }
        int total = 0;
        for ( int step: steps )
        {
            if ( n - step >= 0 )
            {
                total = total + recursiveSolution( n- step, steps );
            }
        }
        return total;
    }

    private static int dynamicSolution(int n, int[] steps)
    {
        if ( n == 0 )
        {
            return 1;
        }
        int[] temp = new int[n+1];
        temp[0] = 1;
        for ( int i = 1; i <=n; i++ )
        {
            int total = 0;
            for ( int step: steps )
            {
                if ( i - step >= 0 )
                {
                    total = total + temp[ i - step ];
                }
            }
            temp[i] = total;
        }
        return temp[n];
    }

    public static void main( String[] args )
    {
        int[] steps = {1, 3, 5};
        System.out.println( "Complex ways " + recursiveSolution( 4, steps ) );
        System.out.println( "Complex ways " + dynamicSolution( 4, steps ) );
    }
}

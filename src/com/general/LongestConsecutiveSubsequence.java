package com.general;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence
{
    static int findLongestConseqSubseq(int arr[])
    {
        int n = arr.length;
        Set<Integer> S = new HashSet<>();
        int ans = 0;
        for ( int i = 0; i < n; i++ )
        {
            S.add( arr[i] );
        }
        for ( int i = 0; i< n; i++ )
        {
            if ( !S.contains( arr[i] - 1 ) )
            {
                int j = arr[i];
                while ( S.contains( j ) )
                {
                    j++;
                }
                if ( ans < j - arr[i] )
                {
                    ans = j - arr[i];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int arr[] =  {1, 9, 3, 10, 4, 20, 2};
        System.out.println("Length of the Longest consecutive subsequence is " +
            findLongestConseqSubseq( arr ));
    }
}

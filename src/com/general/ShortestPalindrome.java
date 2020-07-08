package com.general;

/**
 * A palindrome is defined as a word that reads the same forward as it does backward. For example, the
 * word "tacocat" is a palindrome, but the words "taco" and "cat" are not. Determine the minimum number of
 * characters that must be inserted into a string to make it a palindrome.
 */
public class ShortestPalindrome
{

    /**
     * Let the input string be str[l……h]. The problem can be broken down into three parts:
     *
     * Find the minimum number of insertions in the substring str[l+1,…….h].
     * Find the minimum number of insertions in the substring str[l…….h-1].
     * Find the minimum number of insertions in the substring str[l+1……h-1].
     *
     * Recursive Approach: The minimum number of insertions in the string str[l…..h] can be given as:
     *
     * minInsertions(str[l+1…..h-1]) if str[l] is equal to str[h]
     * min(minInsertions(str[l…..h-1]), minInsertions(str[l+1…..h])) + 1 otherwise
     *
     * @param input
     * @param start
     * @param end
     * @return
     */
    private static int findMinInsertions(char[] input, int start, int end)
    {
        //Base Cases
        if ( start > end )
        {
            return Integer.MAX_VALUE;
        }
        if ( start == end )
        {
            return 0;
        }
        if ( start == end - 1 )
        {
            return input[start] == input[end] ? 0 : 1;
        }

        // Check if the first and last characters
        // are same. On the basis of the  comparison
        // result, decide which subrpoblem(s) to call
        return ( input[start] == input[end] ) ?
            findMinInsertions( input, start + 1, end - 1 ) :
            (Integer.min( findMinInsertions( input, start, end - 1 ),
                findMinInsertions( input, start + 1, end ) ) + 1 );
    }

    private static int shortestPalindrome(String input)
    {
        return findMinInsertions( input.toCharArray(), 0 , input.length() - 1 );
    }

    private static int findMinInsertionsDP(char str[])
    {
        // Create a table of size n*n. table[i][j]
        // will store minumum number of insertions
        // needed to convert str[i..j] to a palindrome.
        int n = str.length;
        int table[][] = new int[n][n];
        int l, h, gap;

        // Fill the table
        for (gap = 1; gap < n; ++gap)
            for (l = 0, h = gap; h < n; ++l, ++h)
                table[l][h] = (str[l] == str[h])?
                    table[l+1][h-1] :
                    (Integer.min(table[l][h-1],
                        table[l+1][h]) + 1);

        // Return minimum number of insertions
        // for str[0..n-1]
        return table[0][n-1];
    }

    public static void main( String[] args )
    {
        System.out.println( shortestPalindrome( "JAVA" ) );
        System.out.println( findMinInsertionsDP( "JAVA".toCharArray() ) );
    }
}

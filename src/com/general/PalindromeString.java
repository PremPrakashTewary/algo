package com.general;

/**
 * Given a string, check if it is a palindrome by ignoring spaces.
 * E.g. race car would be a palindrome.
 */
public class PalindromeString
{
    private static boolean palindrome(String input)
    {
        int start = 0;
        int end = input.length() - 1;
        input = input.toLowerCase();
        while ( start <= end )
        {
            char startChar = input.charAt( start );
            char endChar = input.charAt( end );

            if ( !( startChar >= 'a' && startChar <= 'z' ) )
            {
                start++;
            }
            else if ( !( endChar >= 'a' && endChar <= 'z' ) )
            {
                end--;
            }
            else if ( startChar == endChar )
            {
                start++;
                end--;
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    public static void main( String[] args )
    {
        System.out.println( palindrome( "race car" ) );
    }
}

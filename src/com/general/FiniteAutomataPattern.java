package com.general;

public class FiniteAutomataPattern
{
    private static void search(String input, String pattern)
    {
        int index = input.indexOf( pattern );
        while ( index >= 0 )
        {
            System.out.println( "Pattern found at index " + index );
            index = input.indexOf( pattern, index + pattern.length() );
        }
    }

    public static void main(String[] args)
    {
        search( "AABAACAADAABAAABAA", "AABA" );
    }
}

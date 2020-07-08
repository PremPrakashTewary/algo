package com.general;

/**
 * Check if edit distance between two strings is one
 * An edit between two strings is one of the following changes.
 *
 * Add a character
 * Delete a character
 * Change a character
 * Given two string s1 and s2, find if s1 can be converted to s2 with exactly one edit.
 * Expected time complexity is O(m+n) where m and n are lengths of two strings.
 * Examples:
 * Input:  s1 = "geeks", s2 = "geek"
 * Output: yes
 * Number of edits is 1
 *
 * Input:  s1 = "geeks", s2 = "geeks"
 * Output: no
 * Number of edits is 0
 *
 * Input:  s1 = "geaks", s2 = "geeks"
 * Output: yes
 * Number of edits is 1
 *
 * Input:  s1 = "peaks", s2 = "geeks"
 * Output: no
 * Number of edits is 2
 */
public class EditDistanceOne
{
    private static boolean checkEditDistanceOne(String s1, String s2)
    {
        int n = s1.length();
        int m = s2.length();
        if ( Math.abs( n - m ) > 1 )
        {
            return false;
        }

        int minLen = Math.min( n, m );
        int diffCount = 0;
        int i = 0;
        while ( i < minLen )
        {
            if ( s1.charAt( i ) != s2.charAt( i ) )
            {
                diffCount++;
            }
            i++;
        }
        if ( i < n || i < m )
        {
            diffCount++;
        }
        return diffCount == 1;
    }

    public static void main( String[] args )
    {
        //Test s1 is smaller than s2 by one
        String s1 = "geeks";
        String s2 = "geek";
        System.out.println("------First String smaller than Second String");
        print( s1, s2 );
        System.out.println("------First String smaller than Second String");

        //Test s1 is larger than s2 by one
        s1 = "geek";
        s2 = "geeks";
        System.out.println("------First String larger than Second String");
        print( s1, s2 );
        System.out.println("------First String larger than Second String");

        //Same length same string
        s1 = "geeks";
        s2 = "geeks";
        System.out.println("------Same String");
        print( s1, s2 );
        System.out.println("------Same String");

        //Same length different string
        s1 = "geeks";
        s2 = "geaks";
        System.out.println("------Same String");
        print( s1, s2 );
        System.out.println("------Same String");

        //Length difference more than one
        s1 = "geeksss";
        s2 = "geaks";
        System.out.println("------Length difference more than one");
        print( s1, s2 );
        System.out.println("------Length difference more than one");
    }

    private static void print(String s1, String s2)
    {
        if ( checkEditDistanceOne( s1, s2 ) )
        {
            System.out.println("yes");
        }
        else
        {
            System.out.println("no");
        }
    }
}

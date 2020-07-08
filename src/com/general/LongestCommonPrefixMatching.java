package com.general;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a set of strings, find the longest common prefix.
 *
 * Examples:
 *
 * Input: str[] = {geeksforgeeks, geeks, geek, geezer}
 * Output: gee
 *
 * Input: str[] = {apple, ape, april}
 * Output: ap
 */
public class LongestCommonPrefixMatching
{
    private static String commonPrefixUtil(String str1, String str2)
    {
        Queue<Integer> q = new LinkedList<>();
        q.isEmpty();
        StringBuilder sb = new StringBuilder();
        for ( int i = 0, j = 0; i < str1.length() && j < str2.length(); i++, j++)
        {
            if ( str1.charAt( i ) != str2.charAt( j ) )
            {
                break;
            }
            sb.append( str1.charAt( i ) );
        }
        return sb.toString();
    }

    private static void commonPrefix(String[] input)
    {
        Arrays.sort( input );
        int n = input.length;
        System.out.println( commonPrefixUtil( input[0], input[n - 1] ) );
    }

    public static void main(String[] args)
    {
        String arr[] = {"geeksforgeeks", "geeks",
            "geek", "geezer"};

        commonPrefix(arr);

    }
}

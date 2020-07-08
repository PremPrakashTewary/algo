package com.general;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Rearrange a string in sorted order followed by the integer sum
 * Given a string containing uppercase alphabets and integer digits (from 0 to 9),
 * the task is to print the alphabets in the order followed by the sum of digits.
 *
 * Example
 * Input : AC2BEW3
 * Output : ABCEW5
 * Alphabets in the lexicographic order
 * followed by the sum of integers(2 and 3).
 */
public class StringSortedOrderFollwedBySum
{
    private static String arrangeString(String input)
    {
        int sum = 0;
        Queue<Character> priorityQueue = new PriorityQueue<>( input.length() );
        int length = input.length();
        for ( int i = 0; i < length; i++ )
        {
            if ( Character.isAlphabetic( input.charAt( i ) ) )
            {
                priorityQueue.add( input.charAt( i ) );
            }
            else
            {
                sum = sum + (input.charAt(i)-'0');
            }
        }
        StringBuilder sb = new StringBuilder();
        while ( !priorityQueue.isEmpty() )
        {
            sb.append( priorityQueue.poll() );
        }
        sb.append( sum );
        System.out.println( "The output is " + sb );
        return sb.toString();
    }

    public static void main( String[] args )
    {
        Assert.assertThat( arrangeString( "AC2BEW3" ), CoreMatchers.equalTo( "ABCEW5" ) );
        Assert.assertThat( arrangeString( "ACCBA10D2EW30" ), CoreMatchers.equalTo( "AABCCDEW6" ) );
    }
}

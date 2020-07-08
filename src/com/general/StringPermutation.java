package com.general;

public class StringPermutation
{
    private static void permute(String str, int start, int end)
    {
        if (start == end)
        {
            System.out.println( str );
        }
        else
        {
            for (int i = start; i <= end; i++)
            {
                str = swap(str,start,i);
                permute(str, start+1, end);
                str = swap(str,start,i);
            }
        }
    }

    private static String swap(String s, int pos1, int pos2)
    {
        char temp;
        char[] charArray = s.toCharArray();
        temp = charArray[pos1] ;
        charArray[pos1] = charArray[pos2];
        charArray[pos2] = temp;
        return String.valueOf(charArray);
    }

    public static void main( String[] args )
    {
        permute( "ABC", 0, "ABC".length() - 1 );
    }
}

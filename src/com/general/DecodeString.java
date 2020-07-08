package com.general;

/**
 * Suppose we have representation as 'a' -> 1, 'b' -> 2 ... till 'z' -> 26.
 * Identify the no of message that can be decoded with input.
 * For example if input is "12", max number of messages are 2 ('ab','l')
 */
public class DecodeString
{
    private static int decodeHelper(String encodedMessage, int k)
    {
        if ( k == 0 )
        {
            return 1;
        }
        int s = encodedMessage.length() - k;
        if ( encodedMessage.charAt( s ) == '0' )
        {
            return 0;
        }
        int result = decodeHelper( encodedMessage, k -1 );
        if ( k >= 2 && Integer.parseInt( encodedMessage.substring( s, s + 2 ) ) <= 26  )
        {
            result = result + decodeHelper( encodedMessage, k - 2 );
        }
        return result;
    }

    private static int totalDecodedMessage(String encodedMessage)
    {
        return decodeHelper( encodedMessage, encodedMessage.length() );
    }

    private static int decodeHelperDP(String encodedMessage, int k, Integer[] member)
    {
        if ( k == 0 )
        {
            return 1;
        }
        int s = encodedMessage.length() - k;
        if ( encodedMessage.charAt( s ) == '0' )
        {
            return 0;
        }
        if ( member[k] != null )
        {
            return member[k];
        }
        int result = decodeHelperDP( encodedMessage, k -1, member );
        if ( k >= 2 && Integer.parseInt( encodedMessage.substring( s, s + 2 ) ) <= 26  )
        {
            result = result + decodeHelperDP( encodedMessage, k - 2, member );
        }
        member[k] = result;
        return result;
    }

    private static int totalDecodedMessageDP(String encodedMessage)
    {
        Integer[] member = new Integer[ encodedMessage.length() + 1 ];
        return decodeHelperDP( encodedMessage, encodedMessage.length(), member );
    }

    public static void main( String[] args )
    {
        System.out.println( "Number " + totalDecodedMessage( "127" ) );
        System.out.println( "DP " + totalDecodedMessageDP( "127" ) );
    }
}

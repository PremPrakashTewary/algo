package com.general;

/**
 * there’s some function that can “compress” strings like FACEBOOK -> F6K or FACEBOOK -> F2E2OK or INTERNATIONALIZATION -> I18N.
 * The compression mechanism can delete arbitrarily many characters and replace them with the deleted character count.
 * Write a function that takes a compressed string and a plaintext string and determines if the compressed string is valid
 * for the plaintext string.
 */
public class CompressionString
{
    private static boolean isCompressed(String plainText, String compressed)
    {
        int start = 0;
        int count = 0;
        String num = "";
        int length = plainText.length();
        /*if ( plainText.charAt( 0 ) == compressed.charAt( 0 ) )
        {*/
            while ( start < compressed.length() )
            {
                Character ch = compressed.charAt( start );
                if ( Character.isAlphabetic( ch ) )
                {
                    if ( count < length )
                    {
                        if ( num != "" )
                        {
                            int jump = Integer.parseInt( num );
                            count = count + jump;
                            num = "";
                        }
                        if ( ch != plainText.charAt( count ) )
                        {
                            return false;
                        }
                        count++;
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    num = num + Character.getNumericValue( ch );
                }
                start++;
            }
        //}
        return count == length;
    }

    public static void main( String[] args )
    {
        System.out.println( "isCompressed = " + isCompressed( "FACEBOOK", "FA4OK" ) );
        System.out.println( "isCompressed = " + isCompressed( "FACEBOOK", "F2E2OK" ) );
        System.out.println( "isCompressed = " + isCompressed( "INTERNATIONALIZATION", "I18N" ) );
        System.out.println( "isCompressed = " + isCompressed( "FACEBOOK", "F2F2OK" ) );
        System.out.println( "isCompressed = " + isCompressed( "FACEBOOK", "F2E2OK" ) );
    }
}

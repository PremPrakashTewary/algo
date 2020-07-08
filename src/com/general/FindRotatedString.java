package com.general;

public class FindRotatedString
{
    private static boolean checkRotatedOrNot(String original, String rotated)
    {
        String newRotated = rotated.concat( rotated );
        return newRotated.indexOf( original ) > 0;
    }

    public static void main( String[] args )
    {
        String one = "car";
        String two = "arc";
        System.out.println( checkRotatedOrNot( one, two ));
    }
}

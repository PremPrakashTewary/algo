package com.general;

public class OccurenceX
{
    private static int getOccurence(int start, int end, int d)
    {
        int result = 0;
        int itr = start + 1;
        while (itr < end)
        {

            // When the last digit is
            // equal to d
            if (itr % 10 == d)
                result++;

            // When the first digit is
            // equal to d then
            if (itr != 0 && itr/10 == d)
            {

                // increment result as
                // well as number
                result++;
                itr++;
            }

            // In case of reverse of number
            // such as 12 and 21
            else if (itr/10 == d-1)
                itr = itr + (10 - d);
            else
                itr = itr + 10;
        }
        return result;
    }

    public static void main(String[] args)
    {
        System.out.println(getOccurence(29, 50, 3));
    }
}

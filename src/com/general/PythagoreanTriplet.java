package com.general;

import java.util.Arrays;

public class PythagoreanTriplet
{
    private static boolean isTriplet(int arr[])
    {
        int n = arr.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++)
        {
            newArr[i] = arr[i] * arr[i];
        }
        Arrays.sort(newArr);
        for (int i = n - 1; i >= 2; i--)
        {
            int l = 0;
            int r = i - 1;
            while (l < r)
            {
                if (newArr[l] + newArr[r] == newArr[i])
                {
                    return true;
                }
                if (newArr[l] + newArr[r] < newArr[i])
                {
                    l++;
                } else
                {
                    r--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        int arr[] = {3, 1, 4, 6, 5};
        if (isTriplet(arr) == true)
        {
            System.out.println("Yes");
        } else
        {
            System.out.println("No");
        }
    }
}

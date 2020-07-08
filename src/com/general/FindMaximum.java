package com.general;

import java.util.Scanner;

public class FindMaximum
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int tectCases = scanner.nextInt();
        for (int i = 0 ; i < tectCases; i++)
        {
            int len = scanner.nextInt();
            int[] arr = new int[len];
            for (int j = 0; j < len; j++)
            {
                arr[j] = scanner.nextInt();
            }
            System.out.println(maxIndexDiff(arr, len));
        }
    }

    /* Utility Functions to get max and minimum of two integers */
    private static int max(int x, int y)
    {
        return x > y ? x : y;
    }

    private static int min(int x, int y)
    {
        return x < y ? x : y;
    }

    /* For a given array arr[], returns the maximum j-i such that
       arr[j] > arr[i] */
    private static int maxIndexDiff(int arr[], int n)
    {
        int maxDiff;
        int i, j;

        int RMax[] = new int[n];
        int LMin[] = new int[n];

        /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = arr[0];
        for (i = 1; i < n; ++i)
            LMin[i] = min(arr[i], LMin[i - 1]);

        /* Construct RMax[] such that RMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n - 1] = arr[n - 1];
        for (j = n - 2; j >= 0; --j)
            RMax[j] = max(arr[j], RMax[j + 1]);

        /* Traverse both arrays from left to right to find optimum j - i
           This process is similar to merge() of MergeSort */
        i = 0; j = 0; maxDiff = -1;
        while (j < n && i < n)
        {
            if (LMin[i] < RMax[j])
            {
                maxDiff = max(maxDiff, j - i);
                j = j + 1;
            }
            else
                i = i + 1;
        }

        return maxDiff;
    }
}

package com.general;

import java.util.Arrays;

/**
 * Write a method that takes a sorted array A of integers and a key k and returns the index of first occurrence of k in A.
 * Return -1 if k does not appear in A.
 * A[] = {1, 1, 2, 4, 10, 20}, K = 1, then answer is 0
 */
public class SearchSortedArrayForK
{
    // Do binary search. When found index having K, traverse back till we don't find index with value k.
    // Return just before index
    private static int simpleSolution(int[] arr, int k)
    {
        long startTime = System.currentTimeMillis();
        int found = -1;
        int start = 0;
        int end = arr.length;
        found = binarySearch( arr, start, end, k );
        if (found != -1)
        {
            for (int i = found - 1; i > 0; i--)
            {
                if (arr[i] == k)
                {
                    found = i;
                }
                else
                {
                    break;
                }
            }
        }
        System.out.println("Time taken for simple is " + (System.currentTimeMillis() - startTime));
        return found;
    }

    //Do binary search. When found index having K, look index -1 is having K or not.
    // If having K again do binary search till we find solution
    private static int efficientSearch(int arr[], int k)
    {
        long startTime = System.currentTimeMillis();
        int found = -1;
        int start = 0;
        int end = arr.length;
        found = binarySearch( arr, start, end, k );
        if (found != -1)
        {
            while (found >= 1 && arr[found-1] == k)
            {
                found = binarySearch(arr, start, found-1, k);
            }
        }
        System.out.println("Time taken for efficientSearch is " + (System.currentTimeMillis() - startTime));
        return found;
    }

    private static int binarySearch(int arr[], int start, int end, int k)
    {
        int mid = ( start + end )/2;
        if (arr[mid] == k)
        {
            return mid;
        }
        else if (arr[mid] > k )
        {
            return binarySearch(arr, start, mid-1, k);
        }
        else
        {
            return binarySearch(arr, mid+1, end, k);
        }
    }

    public static void main(String[] args)
    {
        int arr[] = new int[1000];
        int j = 0;
        for (int i = 0; i < 1000; i++)
        {
            arr[i] = j;
            j = j + 2;
            if (i % 100 == 0 )
            {
                j = 0;
            }
        }
        System.out.println( simpleSolution( arr, 60 ) );
        System.out.println( efficientSearch( arr, 60 ) );
    }
}

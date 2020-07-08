package com.general;

/**
 * Search in sorted array X for index i such that X[i] = i
 * A[] = {-3, -1, 0, 3, 5, 7}. Answer is 3
 */
public class SearchIndexWhereValueSameAsIndex
{
    private static int findIndexHavingValueAsIndex(int[] arr)
    {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < newArr.length; i++)
        {
            newArr[i] = arr[i] - i;
        }
        return interpolationSearch(newArr, 0);
    }

    private static int interpolationSearch(int arr[], int k)
    {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo<=hi && k>=arr[lo] && k<=arr[hi])
        {
            if (lo == hi)
            {
                if (arr[lo] == k)
                {
                    return lo;
                }
                return -1;
            }
            int pos = lo + (((hi-lo) / (arr[hi]-arr[lo]))*(k - arr[lo]));

            if (arr[pos] == k)
            {
                return pos;
            }
            if (arr[pos] < k)
            {
                lo = pos + 1;
            }
            else
            {
                hi = pos - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] arr = {-3, -1, 0, 3, 5, 7};
        System.out.println(findIndexHavingValueAsIndex(arr));
    }
}

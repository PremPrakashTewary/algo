package com.general;

/**
 * Design efficient algorithm to find index of first occurrence an element is larger than a specified key k in sorted array.
 * Return -1 if all the elements are less than or equal to k
 * A[] = {1, 2, 4, 10, 16, 22, 44, 48} k = 40 output is 5 (22)
 * A[] = {1, 2, 4, 10, 16, 22, 44, 48} k = 3 output is 2 (4)
 */
public class SearchSortedArrayLargerThanK
{
    private static int simpleFind(int[] arr, int k)
    {
        int start = 0;
        int end = arr.length - 1;
        if (arr[end] <= k)
        {
            return -1;
        }
        if (arr[start] == k)
        {
            return -1;
        }
        int index = -1;
        int mid = (start + end) / 2;
        if (arr[mid] == k)
        {
            index = mid + 1;
        } else if (arr[mid] < k)
        {
            // move from mid to end increment mid by 1
            index = mid;
            boolean found = false;
            for (int i = mid + 1; i <= end; i++)
            {
                if (arr[i] > k)
                {
                    index = i;
                    found = true;
                }
                if (found)
                {
                    break;
                }
            }
        } else
        {
            // move from mid to start decrement mid by 1
            index = mid;
            for (int i = mid - 1; i >= 0; i--)
            {
                if (arr[i] > k)
                {
                    index = i;
                }
            }
        }
        return index;
    }

    private static int efficientSearch(int[] arr, int k)
    {
        int start = 0;
        int end = arr.length;
        if (arr[end - 1] <= k)
        {
            return -1;
        }
        if (arr[start] == k)
        {
            return -1;
        }
        int mid = -1;
        boolean flag = false;
        while (start<end)
        {
            mid = (start+end)/2;
            if (arr[mid] == k)
            {
                flag = true;
                break;
            }
            else if (arr[mid] < k)
            {
                start = mid+1;
            }
            else
            {
                end = mid;
            }
        }
        if (flag)
        {
            return mid + 1;
        }
        if (start >= arr.length)
        {
            return -1;
        }
        return end;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 4, 10, 16, 22, 44, 48};
        System.out.println(simpleFind(arr, 16));
        System.out.println(simpleFind(arr, 10));
        System.out.println(simpleFind(arr, 50));
        System.out.println(simpleFind(arr, 1));
        System.out.println(simpleFind(arr, 48));
        System.out.println(simpleFind(arr, 44));
        System.out.println(simpleFind(arr, 22));
        System.out.println(simpleFind(arr, 0));
        System.out.println("-----------------------------");
        System.out.println(efficientSearch(arr, 16));
        System.out.println(efficientSearch(arr, 10));
        System.out.println(efficientSearch(arr, 50));
        System.out.println(efficientSearch(arr, 1));
        System.out.println(efficientSearch(arr, 48));
        System.out.println(efficientSearch(arr, 44));
        System.out.println(efficientSearch(arr, 22));
        System.out.println(efficientSearch(arr, 0));
    }
}

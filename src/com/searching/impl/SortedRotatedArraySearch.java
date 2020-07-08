package com.searching.impl;

/**
 * Search an element in a sorted and rotated array.
 * Example
 * Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
 *          key = 3
 * Output : Found at index 8
 *
 * Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
 *          key = 30
 * Output : Not found
 *
 * Input : arr[] = {30, 40, 50, 10, 20}
 *         key = 10
 * Output : Found at index 3
 */
public class SortedRotatedArraySearch
{
    private static final BinarySearch BINARY_SEARCH = new BinarySearch();

    private static int pivotedBinarySearch(int[] array, int key)
    {
        int length = array.length;
        int pivot = findPivot( array, 0, length - 1 );
        if ( pivot == -1 )
        {
            return binarySearch( array, 0, length - 1, key );
        }
        if ( array[pivot] == key )
        {
            return pivot;
        }
        if ( array[0] <= key )
        {
            return binarySearch( array, 0, pivot - 1, key);
        }
        return binarySearch( array, pivot + 1, length - 1, key );
    }

    private static int binarySearch(int arr[], int low, int high, int key)
    {
        if (high < low)
            return -1;

        /* low + (high - low)/2; */
        int mid = (low + high)/2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), high, key);
        return binarySearch(arr, low, (mid -1), key);
    }

    private static int findPivot(int[] arr, int low, int high)
    {
        if ( high < low )
        {
            return -1;
        }
        if ( high == low )
        {
            return low;
        }

        int mid = (high + low)/2;
        if ( mid < high && arr[mid] > arr[ mid + 1 ] )
        {
            return mid;
        }
        if ( mid > low && arr[mid] < arr[mid-1] )
        {
            return mid - 1;
        }
        if ( arr[low] >= arr[mid] )
        {
            return findPivot( arr, low, mid - 1 );
        }
        return findPivot( arr, mid + 1, high );
    }

    public static void main( String[] args )
    {
        int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 3;
        System.out.println("Index of the element is : "
            + pivotedBinarySearch(arr1, key));
    }
}

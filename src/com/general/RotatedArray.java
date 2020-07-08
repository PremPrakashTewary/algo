package com.general;

public class RotatedArray
{
    private static int findRotatedIndex(int[] arr)
    {
        int low = 0;
        int high = arr.length - 1;
        return findPivot( arr, low, high );
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
        int mid = low + (high - low)/2;
        if ( mid < high && arr[mid] > arr[mid+1] )
        {
            return mid + 1;
        }
        if ( mid > low && arr[mid] < arr[mid-1] )
        {
            return mid;
        }
        if ( arr[low] >= arr[mid] )
        {
            return findPivot( arr, low, mid - 1 );
        }
        return findPivot( arr, mid + 1, high );
    }

    public static void main( String[] args )
    {
        int[] arr = {6,7,8,9,-1,1};
        System.out.println("Should be 4 and got " + findRotatedIndex( arr ));
        int[] sec = {6,7,-1,0,1,2};
        System.out.println("Should be 2 and got " + findRotatedIndex( sec ));
        int[] three = {6,7,8,9,10,-1};
        System.out.println("Should be 5 and got " + findRotatedIndex( three ));
    }
}

package com.general;

/**
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right,
 * and replace the last element with -1.
 *
 * After doing so, return the array.
 *
 * Example 1:
 *
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 */
public class ReplaceElementsWithGreatestElementOnRightSide
{
    private void replaceElements(int[] arr)
    {
        Integer[] cache = new Integer[arr.length];
        for(int i=1; i<arr.length; i++)
        {
            arr[i-1] = findMax(arr, i, arr.length, cache);
        }
        arr[arr.length-1] = -1;
    }

    private int findMax(int[] arr, int currentIndex, int limit, Integer[] cache)
    {
        if(currentIndex == limit-1){
            return arr[currentIndex];
        }
        if(cache[currentIndex] != null) {
            return cache[currentIndex];
        }
        int currentMax = Math.max(arr[currentIndex], findMax(arr, currentIndex+1, limit, cache));
        cache[currentIndex] = currentMax;
        return currentMax;
    }
}

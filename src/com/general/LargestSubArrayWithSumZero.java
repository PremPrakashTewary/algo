package com.general;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array having both positive an negative integers . Your task is to complete the function maxLen which returns
 * the length of maximum subarray with 0 sum . The function takes two arguments an array A and n where n is the size of the array A .
 */
public class LargestSubArrayWithSumZero
{
    /**
     * Idea is to use map (sum - index)
     * if we see the sum again it means that from that index(saved in map )to current we have an array
     * whose sum is 0 that's why sum is seen again.
     * @param arr
     * @param n
     * @return
     */
    static int maxLen(int arr[], int n)
    {
        Map<Integer,Integer> map=new HashMap<>();
        int len=0;
        int sum=0;
        for(int i=0;i<n;++i)
        {
            sum+=arr[i];
            if(arr[i]==0 && len==0)
            {
                len = 1;
            }
            if(sum==0)
            {
                len = i + 1;
            }
            if(map.containsKey(sum))
            {
                len=Math.max(len,i-map.get(sum));
            }
            else
            {
                map.put(sum, i);
            }
        }
        return len;
    }

    public static void main(String[] args)
    {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(maxLen(arr, arr.length));
    }
}

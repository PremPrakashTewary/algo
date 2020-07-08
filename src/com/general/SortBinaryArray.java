package com.general;

public class SortBinaryArray
{
    private static void sortBinaryArray(int[] arr)
    {
        int len = arr.length;
        int start = 0;
        int end = len - 1;

        while (start <= end)
        {
            if (arr[end] == 0)
            {
                arr[end] = arr[start];
                arr[start] = 0;
                start++;
            }
            else if (arr[end] == 1)
            {
                end--;
            }
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {0, 0, 1, 0, 1, 0, 0};
        sortBinaryArray(arr);
        for (int a: arr)
        {
            System.out.println(a);
        }
        System.out.println("-------------");
        int[] arr1 = {1, 0, 0, 1, 0, 1};
        sortBinaryArray(arr1);
        for (int a: arr1)
        {
            System.out.println(a);
        }
    }
}

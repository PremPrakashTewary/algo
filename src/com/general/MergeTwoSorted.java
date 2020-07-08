package com.general;

import com.sorting.util.PrintUtil;

public class MergeTwoSorted
{
    private static int[] mergeArrays(int[] arr1, int[] arr2)
    {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] arr3 = new int[arr1.length + arr2.length];
        int i = 0,j = 0,k = 0;
        while (i < n1 && j < n2)
        {
            if (arr1[i] < arr2[j])
            {
                arr3[k++] = arr1[i++];
            }
            else
            {
                arr3[k++] = arr2[j++];
            }
        }
        while (i < n1)
        {
            arr3[k++] = arr1[i++];
        }
        while (j < n2)
        {
            arr3[k++] = arr2[j++];
        }
        return arr3;
    }

    public static void main (String[] args)
    {
        int[] arr1 = {1, 3, 5, 7};

        int[] arr2 = {1, 4, 6, 8};


        int[] arr3 = mergeArrays(arr1, arr2);

        System.out.println("Array after merging");
        PrintUtil.printArray(arr3);
    }
}

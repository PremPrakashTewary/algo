package com.sorting.client;

import java.util.Arrays;

public class LeftRotateArray
{
    private static int[] INPUT = {1, 2, 3, 4, 5, 6, 7};

    private static int ROTATE_BY = 2;

    private static int[] RESULT = {3, 4, 5, 6, 7, 1, 2};

    public static void main(String[] args)
    {
        int[] result = leftRotate(INPUT, ROTATE_BY);
        if (Arrays.equals(RESULT, result))
        {
            System.out.println("Left Rotate by " + ROTATE_BY + " is correct");
        }
        else
        {
            throw new RuntimeException("Left Rotate by " + ROTATE_BY + " is wrong");
        }

        int[] newResult = juggle(INPUT, ROTATE_BY);
        if (Arrays.equals(RESULT, newResult))
        {
            System.out.println("Left Rotate by " + ROTATE_BY + " is correct");
        }
        else
        {
            throw new RuntimeException("Left Rotate by " + ROTATE_BY + " is wrong");
        }
    }

    private static int[] leftRotate(int[] arr, int d)
    {
        int n = arr.length;
        int[] sortInput = new int[n];
        System.arraycopy(arr, 0, sortInput, 0, arr.length);
        for (int i = 0; i < d; i++)
        {
            leftRotateByOne(sortInput, n);
        }
        return sortInput;
    }

    private static void leftRotateByOne(int[] arr, int n)
    {
        int i;
        int temp;
        temp = arr[0];
        for (i = 0; i < n - 1; i++)
        {
            arr[i] = arr[i + 1];
        }
        arr[i] = temp;
    }

    private static int[] juggle(int arr[], int d)
    {
        int n = arr.length;
        int[] sortInput = new int[n];
        System.arraycopy(arr, 0, sortInput, 0, arr.length);
        int i, j, k, temp;
        int gcd = gcd(d, n);
        for (i = 0; i < gcd; i++)
        {
            temp = sortInput[i];
            j = i;
            while (true)
            {
                k = j + d;
                if (k >= n)
                {
                    k = k - n;
                }
                if (k == i)
                {
                    break;
                }
                sortInput[j] = sortInput[k];
                j = k;
            }
            sortInput[j] = temp;
        }
        return sortInput;
    }

    private static int gcd(int a, int b)
    {
        if(b == 0)
        {
            return a;
        }
        else
        {
            return gcd(b, a % b);
        }
    }
}

package com.general;

import java.util.Stack;

public class GfG
{
    private static int[] printNGE(int arr[])
    {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int[] arr1 = new int[n];

        for (int i = n - 1; i >= 0; i--)
        {
            while (!s.empty() && s.peek() < arr[i])
            {
                s.pop();
            }
            if (s.empty())
            {
                arr1[i] = -1;
            }
            else
            {
                arr1[i] = s.peek();
            }
            s.push(arr[i]);
        }
        return arr1;
    }

    public static void main(String[] args)
    {
        int arr[] = { 11, 13, 21, 3 };
        int[] result = printNGE(arr);
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i] + " ---> " + result[i]);
        }
    }
}

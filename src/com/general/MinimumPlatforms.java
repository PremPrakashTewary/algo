package com.general;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumPlatforms
{
    private static int findPlatform(int[] arr, int[] dep)
    {
        int platNeeded = 1, result = 1;
        int i = 1, j = 0;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int n = arr.length;
        while (i < n && j < n)
        {
            if (arr[i] <= dep[j])
            {
                platNeeded++;
                i++;
                if (platNeeded > result)
                {
                    result = platNeeded;
                }
            }
            else
            {
                platNeeded--;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++)
        {
            int count = scanner.nextInt();
            int[] arr = new int[count];
            int[] dep = new int[count];
            for (int j = 0; j < count; j++)
            {
                arr[j] = scanner.nextInt();
            }
            for (int j = 0; j < count; j++)
            {
                dep[j] = scanner.nextInt();
                if (dep[j] < arr[j])
                {
                    dep[j] += 2400;
                }
            }
            System.out.println(findPlatform(arr, dep));
        }
    }
}

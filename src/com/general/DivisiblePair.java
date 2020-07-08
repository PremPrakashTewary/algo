package com.general;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DivisiblePair
{
    public static void main(String[] args)
    {
        int arr[] = {92, 75, 65, 48, 45, 35};
        int k = 10;
        boolean ans = canPairs(arr, k);
        if (ans)
        {
            System.out.println("True");
        } else
        {
            System.out.println("False");
        }
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++)
        {
            int input = scanner.nextInt();
            System.out.println(armstrongNo(input));
        }
    }

    private static String armstrongNo(int input) {
        String output = "No";
        int n = input;
        int sum = 0;
        while(n >= 0) {
            int rem = n % 10;
            sum = sum + (int)Math.pow(rem,3);
            n = n/10;
        }
        if (sum == input) {
            output = "Yes";
        }
        return output;
    }

    static boolean canPairs(int ar[], int k)
    {
        // An odd length array cannot be divided into pairs
        if (ar.length % 2 == 1)
        {
            return false;
        }

        // Create a frequency array to count occurrences
        // of all remainders when divided by k.
        Map<Integer, Integer> hm = new HashMap<>();

        // Count occurrences of all remainders
        for (int i = 0; i < ar.length; i++)
        {
            int rem = ar[i] % k;
            if (!hm.containsKey(rem))
            {
                hm.put(rem, 0);
            }
            hm.put(rem, hm.get(rem) + 1);
        }

        // Traverse input array and use freq[] to decide
        // if given array can be divided in pairs
        for (int i = 0; i < ar.length; i++)
        {
            // Remainder of current element
            int rem = ar[i] % k;

            // If remainder with current element divides
            // k into two halves.
            if (2 * rem == k)
            {
                // Then there must be even occurrences of
                // such remainder
                if (hm.get(rem) % 2 == 1)
                {
                    return false;
                }
            }

            // If remainder is 0, then there must be two
            // elements with 0 remainder
            else if (rem == 0)
            {
                // Then there must be even occurrences of
                // such remainder
                if (hm.get(rem) % 2 == 1)
                {
                    return false;
                }
            }

            // Else number of occurrences of remainder
            // must be equal to number of occurrences of
            // k - remainder
            else
            {
                if (hm.get(k - rem) != hm.get(rem))
                {
                    return false;
                }
            }
        }
        return true;
    }
}

package com.general;

import java.util.Scanner;

public class LCS
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int tectCases = scanner.nextInt();
        for (int i = 0 ; i < tectCases; i++)
        {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            String x = scanner.next();
            String y = scanner.next();
            System.out.println(lcs(x.toCharArray(), y.toCharArray(), m, n));
        }
    }

    private static int lcs( char[] X, char[] Y, int m, int n )
    {
        if (m == 0 || n == 0)
            return 0;
        if (X[m-1] == Y[n-1])
            return 1 + lcs(X, Y, m-1, n-1);
        else
            return max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
    }

    /* Utility function to get max of 2 integers */
    private static int max(int a, int b)
    {
        return Math.max(a, b);
    }
}

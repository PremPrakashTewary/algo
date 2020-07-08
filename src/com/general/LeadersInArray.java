package com.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeadersInArray
{
    private static void arrayLeader(int[] input)
    {
        int len = input.length;
        int maxRight = input[len - 1];
        List<Integer> lst = new ArrayList<>();
        lst.add(maxRight);
        for (int i = len - 2; i >= 0; i--)
        {
            if (maxRight <= input[i])
            {
                maxRight = input[i];
                lst.add(maxRight);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = lst.size() - 1; i >=0; i--)
        {
            sb.append(lst.get(i) + " ");
        }
        System.out.print(sb);
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++)
        {
            int count = scanner.nextInt();
            int[] input = new int[count];
            for (int j = 0; j < count; j++)
            {
                input[j] = scanner.nextInt();
            }
            arrayLeader(input);
            System.out.println();
        }
    }
}

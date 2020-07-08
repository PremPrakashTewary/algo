package com.general;

import java.util.Scanner;

public class TestCustom
{
    public static void main(String[] args)
    {
        char f = "-1".charAt(0);
        System.out.println(f);
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int j = 0; j < testCases; j++)
        {
            System.out.println("Start -- " + j);
            String s = "ABS";

            for (int i = 0; i < 8; i++)
            {
                int point = scanner.nextInt();
                System.out.println("SS " + point);
            }
        }
    }
}

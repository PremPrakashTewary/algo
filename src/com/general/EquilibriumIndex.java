package com.general;

import java.util.stream.IntStream;

public class EquilibriumIndex
{
    /**
     * Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of
     * elements at higher indexes
     *
     * Input : A[] = {-7, 1, 5, 2, -4, 3, 0}
     * Output : 3
     * 3 is an equilibrium index, because:
     * A[0] + A[1] + A[2]  =  A[4] + A[5] + A[6]
     *
     * @param input
     */
    private static int equilibriumIndex(int[] input)
    {
        int sum = IntStream.of(input).sum();

        int leftsum = 0;

        for (int i = 0; i < input.length; ++i) {
            sum -= input[i]; // sum is now right sum for index i

            if (leftsum == sum)
                return i;

            leftsum += input[i];
        }
        return -1;
    }

    public static void main(String[] args)
    {
        /*Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++)
        {
            int count = scanner.nextInt();
            int[] input = new int[count];
            for (int j = 0; j < count; j++)
            {
                input[j] = scanner.nextInt();
            }
            equilibriumIndex(input);
        }*/
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(equilibriumIndex(arr));
        int[] arr2 = {0, -3, 5, -4, -2, 3, 1, 0};
        System.out.println(equilibriumIndex(arr2));
        int[] arr3 = {0,-1,2,-1};
        System.out.println(equilibriumIndex(arr3));
    }
}

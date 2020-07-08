package com.general;

import java.util.HashSet;
import java.util.Set;

/**
 * Find all distinct combinations of given length
 * For example,
 * Input: {1, 2, 3}, k = 2 Output: {1, 2}, {1, 3}, {2, 3
 * Input: {1, 2, 1}, k = 2 Output: {1, 1}, {1, 2}
 *
 * We can use recursion to solve this problem. The idea is to add each element in the output and recur for remaining
 * elements with one less element. To avoid printing permutations, each combination will be constructed in same order
 * as array elements. If combination of given size is found, we print it. Below solution generates all combinations by
 * using above logic by traversing the array from left to right. To print only distinct combinations in case input
 * contains repeated elements, we can sort the array and exclude all adjacent duplicate elements from the array.
 */
public class DistinctCombinationForGivenLength
{
    private static void findDistinct(int[] input, int k)
    {
        recurseFindDistinct(input, "", 0, input.length, k);
    }

    private static void recurseFindDistinct(int[] input, String out, int start, int end, int k)
    {
        if (k > end)
        {
            return;
        }
        if (k == 0)
        {
            System.out.println(out);
            return;
        }
        for (int j = start; j < end; j++)
        {
            recurseFindDistinct(input, out + " " + (input[j]), j + 1, end, k - 1);
        }
    }

    public static void main(String[] args)
    {
        int[] A = {1, 2, 3};
        int k = 2;
        findDistinct(A, k);
    }
}

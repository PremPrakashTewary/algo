package com.general;

public class EqualizeArray
{
    /**
     * Given an array of integers, the task is to count minimum number of operations to equalize the array (make all array elements same).
     * And return -1 if it is not possible to equalize. To equalize an array, we need to move values from higher numbers to smaller numbers.
     * Number of operations is equal to number of movements
     *
     * Input :  arr[] = {1, 3, 2, 0, 4}
     * Output : 3
     * We can equalize the array by making value
     * of all elements equal to 2. To achieve this
     * we need to do minimum 3 operations (moving
     * Moving 1 value from arr[1] to arr[0]
     * Moving 2 values from arr[4] to arr[3]
     *
     * @param arr
     * @return
     */
    private static int minOperations(int[] arr)
    {
        int len = arr.length;
        int sum = 0;
        for (int i = 0; i < len; i++)
        {
            sum += arr[i];
        }

        if (sum % len != 0)
        {
            return -1;
        }

        int diffSum = 0;
        int eq = sum / len;
        for (int i = 0; i < len; i++)
        {
            diffSum += Math.abs(arr[i] - eq);
        }
        return diffSum / 2;
    }

    public static void main(String args[])
    {
        int arr[] = {5, 3, 2, 6};
        System.out.println(minOperations(arr));
    }
}

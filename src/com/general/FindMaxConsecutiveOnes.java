package com.general;

import java.util.Arrays;

public class FindMaxConsecutiveOnes
{
    public static int findMaxConsecutiveOnes(int[] nums)
    {
        int maxOne = 0;
        int startOne;
        int length = nums.length;
        for(int index = 0; index < length; index++) {
            if(nums[index] == 1)
            {
                startOne = 1;
                while (index < length - 1)
                {
                    index = index + 1;
                    if (nums[index] != 1)
                    {
                        break;
                    }
                    startOne = startOne + 1;
                }
                if (startOne > maxOne)
                {
                    maxOne = startOne;
                }
            }
        }
        return maxOne;
    }

    public static void main( String[] args )
    {
        int[] input = {1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(input));
    }
}

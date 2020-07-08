package com.general;

import java.util.Arrays;

public class Test
{
    public static void main( String[] args )
    {
        int[] arr = {1,2,-2147483648};
        System.out.println(thirdMax(arr));
    }

    private static int thirdMax(int[] nums) {

        Integer first = null;
        Integer second = null;
        Integer third = null;
        for (Integer num: nums)
        {
            if (num.equals(first) || num.equals(second) || num.equals(third))
            {
                continue;
            }
            else if(first==null || num>first){
                third=second;
                second=first;
                first=num;
            }else if(second==null || num>second){
                third=second;
                second=num;
            }else if(third==null || num>third){
                third=num;
            }
        }
        if(third==null)
            return first;
        return third;
    }
}

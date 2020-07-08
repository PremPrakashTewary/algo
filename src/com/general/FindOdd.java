package com.general;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FindOdd
{
    private static int findOdd(int[] arr)
    {
        int odd = -1;
        Map<Integer, Boolean> map = new HashMap<>();
        int len = arr.length;
        for (int  i = 0; i < len; i++)
        {
            if (map.containsKey(arr[i]))
            {
                map.remove(arr[i]);
            }
            else
            {
                map.put(arr[i], Boolean.TRUE);
            }
        }
        Iterator<Map.Entry<Integer, Boolean>> itr = map.entrySet().iterator();
        if (itr.hasNext())
        {
            odd = itr.next().getKey();
        }
        return odd;
    }

    public static void main(String[] args)
    {
        System.out.println(findOdd(new int[] {1, 4, 6, 4, 6, 1, 6} ));
    }
}

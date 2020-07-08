package com.general;

import java.util.Stack;

public class MaxAreaHistogram
{
    private static int calculateMaxArea(int[] hist)
    {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        int i  = 0;
        int len = hist.length;
        while (i < len)
        {
            if (stack.empty() || hist[stack.peek()] <= hist[i])
            {
                stack.push(i);
                i++;
            }
            else
            {
                max = findMax(stack, hist, i, max);
            }
        }
        while (stack.empty())
        {
            max = findMax(stack, hist, i, max);
        }
        return max;
    }

    private static int findMax(Stack<Integer> stack, int[] hist, int currentIndex, int currentMax)
    {
        int curMax = stack.pop();
        int area = hist[curMax] * (stack.empty() ? (currentIndex-1) : (currentIndex-1-stack.peek()));
        if (area > currentMax)
        {
            currentMax = area;
        }
        return  currentMax;
    }

    public static void main(String[] args)
    {
        System.out.println(calculateMaxArea(new int[] {1, 2, 3, 4, 5, 3, 3, 2}));
    }
}

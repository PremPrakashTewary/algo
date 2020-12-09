package com.general;

import java.util.Stack;

public class SortStack
{
    public static Stack<Integer> sort(Stack<Integer> input)
    {
        if (null == input || input.empty())
        {
            return input;
        }
        Stack<Integer> result = new Stack<>();
        result.push(input.pop());
        while (!input.isEmpty())
        {
            int temp = input.pop();
            while (!result.isEmpty() && temp > result.peek())
            {
                input.push(result.pop());
            }
            result.push(temp);
        }
        return result;
    }

    public static void main(String[] args)
    {
        Stack<Integer> input = new Stack<>();
        input.push(4);
        input.push(1);
        input.push(8);
        input.push(2);
        Stack<Integer> sortedStack = sort(input);
        System.out.println("Sorted Stack is "+ sortedStack);
    }
}

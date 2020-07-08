package com.general;

import java.util.Stack;
import java.util.StringJoiner;

public class StackQueue<E>
{
    private Stack<E> stack = new Stack<>();

    public E deque()
    {
        if (stack.isEmpty())
        {
            throw new IllegalArgumentException("Queue is empty");
        }
        return recurse();
    }

    public void enque(E value)
    {
        stack.push(value);
    }

    private E recurse()
    {
        if (stack.size() == 1)
        {
            return stack.pop();
        }

        E curValue = stack.pop();
        E value = recurse();
        stack.push(curValue);
        return value;
    }

    @Override
    public String toString()
    {
        return new StringJoiner(", ", StackQueue.class.getSimpleName() + "[", "]")
            .add("values=" + stack)
            .toString();
    }

    public static void main(String[] args)
    {
        StackQueue<Integer> stackQueue = new StackQueue<>();
        stackQueue.enque(1);
        stackQueue.enque(2);
        stackQueue.enque(3);
        stackQueue.enque(4);
        System.out.println("Initial Queue " + stackQueue);
        Integer dequeValue = stackQueue.deque();
        System.out.println("dequeValue is " + dequeValue);
        System.out.println("After Deque" + stackQueue);
    }
}

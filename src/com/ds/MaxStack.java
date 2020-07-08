package com.ds;

import java.util.Optional;

public class MaxStack
{
    private StackNode stack;
    private StackNode max;

    private class StackNode
    {
        private Integer value;
        private StackNode next;
        private StackNode prevMax;

        StackNode(Integer value)
        {
            this.value = value;
        }
    }

    public void push(Integer element)
    {
        StackNode stackNode = new StackNode( element );
        if ( null == stack )
        {
            stack = stackNode;
        }
        else
        {
            stackNode.next = stack;
            stack = stackNode;
        }

        if ( null == max || stackNode.value >= max.value )
        {
            stack.prevMax = max;
            max = stackNode;
        }
    }

    public Optional<Integer> pop()
    {
        Optional<Integer> value = Optional.empty();
        if ( null != stack )
        {
            StackNode node = stack;
            stack = stack.next;
            value = Optional.of( node.value );
            if ( node.value.equals( max.value ) )
            {
                max = node.prevMax;
            }
        }
        return value;
    }

    public Optional<Integer> max()
    {
        Optional<Integer> value = Optional.empty();
        if ( null != max )
        {
            value = Optional.of( max.value );
        }
        return value;
    }
}

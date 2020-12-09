package com.general;

import java.util.Stack;

public class StackQueues
{
    private Stack<Integer> enqueu;
    private Stack<Integer> dequeu;

    public StackQueues() {
        enqueu = new Stack<>();
        dequeu = new Stack<>();
    }

    public void push(int x) {
        enqueu.push(x);
    }

    public int pop() {
        if(empty()) {
            return -1;
        }
        if(dequeu.isEmpty()) {
            while(!enqueu.isEmpty()) {
                dequeu.push(enqueu.pop());
            }
        }
        return dequeu.pop();
    }

    public int peek() {
        if(empty()) {
            return -1;
        }
        if(dequeu.isEmpty()) {
            while(!enqueu.isEmpty()) {
                dequeu.push(enqueu.pop());
            }
        }
        return dequeu.peek();
    }

    public boolean empty() {
        return dequeu.isEmpty() && enqueu.isEmpty();
    }

    public static void main( String[] args )
    {
        StackQueues stackQueues = new StackQueues();
        stackQueues.push(1);
        stackQueues.push(2);
        stackQueues.peek();
    }
}

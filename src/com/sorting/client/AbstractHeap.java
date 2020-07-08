package com.sorting.client;

public abstract class AbstractHeap
{
    protected int[] Heap;
    protected int size;
    protected int maxsize;

    protected static final int FRONT = 1;

    protected AbstractHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i]
                + " LEFT CHILD : " + Heap[2 * i]
                + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }
}

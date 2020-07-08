package com.ds;

import java.util.NoSuchElementException;

public class SingleLinkList<T>
{
    private int size;

    private Node<T> head = null;

    private class Node<T>
    {
        private T data;

        private Node<T> next;

        Node(T data)
        {
            this( data, null );
        }

        Node(T data, Node<T> next)
        {
            this.data = data;
            this.next = next;
        }
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void add(T data)
    {
        if ( isEmpty() )
        {
            head = new Node<>( data );
        }
        else
        {
            Node<T> temp = head;
            while ( null != temp.next )
            {
                temp = temp.next;
            }
            temp.next = new Node<>( data );
        }
        size++;
    }

    public void remove(T data)
    {
        if ( isEmpty() )
        {
            throw new NoSuchElementException( "List is empty" );
        }
        if ( head.data.equals( data ) )
        {
            Node<T> temp = head.next;
            head = null;
            head = temp;
            size--;
            return;
        }
        Node<T> current = head;
        Node<T> prev = null;
        while ( null !=  current && !current.data.equals( data ) )
        {
            prev = current;
            current = current.next;
        }
        if ( null == current )
        {
            throw new NoSuchElementException( " Element " + data.toString() + " not found" );
        }
        prev.next = current.next;
        size--;
    }

    public boolean contains(T data)
    {
        boolean found = false;
        if ( !isEmpty() )
        {
            Node<T> temp = head;
            while ( null != temp && !temp.data.equals( data ) )
            {
                temp = temp.next;
            }
            if ( null != temp )
            {
                found = true;
            }
        }
        return found;
    }
}

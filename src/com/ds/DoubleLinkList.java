package com.ds;

import com.iterator.DoubleLinkListIterator;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;

public class DoubleLinkList<K>
{
    private int size;

    private Node<K> front = null;

    private class Node<K>
    {
        private K data;

        private Node<K> prev;

        private Node<K> next;

        Node(K data)
        {
            this( null, data, null );
        }

        Node(Node<K> prev, K data, Node<K> next)
        {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private class DoubleLinkListIteratorImpl<K> implements DoubleLinkListIterator<K>
    {
        private int counter;
        private Node<K> currentNode;

        DoubleLinkListIteratorImpl()
        {
            currentNode = getFront();
        }

        @Override
        public boolean hasNext()
        {
            return counter < size();
        }

        @Override
        public K next()
        {
            if ( !hasNext() )
            {
                throw new NoSuchElementException( "Reached to the end of list" );
            }
            K value = currentNode.data;
            size++;
            currentNode = currentNode.next;
            return value;
        }


        @Override
        public void forEachRemaining(Consumer<? super K> action)
        {
            throw new UnsupportedOperationException("forEachRemaining");
        }
    }

    DoubleLinkList.Node getFront()
    {
        return front;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void addFront(K data)
    {
        if ( isEmpty() )
        {
            front = new Node<>( data );
        }
        else
        {
            Node<K> temp = front;
            front = new Node<>( null, data, temp );
            front.next.prev = front;
        }
        size++;
    }

    public Optional<K[]> getAllElements()
    {
        Optional<K[]> optionalData = Optional.empty();
        if ( !isEmpty() )
        {
            K[] datas = ( K[] ) Array.newInstance( front.data.getClass(), size );
            Node<K> temp = front;
            int i = 0;
            while ( null != temp )
            {
                datas[i] = temp.data;
                temp = temp.next;
                i++;
            }
            optionalData = Optional.of( datas );
        }
        return optionalData;
    }

    public void addEnd(K data)
    {
        if ( isEmpty() )
        {
            front = new Node<>( data );
        }
        else
        {
            Node<K> temp = front;
            while ( null != temp.next )
            {
                temp = temp.next;
            }
            temp.next = new Node<>( temp, data, null );
        }
        size++;
    }

    public void addBefore(K beforeData, K data)
    {
        Node<K> current = findElement( beforeData );
        Node<K> newNode = new Node<>( current.prev, data, current );
        if ( null != current.prev )
        {
            current.prev.next = newNode;
        }
        else
        {
            front = newNode;
        }
        current.prev = newNode;
    }

    public void addAfter(K afterData, K data)
    {
        Node<K> current = findElement( afterData );
        Node<K> newNode = new Node<>( current, data, current.next );
        if ( null != current.next )
        {
            current.next.prev = newNode;
        }
        current.next = newNode;
        size++;
    }

    public void remove(K data)
    {
        if ( isEmpty() )
        {
            throw new NoSuchElementException( "List is empty" );
        }

        if ( front.data.equals( data ) )
        {
            front = front.next;
            if ( null != front )
            {
                front.prev = null;
            }
            else
            {
                front = null;
            }
            size--;
            return;
        }
        Node<K> current = findElement( data );
        if ( null != current.next )
        {
            current.next.prev = current.prev;
        }
        if ( null != current.prev )
        {
            current.prev.next = current.next;
        }
        size--;
    }

    public int size()
    {
        return size;
    }

    public boolean contains(K data)
    {
        boolean contains = true;
        try
        {
            findElement( data );
        }
        catch ( NoSuchElementException ne )
        {
            contains = false;
        }
        return contains;
    }

    public Iterator<K> iterator()
    {
        return new DoubleLinkListIteratorImpl<>();
    }

    public DoubleLinkListIterator<K> doubleLinkListIterator()
    {
        return new DoubleLinkListIteratorImpl<>();
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder( "[" );
        Node<K> temp = front;
        while ( temp != null )
        {
            sb.append( temp.data ).append( "," );
            temp = temp.next;
        }
        if ( sb.indexOf( "," ) >= 0 )
        {
            sb.deleteCharAt( sb.length() - 1 );
        }
        sb.append( "]" );
        return sb.toString();
    }

    private Node<K> findElement( K data)
    {
        if ( isEmpty() )
        {
            throw new NoSuchElementException( "List is empty" );
        }

        Node<K> current = front;
        while ( null != current )
        {
            if ( current.data.equals( data ) )
            {
                return current;
            }
            current = current.next;
        }

        if ( null == current )
        {
            throw new NoSuchElementException( " Element " + data.toString() + " not found" );
        }
        return current;
    }
}

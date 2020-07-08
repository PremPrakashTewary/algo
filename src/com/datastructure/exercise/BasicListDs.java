package com.datastructure.exercise;

import java.util.Optional;
import java.util.StringJoiner;

public class BasicListDs<T> implements ListDs<T>
{
    private Node<T> first;
    private Node<T> last;
    private int nodeCount = 0;

    @Override
    public void add( T newItem )
    {
        if ( first == null )
        {
            first = new Node<>( newItem );
            last = first;
        }
        else
        {
            Node<T> newNode = new Node<>( newItem );
            last.nextNode = newNode;
            last = newNode;
        }
        nodeCount++;
    }

    @Override
    public Optional<T> remove()
    {
        Optional<T> item = Optional.empty();
        if ( first != null )
        {
            item = Optional.of( first.item );
            first = first.nextNode;
            nodeCount--;
        }
        return item;
    }

    @Override
    public int size()
    {
        return nodeCount;
    }

    @Override
    public boolean contains( T item )
    {
        if ( size() == 0 )
        {
            return false;
        }
        Node<T> currentNode = first;
        while ( currentNode != null )
        {
            if ( currentNode.item.equals( item ) )
            {
                return true;
            }
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    @Override
    public void insertAt( T newItem, int position )
    {
        if ( position > size() )
        {
            throw new IllegalArgumentException( "Position at which element to be added is greater than size of list" );
        }
        if ( first == null )
        {
            add( newItem );
        }
        else
        {
            Node<T> currentNode = first;
            for ( int i = 0; i < position && currentNode != null; i++ )
            {
                currentNode = currentNode.nextNode;
            }
            Node<T> newNode = new Node<>( newItem );
            Node<T> nextNode = currentNode.nextNode;
            currentNode.nextNode = newNode;
            newNode.nextNode = nextNode;
            nodeCount++;
        }
    }

    @Override
    public Optional<T> removeAt( int position )
    {
        Optional<T> item = Optional.empty();
        Node<T> currentNode = first;
        Node<T> prevNode = first;
        for ( int i = 0; i < position && currentNode!= null; i++ )
        {
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        if ( currentNode != null )
        {
            item = Optional.of( currentNode.item );
            prevNode.nextNode = currentNode.nextNode;
        }
        if ( position == 0 && prevNode != null)
        {
            first = prevNode.nextNode;
        }
        nodeCount--;
        return item;
    }

    @Override
    public Optional<T> getAt( int position )
    {
        int counter = 0;
        Node<T> currentNode = first;
        while ( counter < position && currentNode != null  )
        {
            currentNode = currentNode.nextNode;
            counter++;
        }
        if ( currentNode != null )
        {
            return Optional.of( currentNode.item );
        }
        return Optional.empty();
    }

    @Override
    public Optional<Integer> get( T item )
    {
        int foundIndex = 0;
        Node<T> currentNode = first;
        while ( currentNode != null )
        {
            if ( currentNode.item.equals( item ) )
            {
                return Optional.of( foundIndex );
            }
            currentNode = currentNode.nextNode;
            foundIndex++;
        }
        return Optional.empty();
    }

    @Override
    public String toString()
    {
        StringJoiner sb = new StringJoiner( ", ", BasicListDs.class.getSimpleName() + "[", "]" );
        Node<T> currentNode = first;
        while ( currentNode != null )
        {
            sb.add( "item = " + currentNode.item );
            currentNode = currentNode.nextNode;
        }
        return sb.toString();
    }

    private class Node<T>
    {
        private Node<T> nextNode;
        private T item;

        public Node( T item )
        {
            this.item = item;
            this.nextNode = null;
        }

    }
}

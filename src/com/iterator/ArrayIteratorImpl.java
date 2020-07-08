package com.iterator;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class ArrayIteratorImpl<K> implements ArrayIterator<K>
{
    private K[] array;
    private int counter;

    public ArrayIteratorImpl( K[] input)
    {
        this.array = input;
    }

    public boolean hasNext()
    {
        return counter < array.length;
    }

    public K next()
    {
        if ( counter == array.length )
        {
            throw new NoSuchElementException( "Reached to the end of input array" );
        }
        K value = array[counter];
        counter++;
        return value;
    }

    @Override
    public void forEachRemaining(Consumer<? super K> action)
    {
        throw new UnsupportedOperationException("forEachRemaining");
    }
}

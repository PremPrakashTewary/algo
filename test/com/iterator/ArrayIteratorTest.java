package com.iterator;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

public class ArrayIteratorTest
{

    @Test
    public void testHashNextTrue()
    {
        String[] inputArray = { "ONE" };

        ArrayIterator<String> itr = new ArrayIteratorImpl<>( inputArray );
        Assert.assertThat( itr.hasNext(), CoreMatchers.equalTo( true ) );
        Assert.assertThat( itr.next(),  CoreMatchers.equalTo( "ONE" ) );
        Assert.assertThat( itr.hasNext(), CoreMatchers.equalTo( false ) );
    }

    @Test
    public void testNextWhenEndIsReached()
    {
        String[] inputArray = { "ONE" };

        ArrayIterator<String> itr = new ArrayIteratorImpl<>( inputArray );
        itr.next();
        try
        {
            itr.next();
            Assert.fail( "Should throw IllegalStateException" );
        }
        catch ( NoSuchElementException is )
        {
            Assert.assertThat( "Reached to the end of input array", CoreMatchers.equalTo( is.getMessage() ) );
        }
    }
}

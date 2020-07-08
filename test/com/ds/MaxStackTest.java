package com.ds;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MaxStackTest
{
    @Test
    public void testPushPop()
    {
        MaxStack maxStack = new MaxStack();
        maxStack.push( 1 );
        maxStack.push( -1 );
        maxStack.push( 0 );

        Assert.assertThat( 0, CoreMatchers.equalTo( maxStack.pop().get() ) );
        Assert.assertThat( -1, CoreMatchers.equalTo( maxStack.pop().get() ) );
        Assert.assertThat( 1, CoreMatchers.equalTo( maxStack.pop().get() ) );
        Assert.assertThat( false, CoreMatchers.equalTo( maxStack.pop().isPresent() ) );
    }

    @Test
    public void testMax()
    {
        MaxStack maxStack = new MaxStack();
        maxStack.push( 20 );
        maxStack.push( -10 );
        maxStack.push( 30 );
        maxStack.push( 8 );
        maxStack.push( 30 );

        Assert.assertThat( 30, CoreMatchers.equalTo( maxStack.max().get() ) );

        maxStack.pop();
        maxStack.pop();

        Assert.assertThat( 30, CoreMatchers.equalTo( maxStack.max().get() ) );

        maxStack.pop();

        Assert.assertThat( 20, CoreMatchers.equalTo( maxStack.max().get() ) );
    }
}

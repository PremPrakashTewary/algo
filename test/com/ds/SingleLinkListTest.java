package com.ds;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

public class SingleLinkListTest
{
    private SingleLinkList<Integer> singleLinkList;

    @Before
    public void setUp()
    {
        singleLinkList = new SingleLinkList<>();
        singleLinkList.add( 1 );
    }

    @Test
    public void testAdd()
    {
        singleLinkList.add( 2 );
        Assert.assertThat( 2, CoreMatchers.equalTo( singleLinkList.size() ) );
        Assert.assertThat( true, CoreMatchers.equalTo( singleLinkList.contains( 2 ) ) );
    }

    @Test
    public void testRemoveFirst()
    {
        singleLinkList.add( 2 );
        singleLinkList.remove( 1 );

        Assert.assertThat( 1, CoreMatchers.equalTo( singleLinkList.size() ) );
        Assert.assertThat( true, CoreMatchers.equalTo( singleLinkList.contains( 2 ) ) );
        Assert.assertThat( false, CoreMatchers.equalTo( singleLinkList.contains( 1 ) ) );
    }

    @Test
    public void testRemoveAfterFirst()
    {
        singleLinkList.add( 2 );
        singleLinkList.add( 3 );
        singleLinkList.remove( 2 );

        Assert.assertThat( 2, CoreMatchers.equalTo( singleLinkList.size() ) );
        Assert.assertThat( true, CoreMatchers.equalTo( singleLinkList.contains( 3 ) ) );
        Assert.assertThat( false, CoreMatchers.equalTo( singleLinkList.contains( 2 ) ) );

        singleLinkList.remove( 3 );

        Assert.assertThat( 1, CoreMatchers.equalTo( singleLinkList.size() ) );
        Assert.assertThat( true, CoreMatchers.equalTo( singleLinkList.contains( 1 ) ) );
        Assert.assertThat( false, CoreMatchers.equalTo( singleLinkList.contains( 3 ) ) );
    }

    @Test(expected = NoSuchElementException.class )
    public void testRemoveElementNotInList()
    {
        singleLinkList.remove( 20 );
    }

    @Test(expected = NoSuchElementException.class )
    public void testRemoveElementFromEmptyList()
    {
        SingleLinkList<String> emptyList = new SingleLinkList<>();
        emptyList.remove( "1" );
    }
}

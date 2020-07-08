package com.iterator;

import com.ds.DoubleLinkList;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class DoubleLinkListIteratorTest
{
    private DoubleLinkList<String> doubleLinkList = new DoubleLinkList<>();

    @Before
    public void setUp()
    {
        doubleLinkList.addEnd( "TWO" );
        doubleLinkList.addEnd( "THREE" );
        doubleLinkList.addEnd( "FOUR" );
    }

    @Test
    public void testAddEnd()
    {
        doubleLinkList.addEnd( "FIVE" );
        Assert.assertThat( doubleLinkList.size(), CoreMatchers.equalTo( 4 ) );

        Optional<String[]> optionalElements = doubleLinkList.getAllElements();

        String[] elements = assertElement( optionalElements );
        //assertElementOrder( elements );
    }

    public void testAddAtFirst()
    {
        doubleLinkList.addAfter( "TWO", "FIVE" );
        Assert.assertThat( doubleLinkList.size(), CoreMatchers.equalTo( 5 ) );
    }

    private String[] assertElement(Optional<String[]> optionalElements)
    {
        Assert.assertThat( optionalElements, CoreMatchers.notNullValue() );
        Assert.assertThat( optionalElements.isPresent(), CoreMatchers.equalTo( true ) );
        String[] elements = optionalElements.get();
        Assert.assertThat( elements.length, CoreMatchers.equalTo( doubleLinkList.size() ) );
        return elements;
    }

    private void assertElementOrder(String[] actualOrder, String[] expectedOrder)
    {
        for ( int i = 0; i < expectedOrder.length; i++ )
        {
            Assert.assertThat( actualOrder[i], CoreMatchers.equalTo( expectedOrder[i] ) );
        }
    }

}

package com.datastructure.exercise;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class ListDsTest
{
    private ListDs<String> listDs;

    @Before
    public void setUp()
    {
        listDs = new BasicListDs<>();
    }

    @After
    public void tearDown()
    {
        listDs = null;
    }

    @Test
    public void testAdd()
    {
        // Test for add at the first
        listDs.add( "A" );
        Assert.assertThat( 1, CoreMatchers.equalTo( listDs.size() ) );
        Assert.assertThat( true, CoreMatchers.equalTo( listDs.contains( "A" ) ) );

        // Test for add at the end
        listDs.add( "B" );
        listDs.add( "C" );
        Assert.assertThat( 3, CoreMatchers.equalTo( listDs.size() ) );
        Assert.assertThat( true, CoreMatchers.equalTo( listDs.contains( "A" ) ) );
        Assert.assertThat( true, CoreMatchers.equalTo( listDs.contains( "B" ) ) );
        Assert.assertThat( true, CoreMatchers.equalTo( listDs.contains( "C" ) ) );
    }

    @Test
    public void testAddAtPosition()
    {
        // Test insert at begining with empty list
        listDs.insertAt( "A", 0 );

        Assert.assertThat( 1, CoreMatchers.equalTo( listDs.size() ) );
        Assert.assertThat( true, CoreMatchers.equalTo( listDs.contains( "A" ) ) );

        listDs.add( "B" );

        //Test insert at begining with filled list
        listDs.insertAt( "C", 1 );
        Assert.assertThat( 3, CoreMatchers.equalTo( listDs.size() ) );
        Assert.assertThat( true, CoreMatchers.equalTo( listDs.contains( "A" ) ) );
        Assert.assertThat( true, CoreMatchers.equalTo( listDs.contains( "B" ) ) );
        Assert.assertThat( true, CoreMatchers.equalTo( listDs.contains( "C" ) ) );
        System.out.println("list = " + listDs);
    }

    @Test( expected = IllegalArgumentException.class )
    public void testInsertAtMoreThanSize()
    {
        listDs.add( "A" );
        listDs.add( "B" );

        listDs.insertAt( "C", listDs.size() + 1 );
    }

    @Test
    public void remove()
    {
        listDs.add( "A" );
        Optional<String> optionalItem = listDs.remove();
        Assert.assertTrue( optionalItem.isPresent() );
        Assert.assertThat( "A", CoreMatchers.equalTo( optionalItem.get() ) );
        Assert.assertThat(0, CoreMatchers.equalTo( listDs.size() ));

        //Test remove from empty list
        optionalItem = listDs.remove();
        Assert.assertFalse( optionalItem.isPresent() );
        Assert.assertThat(0, CoreMatchers.equalTo( listDs.size() ));
    }

    @Test
    public void removeAt()
    {
        listDs.add( "B" );
        listDs.add( "C" );
        Optional<String> optionalItem = listDs.removeAt( 0 );
        Assert.assertTrue( optionalItem.isPresent() );
        Assert.assertThat( "B", CoreMatchers.equalTo( optionalItem.get() ) );
        Assert.assertThat(1, CoreMatchers.equalTo( listDs.size() ));

        listDs.add( "A" );
        listDs.add( "D" );
        listDs.add( "E" );
        System.out.println("listDts == " +listDs);
        optionalItem = listDs.removeAt( 2 );

        Assert.assertTrue( optionalItem.isPresent() );
        Assert.assertThat( "D", CoreMatchers.equalTo( optionalItem.get() ) );
        Assert.assertThat(3, CoreMatchers.equalTo( listDs.size() ));
    }

    @Test
    public void testGetAt()
    {
        //Test getAt with empty list
        Optional<String> optionalElement = listDs.getAt( 0 );
        Assert.assertFalse( optionalElement.isPresent() );
        Assert.assertThat(0, CoreMatchers.equalTo( listDs.size() ));

        listDs.add( "A" );
        listDs.add( "B" );
        listDs.add( "C" );

        optionalElement = listDs.getAt( 0 );
        Assert.assertTrue( optionalElement.isPresent() );
        Assert.assertThat( "A", CoreMatchers.equalTo( optionalElement.get() ) );
        Assert.assertThat(3, CoreMatchers.equalTo( listDs.size() ));

        optionalElement = listDs.getAt( 1 );
        Assert.assertTrue( optionalElement.isPresent() );
        Assert.assertThat( "B", CoreMatchers.equalTo( optionalElement.get() ) );
        Assert.assertThat(3, CoreMatchers.equalTo( listDs.size() ));

        optionalElement = listDs.getAt( 2 );
        Assert.assertTrue( optionalElement.isPresent() );
        Assert.assertThat( "C", CoreMatchers.equalTo( optionalElement.get() ) );
        Assert.assertThat(3, CoreMatchers.equalTo( listDs.size() ));
    }

    @Test
    public void testGet()
    {
        //Find index of element for empty list
        Optional<Integer> optionalIndex = listDs.get( "A" );
        Assert.assertFalse( optionalIndex.isPresent() );
        Assert.assertThat(0, CoreMatchers.equalTo( listDs.size() ));

        listDs.add( "B" );
        listDs.add( "C" );
        listDs.add( "D" );

        //Test get index of element not present
        optionalIndex = listDs.get( "A" );
        Assert.assertFalse( optionalIndex.isPresent() );
        Assert.assertThat(3, CoreMatchers.equalTo( listDs.size() ));

        //Test get index of element present
        optionalIndex = listDs.get( "C" );
        Assert.assertTrue( optionalIndex.isPresent() );
        Assert.assertThat( 1, CoreMatchers.equalTo( optionalIndex.get() ) );
        Assert.assertThat(3, CoreMatchers.equalTo( listDs.size() ));
        Assert.assertThat(true, CoreMatchers.equalTo( listDs.contains( "C" ) ));
    }

    @Test
    public void testContains()
    {
        //Test contains on empty list
        Assert.assertFalse( listDs.contains( "A" ) );

        //Test contains element not found
        listDs.add( "B" );
        Assert.assertFalse( listDs.contains( "A" ) );
    }
}

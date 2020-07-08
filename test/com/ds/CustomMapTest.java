package com.ds;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class CustomMapTest
{
    private CustomMap<String, String> oneSizeMap;
    private CustomMap<String, String> manySizeMap;

    @Before
    public void setUp()
    {
        oneSizeMap = new CustomMap.CustomMapBuilder().build();
        manySizeMap = new CustomMap.CustomMapBuilder().build();;
    }

    @Test
    public void testPut()
    {
        oneSizeMap.put( "1", "1" );
        Optional<String> optionalValue = oneSizeMap.get( "1" );
        Assert.assertThat( optionalValue, CoreMatchers.notNullValue() );
        Assert.assertThat( optionalValue.isPresent(), CoreMatchers.equalTo( true ) );
        Assert.assertThat( optionalValue.get(), CoreMatchers.equalTo( "1" ) );
    }

    @Test
    public void testPutReplace()
    {
        testPut();
        oneSizeMap.put( "1", "2" );
        Assert.assertThat( oneSizeMap.get( "1" ).get(), CoreMatchers.equalTo( "2" ) );
    }

    @Test
    public void testEmpty()
    {
        Assert.assertThat( oneSizeMap.isEmpty(), CoreMatchers.equalTo( true ) );
        testPut();
        Assert.assertThat( oneSizeMap.isEmpty(), CoreMatchers.equalTo( false ) );
        manySizeMap.put( "1", "2" );
        manySizeMap.put( "2", "3" );
        Assert.assertThat( manySizeMap.isEmpty(), CoreMatchers.equalTo( false ) );
    }

    @Test
    public void testSize()
    {
        Assert.assertThat( oneSizeMap.size(), CoreMatchers.equalTo( 0 ) );
        testPut();
        manySizeMap.put( "1", "2" );
        manySizeMap.put( "2", "3" );
        Assert.assertThat( oneSizeMap.size(), CoreMatchers.equalTo( 1 ) );
        Assert.assertThat( manySizeMap.size(), CoreMatchers.equalTo( 2 ) );
    }

    @Test
    public void testGrowingMap()
    {
        CustomMap<String, String> fixedMap = new CustomMap.CustomMapBuilder().withInitialSize( 1 ).build();
        fixedMap.put( "1", "2" );
        fixedMap.put( "2", "3" );
        fixedMap.put( "1", "1" );
        fixedMap.get( "1" );
        fixedMap.get( "2" );
    }

    public void testRemove()
    {
        testPut();
        oneSizeMap.put( "2", "3" );
        oneSizeMap.put( "4", "4" );

        Optional<String> optionalValue = oneSizeMap.remove( "2" );

    }
}

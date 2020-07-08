package com.ds;

import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;

public class CustomMap<K,V>
{
    private Entry<K, V>[] buckets;
    private float loadFactor;
    private int size = 0;

    private CustomMap(CustomMapBuilder<K,V> builder)
    {
        this.buckets = new Entry[builder.initialCapacity];
        this.loadFactor = builder.loadFactor;
    }

    private void reSize()
    {
        Entry<K,V>[] tempBucket = buckets;
        buckets = new Entry[ size + 10 ];
        for ( Entry<K,V> entry: tempBucket )
        {
            int bucket = getBucketHash( entry.key );
            buckets[bucket] = entry;
        }
    }

    private int getBucketHash(K key)
    {
        int hash = getHash( key );
        System.out.println( "hash " + hash );
        int bucketSize = buckets.length;
        System.out.println( "bucketSize " + bucketSize );
        int bucketHash = hash % bucketSize;
        System.out.println( "bucketHash " + bucketHash );
        return bucketHash;
    }

    public void put(final K key, final V value)
    {
        if ( size != 0 )
        {
            float checkResize = (buckets.length - size)/size;
            if ( checkResize <= loadFactor )
            {
                reSize();
            }
        }
        Entry<K,V> newEntry = new Entry<>( key, value, null );

        int bucket = getBucketHash( key );
        System.out.println( "bucket " + bucket );
        Entry<K,V> existing = buckets[bucket];
        if ( null == existing )
        {
            buckets[bucket] = newEntry;
            size++;
        }
        else
        {
            while ( null != existing.next )
            {
                if ( existing.key.equals( key ) )
                {
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }
            if ( existing.key.equals( key ) )
            {
                existing.value = value;
            } else
            {
                existing.next = newEntry;
                size++;
            }
        }
    }

    public Optional<V> remove(final K key)
    {
        int index = getBucketHash( key );
        Entry<K, V> head = buckets[index];
        Entry<K,V> prev = null;
        while ( null != head )
        {
            if ( head.key.equals( key ) )
            {
                break;
            }
            prev = head;
            head = head.next;
        }

        if ( null == head )
        {
            return Optional.empty();
        }

        size--;
        if ( null != prev )
        {
            prev.next = head.next;
        }
        else
        {
            buckets[index] = head.next;
        }
        return Optional.of( head.value );
    }

    public Optional<V> get(final K key)
    {
        Entry<K, V> bucket = buckets[getBucketHash( key )];
        while ( bucket != null )
        {
            if ( bucket.key.equals( key ) )
            {
                return Optional.of( bucket.value );
            }
            bucket = bucket.next;
        }
        return Optional.empty();
    }

    public boolean containsKey(K key)
    {
        return get( key ).isPresent();
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    private int getHash(K key)
    {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    public static class Entry<K,V>
    {
        final K key;
        V value;
        Entry<K,V> next;

        public Entry( K key, V value, Entry<K, V> next )
        {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public boolean equals( Object o )
        {
            if ( this == o )
            {
                return true;
            }
            if ( !( o instanceof Entry ) )
            {
                return false;
            }
            Entry<?, ?> entry = ( Entry<?, ?> ) o;
            return Objects.equals( key, entry.key ) &&
                Objects.equals( value, entry.value );
        }

        @Override
        public int hashCode()
        {
            return Objects.hash( key, value );
        }

        @Override
        public String toString()
        {
            return new StringJoiner( ", ", Entry.class.getSimpleName() + "[", "]" )
                .add( "key=" + key )
                .add( "value=" + value )
                .toString();
        }
    }

    public static class CustomMapBuilder<K,V>
    {
        private static final int INITIAL_CAPACITY = 1 << 4; // 16
        private int initialCapacity = INITIAL_CAPACITY;
        private float loadFactor = .75f;

        public CustomMapBuilder()
        {
        }

        public CustomMapBuilder<K,V> withInitialSize(int initialSize)
        {
            this.initialCapacity = initialSize;
            return this;
        }

        public CustomMapBuilder<K,V> withLoadFactor(float loadFactor)
        {
            this.loadFactor = loadFactor;
            return this;
        }

        public CustomMap<K,V> build()
        {
            return new CustomMap<>( this );
        }
    }
}

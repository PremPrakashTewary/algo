package com.datastructure.exercise;

import java.util.Optional;

public interface ListDs<T>
{
    void add(T newItem);
    Optional<T> remove();
    int size();
    boolean contains(T item);
    void insertAt(T newItem, int position);
    Optional<T> removeAt(int position);
    Optional<T> getAt(int position);
    Optional<Integer> get(T item);
}

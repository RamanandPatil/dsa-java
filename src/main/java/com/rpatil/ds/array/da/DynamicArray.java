package com.rpatil.ds.array.da;

import com.rpatil.ds.array.Array;

public class DynamicArray<E> implements Array<E> {
    private int size = 0;

    private static final int DEFAULT_RESIZE_FACTOR = 2;
    private static final int INITIAL_DEFAULT_SIZE = 16;
    private static final int MAX_SIZE = Integer.MAX_VALUE;
    private int capacity = INITIAL_DEFAULT_SIZE;

    private final Object[] array;

    public DynamicArray() {
        array = new Object[INITIAL_DEFAULT_SIZE];
    }

    public DynamicArray(int initialSize) {
        this.capacity = initialSize;
        array = new Object[initialSize];
    }

    @Override
    public boolean add(E element) {
        ensureCapacity();
        return false;
    }

    private void ensureCapacity() {
        if (capacity <= size) {
            return;
        }
        if (capacity <= MAX_SIZE / 2) {
            capacity *= 2;
        } else {
            capacity += MAX_SIZE / INITIAL_DEFAULT_SIZE;
        }
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public void clear() {

    }
}

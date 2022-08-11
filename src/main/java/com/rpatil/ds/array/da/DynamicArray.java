package com.rpatil.ds.array.da;

import com.rpatil.ds.array.Array;

public class DynamicArray implements Array<Integer> {
    private int size = 0;
    private static final int DEFAULT_RESIZE_FACTOR = 2;
    private static final int INITIAL_DEFAULT_SIZE = 16;

    @Override
    public boolean add(Integer element) {
        return false;
    }

    @Override
    public void add(int index, Integer element) {

    }

    @Override
    public Integer set(int index, Integer element) {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Integer get(int index) {
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
    public Integer remove(int index) {
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

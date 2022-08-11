package com.rpatil.ds.array;

public interface Array<E> {

    boolean add(E element);

    void add(int index, E element);

    E set(int index, E element);

    boolean contains(Object o);

    int size();

    boolean isEmpty();

    E get(int index);

    int indexOf(Object o);

    int lastIndexOf(Object o);

    E remove(int index);

    boolean remove(Object o);

    void clear();
}

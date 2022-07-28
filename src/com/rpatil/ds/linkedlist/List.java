package com.rpatil.ds.linkedlist;

public interface List {
    void addFirst(int value);

    void addLast(int value);

    void addAtIndex(int index, int value);

    boolean search(int key);

    Integer get(int index);

    int getIndex(int value);

    void delete(int value);

    boolean deleteAtIndex(int index);
}

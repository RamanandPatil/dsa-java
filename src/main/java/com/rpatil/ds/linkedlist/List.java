package com.rpatil.ds.linkedlist;

public interface List {
    void addFirst(int value);

    void addLast(int value);

    void addAtIndex(int index, int value);

    boolean search(int key);

    int get(int index);

    int indexOf(int value);

    void delete(int value);

    boolean deleteAtIndex(int index);
}

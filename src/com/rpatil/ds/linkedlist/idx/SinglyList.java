package com.rpatil.ds.linkedlist.idx;

public interface SinglyList {

    int get(int index);

    void addAtHead(int value);

    void addAtTail(int value);

    void addAtIndex(int index, int value);

    void deleteAtIndex(int index);

    int delete(int value);
}

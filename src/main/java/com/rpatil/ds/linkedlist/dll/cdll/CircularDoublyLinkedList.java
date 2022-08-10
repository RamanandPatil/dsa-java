package com.rpatil.ds.linkedlist.dll.cdll;

import com.rpatil.ds.linkedlist.List;

public class CircularDoublyLinkedList implements List {

    Node head;

    public CircularDoublyLinkedList(int value) {
        head = new Node(value);
        head.next = head;
        head.prev = head;
    }

    public CircularDoublyLinkedList() {
    }

    @Override
    public void addFirst(int value) {
        if (head == null) {
            head = new Node(value);
            head.next = head;
            head.prev = head;
            return;
        }

        Node newNode = new Node(value);
        newNode.next = head;
        head.prev = newNode;

        Node lastNode = head;
        while (lastNode.next != head) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
        newNode.prev = lastNode;

        head = newNode;
    }

    @Override
    public void addLast(int value) {
        if (head == null) {
            head = new Node(value);
            head.next = head;
            head.prev = head;
            return;
        }

        Node newNode = new Node(value);
        newNode.next = head;
        head.prev = newNode;

        Node lastNode = head;
        while (lastNode.next != head) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
        newNode.prev = lastNode;
    }

    @Override
    public void addAtIndex(int index, int value) {
        if (index < 0) {
            return;
        }
        if (head == null && index > 0) {
            System.err.println("Not enough size to add at the index " + index);
            return;
        }
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node temp = head;
        int pointer = 0;
        while (temp.next != head && pointer != index) {
            temp = temp.next;
            pointer++;
        }

        Node node = new Node(value);

        // if adding at last:
        if (temp.next == head && pointer != index) {
            temp.next = node;
            node.next = head;
            node.prev = temp;
            return;
        }
        temp.prev.next = node;
        node.next = temp;
        node.prev = temp.prev;
        temp.prev = node;
    }

    @Override
    public boolean search(int key) {
        if (head == null) {
            return false;
        }
        if (head.data == key) {
            return true;
        }
        Node temp = head;
        while (temp.next != head) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        // Check the last node
        return temp.data == key;
    }

    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public int indexOf(int value) {
        return 0;
    }

    @Override
    public void delete(int value) {

    }

    @Override
    public boolean deleteAtIndex(int index) {
        return false;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Node node = head;
        sb.append(node.data);
        while (node.next != head) {
            node = node.next;
            sb.append("<->").append(node.data);
        }
        return sb.toString();
    }


    private static class Node {
        private final int data;
        private Node prev;
        private Node next;

        public Node(int value) {
            data = value;
            prev = null;
            next = null;
        }
    }
}



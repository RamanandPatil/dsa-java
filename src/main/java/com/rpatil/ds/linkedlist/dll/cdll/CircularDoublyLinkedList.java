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
        if (index < 0 || head == null) {
            return -1;
        }
        Node node = head;
        int pointer = 0;
        while (node.next != head && pointer != index) {
            node = node.next;
            pointer++;
        }
        if (node.next == head && pointer != index) {
            System.err.println(
                    "Index is larger than size of the list, returning last " +
                    "element");
        }
        return node.data;
    }

    @Override
    public int indexOf(int value) {
        if (head == null) {
            return -1;
        }
        Node node = head;
        int index = 0;
        while (node.data != value && node.next != head) {
            node = node.next;
            index++;
        }
        if (node.data == value) {
            return index;
        }
        return -1;

    }

    @Override
    public void delete(int value) {
        if (head == null) {
            System.err.println("CircularDoublyLinkedList is empty");
            return;
        }
        Node temp = head;
        while (temp.data != value && temp.next != head) {
            temp = temp.next;
        }
        // We found the value to be deleted
        if (temp.data == value) {
            // if it is a first node
            if (temp == head) {
                // If it is the only value
                if (temp.next == head) {
                    head = null;
                } else {
                    head.prev.next = head.next;
                    head = head.next;
                }
            } else if (temp.next == head) { // if it is a last node
                temp.prev.next = head;
            } else {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
        } else {
            System.err.println(
                    "Given value not found in the CircularDoublyLinkedList");
        }
    }

    @Override
    public boolean deleteAtIndex(int index) {
        if (head == null || index < 0) {
            return false;
        }
        if (index == 0) {
            delete(head.data);
            return true;
        }
        Node temp = head;
        int pointer = 0;
        while (pointer != index && temp.next != head) {
            pointer++;
            temp = temp.next;
        }
        // Check if we have reached end before the index, meaning index is
        // bigger than the size
        if (pointer < index) {
            System.err.println("List Index is out of bounds");
            return false;
        }
        // Check if we are deleting the last node
        if (temp.next == head) {
            // This is the current design: delete the last node if index is
            // greater than the size of the CircularSinglyLinkedList
            System.err.println(
                    "Deleting the last node as index is Out of bounds of " +
                    "CircularSinglyLinkedList");
            temp.prev.next = head;
            return false;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        return true;
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



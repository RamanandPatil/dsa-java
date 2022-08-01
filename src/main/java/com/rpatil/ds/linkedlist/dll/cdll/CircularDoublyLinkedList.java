package com.rpatil.ds.linkedlist.dll.cdll;

public class CircularDoublyLinkedList {

    Node head;

    public CircularDoublyLinkedList(int value) {
        head = new Node(value);
        head.next = head;
        head.prev = head;
    }

    public CircularDoublyLinkedList() {
    }

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


    public void delete(int value) {

    }

    public boolean search(int key) {
        return false;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = head;
        if (head == null)
            return "";
        sb.append(node.data).append(" ");
        while (node.next != head) {
            sb.append(node.next.data).append(" ");
            node = node.next;
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



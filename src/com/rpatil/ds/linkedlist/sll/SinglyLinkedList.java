package com.rpatil.ds.linkedlist.sll;

public class SinglyLinkedList {

    Node head;

    public SinglyLinkedList(int value) {
        head = new Node(value);
    }

    public SinglyLinkedList() {

    }

    public void addFirst(int value) {
        Node firstNode = new Node(value);
        firstNode.next = head;
        head = firstNode;
    }

    public void addLast(int value) {
        Node lastNode = new Node(value);
        if (head == null) {
            head = lastNode;
            return;
        }
        Node tempLast = head;
        while (tempLast.next != null) {
            tempLast = tempLast.next;
        }
        tempLast.next = lastNode;
    }


    public void delete(int value) {
        if (head == null) {
            return;
        }
        if (head.data == value) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }
    }

    public boolean search(int key) {
        if (head == null) {
            return false;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = head;
        while (node != null) {
            sb.append(node.data).append(" ");
            node = node.next;
        }
        return sb.toString();
    }

    private static class Node {
        private final int data;
        private Node next;

        public Node(int value) {
            data = value;
            next = null;
        }
    }
}



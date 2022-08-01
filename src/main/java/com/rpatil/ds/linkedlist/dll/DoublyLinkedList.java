package com.rpatil.ds.linkedlist.dll;

public class DoublyLinkedList {
    Node head;
    public DoublyLinkedList(int value) {
        head = new Node(value);
    }

    public DoublyLinkedList() {
    }

    public void addFirst(int value) {
        if (head == null) {
            head = new Node(value);
            return;
        }
        Node node = new Node(value);
        node.next = head;
        head.prev = node;
        head = node;
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
    }


    public void delete(int value) {
        Node temp = head;
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println(
                    "Value " + value +
                    " not found in the CircularSinglyLinkedList");
            return;
        }
        if (temp == head) {
            // head is the only node
            if (head.next == null) {
                head = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        } else {
            if (temp.next != null) {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            } else {
                temp.prev.next = null;
            }
        }
    }

    public boolean search(int key) {
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
        private Node prev;
        private Node next;

        public Node(int value) {
            data = value;
            prev = null;
            next = null;
        }
    }
}



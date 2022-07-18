package com.rpatil.ds.linkedlist.sll.csll;

import org.w3c.dom.Node;

public class CircularSinglyLinkedList {

    Node head;

    public CircularSinglyLinkedList(int value) {
        head = new Node(value);
        head.next = head;
    }

    public CircularSinglyLinkedList() {
    }

    public void addFirst(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            head.next = head;
            return;
        }
        // Search the last node(which is pointing to head node) and
        // set it's next to the node to be inserted.
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = node;

        // Set new node's next to head and make new node as new head
        node.next = head;
        head = node;
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            head.next = head;
            return;
        }
        // Search the last node starting from head node
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        // Now, temp is the last node as it points back to head.
        // Add the new node at the last:
        temp.next = node;
        node.next = head;
    }


    public void delete(int value) {
        // 1. CircularSinglyLinkedList is empty
        if (head == null) {
            return;
        }

        // 2. CircularSinglyLinkedList head contains the value to be deleted
        if (head.data == value) {
            // Only one node (i.e. head) present
            if (head.next == head) {
                head = null;
            } else {
                // Find the last node pointing to head, before deleting the head
                Node temp = head.next;
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = head.next;
                head = head.next;
            }
            return;
        }
        // 3. Value to be deleted is not a head but other value in
        // CircularSinglyLinkedList
        Node currentNode = head;
        Node nextNode = currentNode.next;
        while (currentNode.next != head) {
            if (nextNode.data == value) {
                nextNode = nextNode.next;
                currentNode.next = nextNode;
                return;
            }
            currentNode = nextNode;
            nextNode = currentNode.next;
        }
    }

    public boolean search(int key) {
        if (head == null) {
            return false;
        }
        if (head.data == key) {
            return true;
        }
        Node temp = head.next;
        while (temp != head) {
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
        if (head == null) {
            return "";
        }
        sb.append(node.data).append(" ");
        while (node.next != head) {
            sb.append(node.next.data).append(" ");
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



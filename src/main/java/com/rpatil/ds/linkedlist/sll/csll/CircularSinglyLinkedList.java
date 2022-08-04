package com.rpatil.ds.linkedlist.sll.csll;

import com.rpatil.ds.linkedlist.List;

public class CircularSinglyLinkedList implements List {

    private Node head;

    public CircularSinglyLinkedList(int value) {
        head = new Node(value);
        head.next = head;
    }

    public CircularSinglyLinkedList() {
    }

    @Override
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
        int pointer = 1;
        while (temp.next != head && pointer != index) {
            temp = temp.next;
            pointer++;
        }
        Node node = new Node(value);
        // if the index is the last index
        if (temp.next == head) {
            addLast(value);
        } else {
            Node nextNode = temp.next;
            temp.next = node;
            node.next = nextNode;
        }
    }

    @Override
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
        if (node.next == head) {
            System.err.println("Returning last element");
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
        while (node.next != head) {
            if (node.data == value) {
                return index;
            }
            node = node.next;
            index++;
        }
        if (node.data == value) {
            return index;
        } else {
            System.err.println(
                    "CircularSinglyLinkedList doesn't have the value: " +
                    value);
            return -1;
        }

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

    @Override
    public boolean deleteAtIndex(int index) {
        if (head == null || index < 0) {
            return false;
        }
        Node node = head;
        Node prev = node;
        int pointer = 0;
        while (node.next != head && pointer != index) {
            prev = node;
            node = prev.next;
            pointer++;
        }
        // Check if we have reached end before the index, meaning index is bigger than the size
        if (pointer < index) {
            System.err.println("List Index is out of bounds");
            return false;
        }
        // Check if we are deleting the last node
        if (node.next == head) {
            // This is the current design: delete the last node if index is
            // greater than the size of the CircularSinglyLinkedList
            System.err.println(
                    "Deleting the last node as index is Out of bounds of " +
                    "CircularSinglyLinkedList");
            prev.next = head;
            return false;
        } else {
            // This is we are deleting first node, i.e. head node
            if (prev == node) {
                while (node.next != head) {
                    node = node.next;
                }
                node.next = prev.next;
                head = head.next;
            } else {
                prev.next = node.next;
            }
            return true;
        }
    }


    @Override
    public String toString() {
        Node node = head;
        StringBuilder sb = new StringBuilder();
        if (node == null) {
            return "";
        } else {
            sb.append(node.data);
        }
        while (node.next != head) {
            node = node.next;
            sb.append("->").append(node.data);
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

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.data);
            Node node = this.next;
            while (node != null && node != this) {
                sb.append(">").append(node.data);
                node = node.next;
            }
            return sb.toString();
        }
    }
}



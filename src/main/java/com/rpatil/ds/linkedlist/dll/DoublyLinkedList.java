package com.rpatil.ds.linkedlist.dll;

import com.rpatil.ds.linkedlist.List;

public class DoublyLinkedList implements List {
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

    @Override
    public void addAtIndex(int index, int value) {
        if (index < 0) {
            return;
        }
        if (index == 0 || head == null) {
            if (index > 0) {
                System.err.println(
                        "List is empty adding first item at index 0");
            }
            addFirst(value);
            return;
        }
        Node temp = head;
        int pointer = 0;
        while (temp.next != null && pointer != index) {
            temp = temp.next;
            pointer++;
        }
        // Last item check
        if (temp.next == null && pointer != index) {
            // Still index is bigger than the size of the list, adding item
            // to last
            if (pointer < index) {
                System.err.println(
                        "Index is larger than the size of a List, adding " +
                        "element at last index = " +
                        pointer);
            }
            addLast(value);
            return;
        }

        Node node = new Node(value);
        node.next = temp;
        node.prev = temp.prev;
        temp.prev.next = node;
        temp.prev = node;
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
    public int get(int index) {
        if (index < 0 || head == null) {
            return -1;
        }
        Node node = head;
        int pointer = 0;
        while (node.next != null && pointer != index) {
            node = node.next;
            pointer++;
        }
        if (pointer != index) {
            System.err.println("Reached end of list, returning last item");
        }
        return node.data;
    }

    @Override
    public int indexOf(int value) {
        if (head == null)
            return -1;
        Node node = head;
        int index = 0;
        while (node.data != value && node.next != null) {
            node = node.next;
            index++;
        }
        if (node.next == null && node.data != value) {
            System.err.println("Last node reached, value not found");
            return -1;
        }
        return index;
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

    @Override
    public boolean deleteAtIndex(int index) {
        return false;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = head;
        while (node != null) {
            sb.append(node.data);
            node = node.next;
            if (node != null) {
                sb.append("->");
            }
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

        @Override
        public String toString() {
            return "Node{" +
                   "data=" + data +
                   ", prev=" + (prev == null ? "null" : prev.data) +
                   ", next=" + (next == null ? "null" : next.data) +
                   '}';
        }
    }
}



package com.rpatil.ds.linkedlist.sll;

import com.rpatil.ds.linkedlist.List;

public class SinglyLinkedList implements List {

    Node head;

    public SinglyLinkedList() {

    }

    public SinglyLinkedList(int value) {
        head = new Node(value);
    }

    @Override
    public void addFirst(int value) {
        Node firstNode = new Node(value);
        firstNode.next = head;
        head = firstNode;
    }

    @Override
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

    @Override
    public void addAtIndex(int index, int value) {
        if (index < 0) {
            return;
        }
        if (index == 0 || head == null) {
            addFirst(value);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
            if (temp == null) {
                System.err.println(
                        "Index is larger than LinkedList size. Adding value " +
                        "at end");
                addLast(value);
                return;
            }
        }

        Node node = new Node(value);
        node.next = temp.next;
        temp.next = node;

    }

    @Override
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
    public Integer get(int index) {
        if (index < 0 || head == null) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            if (temp.next == null) {
                System.err.println(
                        "Index is larger than LinkedList size. Returning last" +
                        " item");
                return temp.data;
            }
            temp = temp.next;
        }
        return temp.data;
    }

    @Override
    public int getIndex(int value) {
        int index = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    @Override
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

    @Override
    public boolean deleteAtIndex(int index) {
        if (head == null || index < 0) {
            return false;
        } else if (index == 0) {
            if (head.next == null) {
                head = null;
            } else {
                delete(head.data);
            }
            return true;
        }
        Node temp = head;
        while (temp.next != null && index >= 1) {
            temp = temp.next;
            index = index - 1;
        }
        if (temp.next == null) {
            System.err.println("Index is out of LinkedList bounds");
            return false;
        } else {
            // See if we are deleting the last node
            if (temp.next.next == null) {
                temp.next = null;
            } else {
                temp = temp.next.next;
            }
        }
        return true;
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
        private Node next;

        public Node(int value) {
            data = value;
            next = null;
        }
    }
}



package com.rpatil.ds.linkedlist.dll;

public class DoublyLinkedListTest {
    public static void main(String[] args) {
        DoublyLinkedList list1 = new DoublyLinkedList();
        DoublyLinkedList list2 = new DoublyLinkedList(10);

        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
        System.out.println();

        System.out.println("Add 10 to list1 using addFirst");
        list1.addFirst(10);
        System.out.println("list1: " + list1);
        System.out.println("Add 1 to list1 using addFirst");
        list1.addFirst(1);
        System.out.println("list1: " + list1);
        System.out.println("Add 0 to list1 using addFirst");
        list1.addFirst(0);
        System.out.println("list1: " + list1);
        System.out.println();

        System.out.println("Add 1 to list2 using addFirst");
        list2.addFirst(1);
        System.out.println("list2: " + list2);
        System.out.println("Add 0 to list2 using addFirst");
        list2.addFirst(0);
        System.out.println("list2: " + list2);
        System.out.println();

        System.out.println("Add 100 to list1 using addLast");
        list1.addLast(100);
        System.out.println("list1: " + list1);
        System.out.println("Add 1000 to list1 using addLast");
        list1.addLast(1000);
        System.out.println("list1: " + list1);
        System.out.println();

        System.out.println("Add 100 to list2 using addLast");
        list2.addLast(100);
        System.out.println("list2: " + list2);
        System.out.println("Add 1000 to list2 using addLast");
        list2.addLast(1000);
        System.out.println("list2: " + list2);
        System.out.println();

        System.out.println("Remove 0 from list1 using delete");
        list1.delete(0);
        System.out.println("list1: " + list1);
        System.out.println("Remove 1000 from list1 using delete");
        list1.delete(1000);
        System.out.println("list1: " + list1);
        System.out.println();

        System.out.println("Remove 1 from list2 using delete");
        list2.delete(1);
        System.out.println("list2: " + list2);
        System.out.println("Remove 100 from list2 using delete");
        list2.delete(100);
        System.out.println("list2: " + list2);
        System.out.println();

        System.out.print("Is 1 present in list1: ");
        System.out.println(list1.search(1));
        System.out.print("Is 100 present in list1: ");
        System.out.println(list1.search(100));
        System.out.print("Is 1000 present in list1: ");
        System.out.println(list1.search(1000));
        System.out.println();

        System.out.print("Is 1 present in list2: ");
        System.out.println(list2.search(1));
        System.out.print("Is 100 present in list2: ");
        System.out.println(list2.search(100));
        System.out.print("Is 1000 present in list2: ");
        System.out.println(list2.search(1000));
        System.out.println();
    }
}

package com.rpatil.ds.linkedlist.sll;

import org.testng.Assert;

public class SinglyLinkedListTest {
    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList(10);

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

        System.out.println("Add 0 to list1 at index 0");
        list1.addAtIndex(0, 0);
        System.out.println("list1: " + list1);
        System.out.println("Add 2 to list1 at index 2");
        list1.addAtIndex(2, 2);
        System.out.println("list1: " + list1);
        System.out.println();

        System.out.println("Add 1 to list2 at index 1");
        list2.addAtIndex(1, 1);
        System.out.println("list2: " + list2);
        System.out.println("Add 4 to list2 at index 4");
        list2.addAtIndex(4, 4);
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

    SinglyLinkedList sll1;
    SinglyLinkedList sll2;
    @org.testng.annotations.BeforeMethod
    public void setUp() {
        sll1 = new SinglyLinkedList();
        sll2 = new SinglyLinkedList(15);
    }

    @org.testng.annotations.AfterMethod
    public void tearDown() {
        sll1 = null;
        sll2 = null;
    }

    @org.testng.annotations.Test
    public void testAddFirst() {
        sll1.addFirst(15);
        sll1.addFirst(10);
        sll1.addFirst(5);
        sll1.addFirst(0);
        Assert.assertEquals(sll1.toString(), "0->5->10->15");

        sll2.addFirst(10);
        sll2.addFirst(5);
        sll2.addFirst(0);
        Assert.assertEquals(sll2.toString(), "0->5->10->15");
    }

    @org.testng.annotations.Test
    public void testAddLast() {
        sll1.addLast(15);
        sll1.addLast(10);
        sll1.addLast(5);
        sll1.addLast(0);
        Assert.assertEquals(sll1.toString(), "15->10->5->0");

        sll2.addLast(10);
        sll2.addLast(5);
        sll2.addLast(0);
        Assert.assertEquals(sll2.toString(), "15->10->5->0");
    }

    @org.testng.annotations.Test
    public void testAddAtIndex() {
        sll1.addAtIndex(0, 15);
        sll1.addAtIndex(1, 5);
        sll1.addAtIndex(1, 10);
        sll1.addAtIndex(3, 0);
        Assert.assertEquals(sll1.toString(), "15->10->5->0");

        sll2.addAtIndex(1, 5);
        sll2.addAtIndex(1, 10);
        sll2.addAtIndex(3, 0);
        Assert.assertEquals(sll2.toString(), "15->10->5->0");
    }

    @org.testng.annotations.Test
    public void testSearch() {
    }

    @org.testng.annotations.Test
    public void testGet() {
    }

    @org.testng.annotations.Test
    public void testGetIndex() {
    }

    @org.testng.annotations.Test
    public void testDelete() {
    }

    @org.testng.annotations.Test
    public void testDeleteAtIndex() {
    }

    @org.testng.annotations.Test
    public void testTestToString() {
        SinglyLinkedList sll = new SinglyLinkedList(10);
        sll.addFirst(5);
        sll.addFirst(0);
        sll.addLast(15);
        sll.addLast(20);

        Assert.assertEquals(sll.toString(), "0->5->10->15->20");
    }
}

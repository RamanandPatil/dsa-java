package com.rpatil.ds.linkedlist.sll;

import org.testng.Assert;

public class SinglyLinkedListTest {
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
        sll1.addFirst(15);
        sll1.addFirst(10);
        sll1.addFirst(5);
        sll1.addFirst(0);
        Assert.assertTrue(sll1.search(0));
        Assert.assertTrue(sll1.search(5));
        Assert.assertTrue(sll1.search(10));
        Assert.assertTrue(sll1.search(15));
        Assert.assertFalse(sll1.search(20));

        sll2.addFirst(10);
        sll2.addFirst(5);
        sll2.addFirst(0);
        Assert.assertTrue(sll2.search(10));
        Assert.assertTrue(sll2.search(15));
        Assert.assertFalse(sll2.search(20));
        Assert.assertFalse(sll2.search(25));
    }

    @org.testng.annotations.Test
    public void testGet() {
        sll1.addFirst(15);
        sll1.addFirst(10);
        sll1.addFirst(5);
        sll1.addFirst(0);
        Assert.assertEquals(sll1.get(0), 0);
        Assert.assertEquals(sll1.get(1), 5);
        Assert.assertEquals(sll1.get(2), 10);
        Assert.assertEquals(sll1.get(3), 15);
        Assert.assertEquals(sll1.get(4), -1);

        sll2.addFirst(10);
        sll2.addFirst(5);
        sll2.addFirst(0);
        Assert.assertEquals(sll1.get(1), 5);
        Assert.assertEquals(sll1.get(2), 10);
        Assert.assertEquals(sll1.get(3), 15);
        Assert.assertEquals(sll1.get(4), -1);
        Assert.assertEquals(sll1.get(5), -1);
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

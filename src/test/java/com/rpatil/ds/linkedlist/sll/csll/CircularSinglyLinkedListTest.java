package com.rpatil.ds.linkedlist.sll.csll;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CircularSinglyLinkedListTest {

    CircularSinglyLinkedList sll1;
    CircularSinglyLinkedList sll2;

    @BeforeMethod
    public void setUp() {
        sll1 = new CircularSinglyLinkedList();
        sll2 = new CircularSinglyLinkedList(15);
    }

    @AfterMethod
    public void tearDown() {
        sll1 = null;
        sll2 = null;
    }


    @Test
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

    @Test
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

    @Test
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

    @Test
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

    @Test
    public void testGet() {
        sll1.addFirst(15);
        sll1.addFirst(10);
        sll1.addFirst(5);
        sll1.addFirst(0);
        Assert.assertEquals(sll1.get(0), 0);
        Assert.assertEquals(sll1.get(1), 5);
        Assert.assertEquals(sll1.get(2), 10);
        Assert.assertEquals(sll1.get(3), 15);
        Assert.assertEquals(sll1.get(4), 15);

        sll2.addFirst(10);
        sll2.addFirst(5);
        sll2.addFirst(0);
        Assert.assertEquals(sll1.get(1), 5);
        Assert.assertEquals(sll1.get(2), 10);
        Assert.assertEquals(sll1.get(3), 15);
        Assert.assertEquals(sll1.get(4), 15);
        Assert.assertEquals(sll1.get(5), 15);
    }

    @Test
    public void testIndexOf() {
        sll1.addFirst(15);
        sll1.addFirst(10);
        sll1.addFirst(5);
        sll1.addFirst(0);
        Assert.assertEquals(sll1.indexOf(0), 0);
        Assert.assertEquals(sll1.indexOf(5), 1);
        Assert.assertEquals(sll1.indexOf(10), 2);
        Assert.assertEquals(sll1.indexOf(15), 3);
        Assert.assertEquals(sll1.indexOf(20), -1);

        sll2.addFirst(10);
        sll2.addFirst(5);
        sll2.addFirst(0);
        Assert.assertEquals(sll2.indexOf(0), 0);
        Assert.assertEquals(sll2.indexOf(5), 1);
        Assert.assertEquals(sll2.indexOf(10), 2);
        Assert.assertEquals(sll2.indexOf(15), 3);
        Assert.assertEquals(sll2.indexOf(20), -1);
        Assert.assertEquals(sll2.indexOf(25), -1);
    }

    @Test
    public void testDelete() {
        sll1.addFirst(15);
        sll1.addFirst(10);
        sll1.addFirst(5);
        sll1.addFirst(0);

        Assert.assertEquals(sll1.indexOf(0), 0);
        sll1.delete(0);
        Assert.assertEquals(sll1.indexOf(0), -1);

        Assert.assertEquals(sll1.indexOf(10), 1);
        sll1.delete(10);
        Assert.assertEquals(sll1.indexOf(10), -1);

        Assert.assertEquals(sll1.indexOf(20), -1);
        sll1.delete(20);
        Assert.assertEquals(sll1.indexOf(20), -1);


        sll2.addFirst(10);
        sll2.addFirst(5);
        sll2.addFirst(0);

        Assert.assertEquals(sll2.indexOf(5), 1);
        sll2.delete(5);
        Assert.assertEquals(sll2.indexOf(5), -1);

        Assert.assertEquals(sll2.indexOf(15), 2);
        sll2.delete(15);
        Assert.assertEquals(sll2.indexOf(15), -1);

        Assert.assertEquals(sll2.indexOf(10), 1);
        sll2.delete(10);
        Assert.assertEquals(sll2.indexOf(10), -1);

        Assert.assertEquals(sll2.indexOf(20), -1);
        sll2.delete(20);
        Assert.assertEquals(sll2.indexOf(20), -1);
    }

    @Test
    public void testDeleteAtIndex() {
        sll1.addFirst(15);
        sll1.addFirst(10);
        sll1.addFirst(5);
        sll1.addFirst(0);

        Assert.assertEquals(sll1.indexOf(0), 0);
        sll1.deleteAtIndex(0);
        Assert.assertEquals(sll1.indexOf(0), -1);

        Assert.assertEquals(sll1.indexOf(15), 2);
        sll1.deleteAtIndex(2);
        Assert.assertEquals(sll1.indexOf(15), -1);

        Assert.assertEquals(sll1.indexOf(10), 1);
        sll1.deleteAtIndex(2);
        Assert.assertEquals(sll1.indexOf(10), 1);


        sll2.addFirst(10);
        sll2.addFirst(5);
        sll2.addFirst(0);

        Assert.assertEquals(sll2.indexOf(5), 1);
        sll2.deleteAtIndex(1);
        Assert.assertEquals(sll2.indexOf(5), -1);

        Assert.assertEquals(sll2.indexOf(15), 2);
        sll2.deleteAtIndex(2);
        Assert.assertEquals(sll2.indexOf(15), -1);

        Assert.assertEquals(sll2.indexOf(10), 1);
        sll2.deleteAtIndex(1);
        Assert.assertEquals(sll2.indexOf(10), -1);

        Assert.assertEquals(sll2.indexOf(0), 0);
        sll2.deleteAtIndex(-1);
        Assert.assertEquals(sll2.indexOf(0), 0);
    }

    @Test
    public void testTestToString() {
        sll1.addFirst(15);
        sll1.addFirst(10);
        sll1.addFirst(5);
        sll1.addFirst(0);
        sll1.addLast(20);

        sll2.addFirst(20);
        sll2.addFirst(10);
        sll2.addFirst(0);
        sll2.addLast(30);


        Assert.assertEquals(sll1.toString(), "0->5->10->15->20");
        Assert.assertEquals(sll2.toString(), "0->10->20->15->30");
    }
}

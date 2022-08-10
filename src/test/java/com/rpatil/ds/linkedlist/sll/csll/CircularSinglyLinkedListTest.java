package com.rpatil.ds.linkedlist.sll.csll;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CircularSinglyLinkedListTest {

    CircularSinglyLinkedList csll1;
    CircularSinglyLinkedList csll2;

    @BeforeMethod
    public void setUp() {
        csll1 = new CircularSinglyLinkedList();
        csll2 = new CircularSinglyLinkedList(15);
    }

    @AfterMethod
    public void tearDown() {
        csll1 = null;
        csll2 = null;
    }


    @Test
    public void testAddFirst() {
        csll1.addFirst(15);
        csll1.addFirst(10);
        csll1.addFirst(5);
        csll1.addFirst(0);
        Assert.assertEquals(csll1.toString(), "0->5->10->15");

        csll2.addFirst(10);
        csll2.addFirst(5);
        csll2.addFirst(0);
        Assert.assertEquals(csll2.toString(), "0->5->10->15");
    }

    @Test
    public void testAddLast() {
        csll1.addLast(15);
        csll1.addLast(10);
        csll1.addLast(5);
        csll1.addLast(0);
        Assert.assertEquals(csll1.toString(), "15->10->5->0");

        csll2.addLast(10);
        csll2.addLast(5);
        csll2.addLast(0);
        Assert.assertEquals(csll2.toString(), "15->10->5->0");
    }

    @Test
    public void testAddAtIndex() {
        csll1.addAtIndex(0, 15);
        csll1.addAtIndex(1, 5);
        csll1.addAtIndex(1, 10);
        csll1.addAtIndex(3, 0);
        Assert.assertEquals(csll1.toString(), "15->10->5->0");

        csll2.addAtIndex(1, 5);
        csll2.addAtIndex(1, 10);
        csll2.addAtIndex(3, 0);
        Assert.assertEquals(csll2.toString(), "15->10->5->0");
    }

    @Test
    public void testSearch() {
        csll1.addFirst(15);
        csll1.addFirst(10);
        csll1.addFirst(5);
        csll1.addFirst(0);
        Assert.assertTrue(csll1.search(0));
        Assert.assertTrue(csll1.search(5));
        Assert.assertTrue(csll1.search(10));
        Assert.assertTrue(csll1.search(15));
        Assert.assertFalse(csll1.search(20));

        csll2.addFirst(10);
        csll2.addFirst(5);
        csll2.addFirst(0);
        Assert.assertTrue(csll2.search(10));
        Assert.assertTrue(csll2.search(15));
        Assert.assertFalse(csll2.search(20));
        Assert.assertFalse(csll2.search(25));
    }

    @Test
    public void testGet() {
        csll1.addFirst(15);
        csll1.addFirst(10);
        csll1.addFirst(5);
        csll1.addFirst(0);
        Assert.assertEquals(csll1.get(0), 0);
        Assert.assertEquals(csll1.get(1), 5);
        Assert.assertEquals(csll1.get(2), 10);
        Assert.assertEquals(csll1.get(3), 15);
        Assert.assertEquals(csll1.get(4), 15);

        csll2.addFirst(10);
        csll2.addFirst(5);
        csll2.addFirst(0);
        Assert.assertEquals(csll1.get(1), 5);
        Assert.assertEquals(csll1.get(2), 10);
        Assert.assertEquals(csll1.get(3), 15);
        Assert.assertEquals(csll1.get(4), 15);
        Assert.assertEquals(csll1.get(5), 15);
    }

    @Test
    public void testIndexOf() {
        csll1.addFirst(15);
        csll1.addFirst(10);
        csll1.addFirst(5);
        csll1.addFirst(0);
        Assert.assertEquals(csll1.indexOf(0), 0);
        Assert.assertEquals(csll1.indexOf(5), 1);
        Assert.assertEquals(csll1.indexOf(10), 2);
        Assert.assertEquals(csll1.indexOf(15), 3);
        Assert.assertEquals(csll1.indexOf(20), -1);

        csll2.addFirst(10);
        csll2.addFirst(5);
        csll2.addFirst(0);
        Assert.assertEquals(csll2.indexOf(0), 0);
        Assert.assertEquals(csll2.indexOf(5), 1);
        Assert.assertEquals(csll2.indexOf(10), 2);
        Assert.assertEquals(csll2.indexOf(15), 3);
        Assert.assertEquals(csll2.indexOf(20), -1);
        Assert.assertEquals(csll2.indexOf(25), -1);
    }

    @Test
    public void testDelete() {
        csll1.addFirst(15);
        csll1.addFirst(10);
        csll1.addFirst(5);
        csll1.addFirst(0);

        Assert.assertEquals(csll1.indexOf(0), 0);
        csll1.delete(0);
        Assert.assertEquals(csll1.indexOf(0), -1);

        Assert.assertEquals(csll1.indexOf(10), 1);
        csll1.delete(10);
        Assert.assertEquals(csll1.indexOf(10), -1);

        Assert.assertEquals(csll1.indexOf(20), -1);
        csll1.delete(20);
        Assert.assertEquals(csll1.indexOf(20), -1);


        csll2.addFirst(10);
        csll2.addFirst(5);
        csll2.addFirst(0);

        Assert.assertEquals(csll2.indexOf(5), 1);
        csll2.delete(5);
        Assert.assertEquals(csll2.indexOf(5), -1);

        Assert.assertEquals(csll2.indexOf(15), 2);
        csll2.delete(15);
        Assert.assertEquals(csll2.indexOf(15), -1);

        Assert.assertEquals(csll2.indexOf(10), 1);
        csll2.delete(10);
        Assert.assertEquals(csll2.indexOf(10), -1);

        Assert.assertEquals(csll2.indexOf(20), -1);
        csll2.delete(20);
        Assert.assertEquals(csll2.indexOf(20), -1);
    }

    @Test
    public void testDeleteAtIndex() {
        csll1.addFirst(15);
        csll1.addFirst(10);
        csll1.addFirst(5);
        csll1.addFirst(0);

        Assert.assertEquals(csll1.indexOf(0), 0);
        csll1.deleteAtIndex(0);
        Assert.assertEquals(csll1.indexOf(0), -1);

        Assert.assertEquals(csll1.indexOf(15), 2);
        csll1.deleteAtIndex(2);
        Assert.assertEquals(csll1.indexOf(15), -1);

        Assert.assertEquals(csll1.indexOf(10), 1);
        csll1.deleteAtIndex(2);
        Assert.assertEquals(csll1.indexOf(10), 1);


        csll2.addFirst(10);
        csll2.addFirst(5);
        csll2.addFirst(0);

        Assert.assertEquals(csll2.indexOf(5), 1);
        csll2.deleteAtIndex(1);
        Assert.assertEquals(csll2.indexOf(5), -1);

        Assert.assertEquals(csll2.indexOf(15), 2);
        csll2.deleteAtIndex(2);
        Assert.assertEquals(csll2.indexOf(15), -1);

        Assert.assertEquals(csll2.indexOf(10), 1);
        csll2.deleteAtIndex(1);
        Assert.assertEquals(csll2.indexOf(10), -1);

        Assert.assertEquals(csll2.indexOf(0), 0);
        csll2.deleteAtIndex(-1);
        Assert.assertEquals(csll2.indexOf(0), 0);
    }

    @Test
    public void testTestToString() {
        csll1.addFirst(15);
        csll1.addFirst(10);
        csll1.addFirst(5);
        csll1.addFirst(0);
        csll1.addLast(20);

        csll2.addFirst(20);
        csll2.addFirst(10);
        csll2.addFirst(0);
        csll2.addLast(30);


        Assert.assertEquals(csll1.toString(), "0->5->10->15->20");
        Assert.assertEquals(csll2.toString(), "0->10->20->15->30");
    }
}

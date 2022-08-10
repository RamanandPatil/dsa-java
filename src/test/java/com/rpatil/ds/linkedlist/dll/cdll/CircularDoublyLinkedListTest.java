package com.rpatil.ds.linkedlist.dll.cdll;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CircularDoublyLinkedListTest {
    CircularDoublyLinkedList cdll1;
    CircularDoublyLinkedList cdll2;

    @BeforeMethod
    public void setUp() {
        cdll1 = new CircularDoublyLinkedList();
        cdll2 = new CircularDoublyLinkedList(15);
    }

    @AfterMethod
    public void tearDown() {
        cdll1 = null;
        cdll2 = null;
    }

    @Test
    public void testAddFirst() {
        cdll1.addFirst(15);
        cdll1.addFirst(10);
        cdll1.addFirst(5);
        cdll1.addFirst(0);
        Assert.assertEquals(cdll1.toString(), "0<->5<->10<->15");

        cdll2.addFirst(10);
        cdll2.addFirst(5);
        cdll2.addFirst(0);
        Assert.assertEquals(cdll2.toString(), "0<->5<->10<->15");
    }

    @Test
    public void testAddLast() {
        cdll1.addLast(15);
        cdll1.addLast(10);
        cdll1.addLast(5);
        cdll1.addLast(0);
        Assert.assertEquals(cdll1.toString(), "15<->10<->5<->0");

        cdll2.addLast(10);
        cdll2.addLast(5);
        cdll2.addLast(0);
        Assert.assertEquals(cdll2.toString(), "15<->10<->5<->0");
    }

    @Test
    public void testAddAtIndex() {
        cdll1.addAtIndex(0, 15);
        cdll1.addAtIndex(1, 5);
        cdll1.addAtIndex(1, 10);
        cdll1.addAtIndex(3, 0);
        Assert.assertEquals(cdll1.toString(), "15<->10<->5<->0");

        cdll2.addAtIndex(1, 5);
        cdll2.addAtIndex(1, 10);
        cdll2.addAtIndex(3, 0);
        Assert.assertEquals(cdll2.toString(), "15<->10<->5<->0");
    }

    @Test
    public void testSearch() {
        cdll1.addFirst(15);
        cdll1.addFirst(10);
        cdll1.addFirst(5);
        cdll1.addFirst(0);
        Assert.assertTrue(cdll1.search(0));
        Assert.assertTrue(cdll1.search(5));
        Assert.assertTrue(cdll1.search(10));
        Assert.assertTrue(cdll1.search(15));
        Assert.assertFalse(cdll1.search(20));

        cdll2.addFirst(10);
        cdll2.addFirst(5);
        cdll2.addFirst(0);
        Assert.assertTrue(cdll2.search(10));
        Assert.assertTrue(cdll2.search(15));
        Assert.assertFalse(cdll2.search(20));
        Assert.assertFalse(cdll2.search(25));
    }

    @Test
    public void testGet() {
        cdll1.addFirst(15);
        cdll1.addFirst(10);
        cdll1.addFirst(5);
        cdll1.addFirst(0);
        Assert.assertEquals(cdll1.get(0), 0);
        Assert.assertEquals(cdll1.get(1), 5);
        Assert.assertEquals(cdll1.get(2), 10);
        Assert.assertEquals(cdll1.get(3), 15);
        Assert.assertEquals(cdll1.get(4), 15);

        cdll2.addFirst(10);
        cdll2.addFirst(5);
        cdll2.addFirst(0);
        Assert.assertEquals(cdll1.get(1), 5);
        Assert.assertEquals(cdll1.get(2), 10);
        Assert.assertEquals(cdll1.get(3), 15);
        Assert.assertEquals(cdll1.get(4), 15);
        Assert.assertEquals(cdll1.get(5), 15);
    }

    @Test
    public void testIndexOf() {
        cdll1.addFirst(15);
        cdll1.addFirst(10);
        cdll1.addFirst(5);
        cdll1.addFirst(0);
        Assert.assertEquals(cdll1.indexOf(0), 0);
        Assert.assertEquals(cdll1.indexOf(5), 1);
        Assert.assertEquals(cdll1.indexOf(10), 2);
        Assert.assertEquals(cdll1.indexOf(15), 3);
        Assert.assertEquals(cdll1.indexOf(20), -1);

        cdll2.addFirst(10);
        cdll2.addFirst(5);
        cdll2.addFirst(0);
        Assert.assertEquals(cdll2.indexOf(0), 0);
        Assert.assertEquals(cdll2.indexOf(5), 1);
        Assert.assertEquals(cdll2.indexOf(10), 2);
        Assert.assertEquals(cdll2.indexOf(15), 3);
        Assert.assertEquals(cdll2.indexOf(20), -1);
        Assert.assertEquals(cdll2.indexOf(25), -1);
    }

    @Test
    public void testDelete() {
    }

    @Test
    public void testDeleteAtIndex() {
    }

    @Test
    public void testTestToString() {
        cdll1.addFirst(15);
        cdll1.addFirst(10);
        cdll1.addFirst(5);
        cdll1.addFirst(0);
        cdll1.addLast(20);

        cdll2.addFirst(20);
        cdll2.addFirst(10);
        cdll2.addFirst(0);
        cdll2.addLast(30);


        Assert.assertEquals(cdll1.toString(), "0<->5<->10<->15<->20");
        Assert.assertEquals(cdll2.toString(), "0<->10<->20<->15<->30");
    }
}

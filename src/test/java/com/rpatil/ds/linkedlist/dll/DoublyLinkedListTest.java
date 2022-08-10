package com.rpatil.ds.linkedlist.dll;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DoublyLinkedListTest {

    DoublyLinkedList dll1;
    DoublyLinkedList dll2;

    @BeforeMethod
    public void setUp() {
        dll1 = new DoublyLinkedList();
        dll2 = new DoublyLinkedList(15);
    }

    @AfterMethod
    public void tearDown() {
        dll1 = null;
        dll2 = null;
    }

    @Test
    public void testAddFirst() {
        dll1.addFirst(15);
        dll1.addFirst(10);
        dll1.addFirst(5);
        dll1.addFirst(0);
        Assert.assertEquals(dll1.toString(), "0<->5<->10<->15");

        dll2.addFirst(10);
        dll2.addFirst(5);
        dll2.addFirst(0);
        Assert.assertEquals(dll2.toString(), "0<->5<->10<->15");
    }

    @Test
    public void testAddLast() {
        dll1.addLast(15);
        dll1.addLast(10);
        dll1.addLast(5);
        dll1.addLast(0);
        Assert.assertEquals(dll1.toString(), "15<->10<->5<->0");

        dll2.addLast(10);
        dll2.addLast(5);
        dll2.addLast(0);
        Assert.assertEquals(dll2.toString(), "15<->10<->5<->0");
    }

    @Test
    public void testAddAtIndex() {
        dll1.addAtIndex(0, 15);
        dll1.addAtIndex(1, 5);
        dll1.addAtIndex(1, 10);
        dll1.addAtIndex(3, 0);
        Assert.assertEquals(dll1.toString(), "15<->10<->5<->0");

        dll2.addAtIndex(1, 5);
        dll2.addAtIndex(1, 10);
        dll2.addAtIndex(3, 0);
        Assert.assertEquals(dll2.toString(), "15<->10<->5<->0");
    }

    @Test
    public void testSearch() {
        dll1.addFirst(15);
        dll1.addFirst(10);
        dll1.addFirst(5);
        dll1.addFirst(0);
        Assert.assertTrue(dll1.search(0));
        Assert.assertTrue(dll1.search(5));
        Assert.assertTrue(dll1.search(10));
        Assert.assertTrue(dll1.search(15));
        Assert.assertFalse(dll1.search(20));

        dll2.addFirst(10);
        dll2.addFirst(5);
        dll2.addFirst(0);
        Assert.assertTrue(dll2.search(10));
        Assert.assertTrue(dll2.search(15));
        Assert.assertFalse(dll2.search(20));
        Assert.assertFalse(dll2.search(25));
    }

    @Test
    public void testGet() {
        dll1.addFirst(15);
        dll1.addFirst(10);
        dll1.addFirst(5);
        dll1.addFirst(0);
        Assert.assertEquals(dll1.get(0), 0);
        Assert.assertEquals(dll1.get(1), 5);
        Assert.assertEquals(dll1.get(2), 10);
        Assert.assertEquals(dll1.get(3), 15);
        Assert.assertEquals(dll1.get(4), 15);

        dll2.addFirst(10);
        dll2.addFirst(5);
        dll2.addFirst(0);
        Assert.assertEquals(dll1.get(1), 5);
        Assert.assertEquals(dll1.get(2), 10);
        Assert.assertEquals(dll1.get(3), 15);
        Assert.assertEquals(dll1.get(4), 15);
        Assert.assertEquals(dll1.get(5), 15);
    }

    @Test
    public void testIndexOf() {
        dll1.addFirst(15);
        dll1.addFirst(10);
        dll1.addFirst(5);
        dll1.addFirst(0);
        Assert.assertEquals(dll1.indexOf(0), 0);
        Assert.assertEquals(dll1.indexOf(5), 1);
        Assert.assertEquals(dll1.indexOf(10), 2);
        Assert.assertEquals(dll1.indexOf(15), 3);
        Assert.assertEquals(dll1.indexOf(20), -1);

        dll2.addFirst(10);
        dll2.addFirst(5);
        dll2.addFirst(0);
        Assert.assertEquals(dll2.indexOf(0), 0);
        Assert.assertEquals(dll2.indexOf(5), 1);
        Assert.assertEquals(dll2.indexOf(10), 2);
        Assert.assertEquals(dll2.indexOf(15), 3);
        Assert.assertEquals(dll2.indexOf(20), -1);
        Assert.assertEquals(dll2.indexOf(25), -1);
    }

    @Test
    public void testDelete() {
        dll1.addFirst(15);
        dll1.addFirst(10);
        dll1.addFirst(5);
        dll1.addFirst(0);

        Assert.assertEquals(dll1.indexOf(0), 0);
        dll1.delete(0);
        Assert.assertEquals(dll1.indexOf(0), -1);

        Assert.assertEquals(dll1.indexOf(10), 1);
        dll1.delete(10);
        Assert.assertEquals(dll1.indexOf(10), -1);

        Assert.assertEquals(dll1.indexOf(20), -1);
        dll1.delete(20);
        Assert.assertEquals(dll1.indexOf(20), -1);


        dll2.addFirst(10);
        dll2.addFirst(5);
        dll2.addFirst(0);

        Assert.assertEquals(dll2.indexOf(5), 1);
        dll2.delete(5);
        Assert.assertEquals(dll2.indexOf(5), -1);

        Assert.assertEquals(dll2.indexOf(15), 2);
        dll2.delete(15);
        Assert.assertEquals(dll2.indexOf(15), -1);

        Assert.assertEquals(dll2.indexOf(10), 1);
        dll2.delete(10);
        Assert.assertEquals(dll2.indexOf(10), -1);

        Assert.assertEquals(dll2.indexOf(20), -1);
        dll2.delete(20);
        Assert.assertEquals(dll2.indexOf(20), -1);
    }

    @Test
    public void testDeleteAtIndex() {
        dll1.addFirst(15);
        dll1.addFirst(10);
        dll1.addFirst(5);
        dll1.addFirst(0);

        Assert.assertEquals(dll1.indexOf(0), 0);
        dll1.deleteAtIndex(0);
        Assert.assertEquals(dll1.indexOf(0), -1);

        Assert.assertEquals(dll1.indexOf(15), 2);
        dll1.deleteAtIndex(2);
        Assert.assertEquals(dll1.indexOf(15), -1);

        Assert.assertEquals(dll1.indexOf(10), 1);
        dll1.deleteAtIndex(2);
        Assert.assertEquals(dll1.indexOf(10), 1);


        dll2.addFirst(10);
        dll2.addFirst(5);
        dll2.addFirst(0);

        Assert.assertEquals(dll2.indexOf(5), 1);
        dll2.deleteAtIndex(1);
        Assert.assertEquals(dll2.indexOf(5), -1);

        Assert.assertEquals(dll2.indexOf(15), 2);
        dll2.deleteAtIndex(2);
        Assert.assertEquals(dll2.indexOf(15), -1);

        Assert.assertEquals(dll2.indexOf(10), 1);
        dll2.deleteAtIndex(1);
        Assert.assertEquals(dll2.indexOf(10), -1);

        Assert.assertEquals(dll2.indexOf(0), 0);
        dll2.deleteAtIndex(-1);
        Assert.assertEquals(dll2.indexOf(0), 0);
    }

    @Test
    public void testTestToString() {
        dll1.addFirst(15);
        dll1.addFirst(10);
        dll1.addFirst(5);
        dll1.addFirst(0);
        dll1.addLast(20);

        dll2.addFirst(20);
        dll2.addFirst(10);
        dll2.addFirst(0);
        dll2.addLast(30);


        Assert.assertEquals(dll1.toString(), "0<->5<->10<->15<->20");
        Assert.assertEquals(dll2.toString(), "0<->10<->20<->15<->30");
    }
}

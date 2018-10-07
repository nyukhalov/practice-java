package com.github.nyukhalov.practice.datastructure;

import com.github.nyukhalov.practice.datastucture.SinglyLinkedList;
import junit.framework.TestSuite;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SinglyLinkedListTest extends TestSuite {

    @Test
    public void appendAndGetTest() throws Exception {
        SinglyLinkedList<Long> array = new SinglyLinkedList<>();

        array.append(1L);

        assertEquals(1L, (long) array.get(0));
    }

    @Test
    public void existTest() throws Exception {
        SinglyLinkedList<Long> array = new SinglyLinkedList<>();

        array.append(1L);

        assertTrue(array.exists(1L));
        assertFalse(array.exists(2L));
    }

    @Test
    public void deleteTest() throws Exception {
        SinglyLinkedList<Long> array = new SinglyLinkedList<>();

        array.append(1L);
        array.append(2L);
        array.append(3L);

        assertEquals(2L, (long) array.get(1));

        array.delete(1);
        assertEquals(3L, (long) array.get(1));
    }
}

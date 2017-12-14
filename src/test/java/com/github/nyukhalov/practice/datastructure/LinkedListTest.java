package com.github.nyukhalov.practice.datastructure;

import com.github.nyukhalov.practice.datastucture.LinkedList;
import junit.framework.TestSuite;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListTest extends TestSuite {
    @Test
    public void WhenListIsEmpty_ThenSizeIs0() throws Exception {
        LinkedList<String> list = new LinkedList<>();

        assertEquals(0, list.size());
    }

    @Test
    public void WhenListContainsOneEl_ThenSizeIs1() throws Exception {
        LinkedList<String> list = new LinkedList<>();
        list.add("string");

        assertEquals(1, list.size());
    }

    @Test
    public void FirstAndLastReturnsRespectivValuesOfNonEmptyList() throws Exception {
        String first = "first";
        String last = "last";
        LinkedList<String> list = new LinkedList<>();
        list.add(first);
        list.add(last);

        assertEquals(first, list.first());
        assertEquals(last, list.last());
    }

    @Test
    public void MethodGetReturnsIthValues() throws Exception {
        String first = "first";
        String last = "last";
        LinkedList<String> list = new LinkedList<>();
        list.add(first);
        list.add(last);

        assertEquals(first, list.get(0));
        assertEquals(last, list.get(1));
        assertEquals(null, list.get(2));
    }

    @Test
    public void MethodRemoveRemovesIthElement() throws Exception {
        String first = "first";
        String last = "last";
        LinkedList<String> list = new LinkedList<>();
        list.add(first);
        list.add(last);

        list.remove(1);

        assertEquals(1, list.size());
        assertEquals(first, list.first());

        list.remove(0);

        assertEquals(0, list.size());
    }
}

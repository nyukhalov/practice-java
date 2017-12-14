package com.github.nyukhalov.practice.datastructure;

import com.github.nyukhalov.practice.datastucture.DynamicArray;
import junit.framework.TestSuite;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DynamicArrayTest extends TestSuite {
    @Test
    public void sizeOfEmptyArrayIs0() throws Exception {
        DynamicArray<Integer> array = new DynamicArray<>();

        assertEquals(0, array.size());
    }

    @Test
    public void addTest() throws Exception {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.add(5);

        assertEquals(1, array.size());
        assertEquals(new Integer(5), array.get(0));
    }

    @Test
    public void removeTest() throws Exception {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.add(5);
        array.add(7);

        array.remove(0);

        assertEquals(1, array.size());
        assertEquals(new Integer(7), array.get(0));
    }
}

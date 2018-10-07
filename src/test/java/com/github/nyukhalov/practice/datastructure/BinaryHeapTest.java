package com.github.nyukhalov.practice.datastructure;

import com.github.nyukhalov.practice.datastucture.BinaryHeap;
import junit.framework.TestSuite;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryHeapTest extends TestSuite {
    @Test
    public void size0Test() throws Exception {
        BinaryHeap<Long> heap = new BinaryHeap<>(Long::compareTo);

        assertEquals(0, heap.size());
    }

    @Test
    public void size1Test() throws Exception {
        BinaryHeap<Long> heap = new BinaryHeap<>(Long::compareTo);

        heap.add(1L);

        assertEquals(1, heap.size());
        assertEquals(1L, (long) heap.peek());
    }

    @Test
    public void peekTest() throws Exception {
        BinaryHeap<Long> heap = new BinaryHeap<>(Long::compareTo);

        heap.add(5L);
        heap.add(3L);
        heap.add(10L);

        assertEquals(3L, (long) heap.peek());
    }

    @Test
    public void takeTest() throws Exception {
        BinaryHeap<Long> heap = new BinaryHeap<>(Long::compareTo);

        heap.add(5L);
        heap.add(3L);
        heap.add(10L);

        assertEquals(3L, (long) heap.take());
        assertEquals(5L, (long) heap.take());
        assertEquals(10L, (long) heap.take());
        assertEquals(0, heap.size());
    }
}

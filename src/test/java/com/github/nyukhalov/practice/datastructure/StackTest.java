package com.github.nyukhalov.practice.datastructure;

import com.github.nyukhalov.practice.datastucture.Stack;
import junit.framework.TestSuite;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackTest extends TestSuite {

    @Test
    public void emptyStackTest() throws Exception {
        Stack<Long> stack = new Stack<>();

        assertEquals(0, stack.size());
    }

    @Test
    public void size1Test() throws Exception {
        Stack<Long> stack = new Stack<>();

        stack.push(1L);

        assertEquals(1, stack.size());
    }

    @Test
    public void popTest() throws Exception {
        Stack<Long> stack = new Stack<>();

        stack.push(1L);
        stack.push(2L);

        assertEquals(2L, (long) stack.pop());
        assertEquals(1L, (long) stack.pop());
    }
}

package com.github.nyukhalov.practice.datastucture;

/**
 * Stack
 *
 * Time complexity (on average)
 * - Access the last pushed: O(1)
 * - Search by element: O(n)
 * - Insertion w/ resize: O(n)
 * - Insertion w/o resize: O(1)
 * - Deletion: O(1)
 *
 * Time complexity (worst case)
 * - Access the last pushed: O(1)
 * - Search by element: O(n)
 * - Insertion w/ resize: O(n)
 * - Insertion w/o resize: O(1)
 * - Deletion: O(1)
 *
 * Space complexity:
 * - O(n)
 */
public class Stack<T> {

    private Object[] data;
    private int size = 0;

    public Stack(int capacity) {
        data = new Object[capacity];
    }

    public Stack() {
        this(32);
    }

    public void push(T elem) {
        if (size >= data.length) doubleSize();
        data[size++] = elem;
    }

    public T pop() {
        if (size <= 0) return null;
        T elem = (T) data[--size];
        data[size] = null;
        return elem;
    }

    public int size() {
        return size;
    }

    private void doubleSize() {
        Object[] biggerData = new Object[data.length * 2];
        System.arraycopy(data, 0, biggerData, 0, data.length);
        data = biggerData;
    }
}

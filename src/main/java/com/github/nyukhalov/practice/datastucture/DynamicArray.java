package com.github.nyukhalov.practice.datastucture;

import java.util.Arrays;

public class DynamicArray<T> {
    private static final int DEFAULT_CAPACITY = 16;

    private T[] elements = null;
    private int size = 0;

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    public DynamicArray(int capacity) {
        @SuppressWarnings("unchecked")
        final T[] array = (T[])new Object[capacity];
        this.elements = array;
    }

    public void add(T elem) {
        ensureExtraCapacity();
        elements[size] = elem;
        size++;
    }

    public T get(int idx) {
        if (idx < 0 || idx >= size) return null;
        else return elements[idx];
    }

    public void remove(int idx) {
        if (idx >= 0 && idx < size) {
            for (int i = idx; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            size--;
        }
    }

    public int size() {
        return size;
    }

    private void ensureExtraCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }
}

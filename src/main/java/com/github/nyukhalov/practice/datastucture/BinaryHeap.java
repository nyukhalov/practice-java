package com.github.nyukhalov.practice.datastucture;

import java.util.Comparator;

/**
 * Heap implementation based on a binary tree.
 *
 */
public class BinaryHeap<T> {

    private final Comparator<T> comp;
    private int size = 0;
    private Object[] data;

    public BinaryHeap(Comparator<T> comp) {
        this.comp = comp;
        this.data = new Object[32];
    }

    public void add(T elem) {
        if (size >= data.length) growData();

        int idx = size++;
        data[idx] = elem;

        int parentIdx = parentOf(idx);

        while(idx != 0 && comp.compare((T) data[idx], (T) data[parentIdx]) < 0) {
            swap(idx, parentIdx);
            idx = parentIdx;
            parentIdx = parentOf(idx);
        }
    }

    public T peek() {
        if (size() <= 0) return null;
        return (T) data[0];
    }

    public T take() {
        if (size() <= 0) return null;
        T el = peek();

        size--;
        data[0] = data[size];
        data[size] = null;

        int idx = 0;
        while(hasLeftChild(idx)) {
            int targetIdx = idx;

            int lIdx = leftChildOf(idx);
            if (comp.compare((T)data[lIdx],(T)data[idx]) < 0) targetIdx = lIdx;

            if (hasRightChild(idx)) {
                int rIdx = rightChildOf(idx);
                if (comp.compare((T)data[rIdx],(T)data[targetIdx]) < 0) targetIdx = rIdx;
            }

            if (idx == targetIdx) break;
            swap(idx, targetIdx);
            idx = targetIdx;
        }

        return el;
    }

    public int size() {
        return size;
    }

    private int parentOf(int childIdx) {
        return (childIdx - 1) / 2;
    }

    private boolean hasLeftChild(int parentIdx) {
        return leftChildOf(parentIdx) < size();
    }

    private boolean hasRightChild(int parentIdx) {
        return rightChildOf(parentIdx) < size();
    }

    private int leftChildOf(int parentIdx) {
        return 2*parentIdx + 1;
    }

    private int rightChildOf(int parentIdx) {
        return leftChildOf(parentIdx) + 1;
    }

    private void swap(int i1, int i2) {
        Object tmp = data[i1];
        data[i1] = data[i2];
        data[i2] = tmp;
    }

    private void growData() {
        Object[] grow = new Object[data.length * 2];
        System.arraycopy(data, 0, grow, 0, data.length);
        data = grow;
    }
}

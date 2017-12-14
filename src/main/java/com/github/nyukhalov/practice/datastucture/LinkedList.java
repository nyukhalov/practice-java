package com.github.nyukhalov.practice.datastucture;

public class LinkedList<T> {

    private Node<T> root = null;

    private static class Node<E> {
        E elem = null;
        Node<E> next = null;
    }

    public void add(T elem) {
        Node<T> newNode = new Node<>();
        newNode.elem = elem;
        Node<T> last = getLastNode();

        if (last == null) root = newNode;
        else last.next = newNode;
    }

    public T first() {
        return elemOfNullableNode(root);
    }

    public T last() {
        Node<T> last = getLastNode();
        return elemOfNullableNode(last);
    }

    public T get(int idx) {
        int curIdx = 0;
        Node<T> n = root;

        while(n != null && curIdx < idx) {
            n = n.next;
            curIdx++;
        }

        return elemOfNullableNode(n);
    }

    public void remove(int idx) {
        Node<T> prev = null;
        Node<T> cur = root;
        int curIdx = 0;

        while(cur != null && curIdx < idx) {
            prev = cur;
            cur = cur.next;
            curIdx++;
        }

        if (prev != null) {
            prev.next = cur != null? cur.next: null;
        } else if (root != null) {
            root = root.next;
        }
    }

    public int size() {
        int size = 0;
        Node<T> n = root;
        while(n != null) {
            n = n.next;
            size++;
        }
        return size;
    }

    private Node<T> getLastNode() {
        Node<T> n = root;

        while(n != null && n.next != null) {
            n = n.next;
        }

        return n;
    }

    private T elemOfNullableNode(Node<T> node) {
        return node != null? node.elem: null;
    }
}

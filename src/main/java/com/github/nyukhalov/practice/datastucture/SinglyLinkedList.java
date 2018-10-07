package com.github.nyukhalov.practice.datastucture;

/**
 * Singly linked list.
 *
 * Time complexity (on average)
 * - Access by index: O(n)
 * - Search by element: O(n)
 * - Insertion including search: O(n)
 * - Insertion w/o search: O(1)
 * - Deletion including search: O(n)
 * - Deletion w/o search: O(1)
 *
 * Time complexity (worst case)
 * - Access by index: O(n)
 * - Search by element: O(n)
 * - Insertion including search: O(n)
 * - Insertion w/o search: O(1)
 * - Deletion including search: O(n)
 * - Deletion w/o search: O(1)
 *
 * Space complexity:
 * - O(n)
 *
 * @param <T>
 */
public class SinglyLinkedList<T> {

    private static class Node<A> {
        A element;
        Node<A> next;

        public Node(A element) {
            this.element = element;
            this.next = null;
        }
    }

    private Node<T> head = null;
    private Node<T> tail = null;

    public T get(int idx) {
        Node<T> cur = head;

        while(idx-- > 0) {
            if (cur == null) return null;
            cur = cur.next;
        }

        if (cur == null) return null;
        return cur.element;
    }

    public boolean exists(T element) {
        Node<T> cur = head;
        while(cur != null) {
            if (cur.element.equals(element)) return true;
            cur = cur.next;
        }
        return false;
    }

    public void append(T element) {
        Node<T> newNode = new Node<>(element);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void delete(int idx) {
        Node<T> prev = null;
        Node<T> cur = head;
        while(idx-- > 0) {
            if (cur == null) return;
            prev = cur;
            cur = cur.next;
        }
        if (prev != null && cur != null) prev.next = cur.next;
    }

    public void deleteFirst() {
        if (head != null) {
            head = head.next;
            if (head == null) tail = null;
        }
    }
}

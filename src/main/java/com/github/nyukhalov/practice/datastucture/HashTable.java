package com.github.nyukhalov.practice.datastucture;

public class HashTable<K, V> {

    private static class Node<Key, Value> {
        Key key;
        Value value;
        int hash;
        Node<Key, Value> next;

        public Node(Key key, Value value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = null;
        }
    }

    private final Node<K, V>[] buckets;
    private int size = 0;
    private int sizeLimit = 0;

    public HashTable(int capacity, float loadFactor) {
        this.buckets = (Node<K,V>[])new Node[capacity];
        this.sizeLimit = (int) (capacity * loadFactor);
    }

    public HashTable() {
        this(32, 0.75f);
    }

    public void put(K key, V value) {
        int h = hash(key);
        upsert(h, key, value);
    }

    public V get(K key) {
        int h = hash(key);
        return find(h, key);
    }

    public void delete(K key) {
        int h = hash(key);
        deleteFromBucket(h, key);
    }

    public int size() {
        return size;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode());
    }

    private void deleteFromBucket(int hash, K key) {
        Node<K,V> prev = null;
        Node<K,V> node = findBucket(hash);
        while(node != null) {
            if (node.hash == hash && (node.key == key || node.key.equals(key))) {
                if (prev == null) { // it is the first node
                    updateBucketHead(hash, node.next);
                } else {
                    prev.next = node.next;
                }
                size--;
                break;
            }
            prev = node;
            node = node.next;
        }
    }

    private V find(int hash, K key) {
        Node<K, V> node = findBucket(hash);
        while(node != null) {
            if (node.hash == hash && (node.key == key || node.key.equals(key))) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    private void upsert(int hash, K key, V value) {
        Node<K,V> head = findBucket(hash);
        Node<K,V> node = head;
        while(node != null) {
            if (node.hash == hash &&
                    (node.key == key || node.key.equals(key))) {
                node.value = value;
                break;
            }
            node = node.next;
        }
        if (node == null) { // the bucket is empty or does not contain the key
            size++;
            Node<K,V> newNode = new Node<>(key, value, hash);
            newNode.next = head;
            updateBucketHead(hash, newNode);
        }
    }

    private Node<K,V> findBucket(int hash) {
        int idx = hash % buckets.length;
        return buckets[idx];
    }

    private void updateBucketHead(int hash, Node<K,V> head) {
        int idx = hash % buckets.length;
        buckets[idx] = head;
    }
}

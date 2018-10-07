package com.github.nyukhalov.practice.datastructure;

import com.github.nyukhalov.practice.datastucture.HashTable;
import junit.framework.TestSuite;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HashTableTest extends TestSuite {
    @Test
    public void size0Test() throws Exception {
        HashTable<String, Long> map = new HashTable<>();

        assertEquals(0, map.size());
    }

    @Test
    public void size1Test() throws Exception {
        HashTable<String, Long> map = new HashTable<>();

        map.put("key", 1L);

        assertEquals(1, map.size());
    }

    @Test
    public void setgetTest() throws Exception {
        HashTable<String, Long> map = new HashTable<>();

        map.put("key1", 1L);
        assertEquals(1L, (long) map.get("key1"));

        map.put("key1", 2L);
        assertEquals(2L, (long) map.get("key1"));

        map.put("key2", 3L);
        assertEquals(3L, (long) map.get("key2"));
    }

    @Test
    public void deleteTest() throws Exception {
        HashTable<String, Long> map = new HashTable<>();

        map.put("key", 1L);
        map.delete("key");

        assertEquals(0, map.size());
        assertNull(map.get("key"));
    }
}

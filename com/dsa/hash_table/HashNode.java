package com.dsa.hash_table;

/**
 * Represents a node in a hash table.
 * Each node contains a key-value pair and a reference to the next node in the chain.
 */
public class HashNode {

    public Integer key; // The key of the node.
    public String value; // The value associated with the key.
    public HashNode next; // The reference to the next node in the chain.

    /**
     * Constructs a new HashNode with the given key and value.
     *
     * @param key   The key of the node.
     * @param value The value associated with the key.
     */
    public HashNode(Integer key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

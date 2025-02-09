package com.dsa.hash_table;

import com.dsa.Answer;

import java.util.Objects;

/**
 * Implementation of a hash table data structure.
 */
public class HashTable {
    private final int numberOfBuckets; // Total number of buckets in the hash table
    private final HashNode[] buckets; // Array to store the hash nodes
    private int size; // Current size of the hash table

    /**
     * Constructs a hash table with a default capacity of 10.
     */
    public HashTable() {
        this(10);
    }

    /**
     * Constructs a hash table with the specified capacity.
     *
     * @param capacity The initial capacity of the hash table.
     */
    public HashTable(int capacity) {
        this.numberOfBuckets = capacity;
        this.buckets = new HashNode[this.numberOfBuckets];
        this.size = 0;
    }

    public static void main(String[] args) {
        HashTable table = new HashTable(10);
        table.put(10, "Ten");
        table.put(15, "Fifteen");
        table.put(13, "Thirteen");
        table.put(5, "Five");

        System.out.println(table);

        Answer.print(table.size, "Size");

        String value = table.get(5);
        Answer.print(value, "Key's Value");

        value = table.remove(15);
        Answer.print(value, "Removed");
        Answer.print(table.size, "Size");

        value = table.remove(10);
        Answer.print(value, "Removed");
        Answer.print(table.size, "Size");

        System.out.println(table);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nHashTable:\n");
        for (int i = 0; i < this.numberOfBuckets; i++) {
            HashNode head = buckets[i];
            sb.append(i);
            if (head == null) {
                sb.append("\t").append("null");
            } else {
                while (head != null) {
                    sb.append("\t").append("(").append(head.key).append(", ").append(head.value).append(") ->");
                    head = head.next;
                }
                sb.append("\t").append("null");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Inserts a key-value pair into the hash table.
     * If the key already exists, updates the corresponding value.
     *
     * @param key   The key to insert.
     * @param value The value associated with the key.
     */
    public void put(Integer key, String value) {
        int index = getIndex(key);
        HashNode head = this.buckets[index];
        while (head != null) {
            if (key.equals(head.key)) {
                head.value = value; // Update value if key already exists
                return;
            }
            head = head.next;
        }
        // Key doesn't exist, create a new node and insert it at the beginning of the list
        head = this.buckets[index];
        HashNode node = new HashNode(key, value);
        node.next = head;
        this.buckets[index] = node;
        this.size++;
    }


    /**
     * Calculates the index in the hash table based on the given key.
     *
     * @param key The key used to calculate the index.
     * @return The index in the hash table.
     */
    private int getIndex(Integer key) {
        return key % this.numberOfBuckets;
    }


    /**
     * Retrieves the value associated with the given key from the hash table.
     *
     * @param key The key whose associated value is to be retrieved.
     * @return The value associated with the given key, or null if the key is not found.
     */
    public String get(Integer key) {
        int index = getIndex(key);
        HashNode head = this.buckets[index];
        while (head != null) {
            if (Objects.equals(head.key, key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }


    /**
     * Removes the entry associated with the given key from the hash table.
     *
     * @param key The key of the entry to be removed.
     * @return The value associated with the removed key, or null if the key is not found.
     */
    public String remove(Integer key) {
        // Calculate the index in the hash table based on the given key
        int index = getIndex(key);

        // Get the head node of the bucket corresponding to the index
        HashNode head = this.buckets[index];

        // Initialize a reference to the previous node, which will be used to update the linked list
        // after removing the node associated with the key
        HashNode previous = null;

        // Traverse the linked list in the bucket
        while (head != null) {
            // Check if the key of the current node matches the given key
            if (Objects.equals(head.key, key)) {
                // If the key matches, remove the node from the linked list

                // If the node to be removed is the first node in the linked list
                if (previous == null) {
                    // Update the head of the linked list to skip the node to be removed
                    this.buckets[index] = head.next;
                } else {
                    // Update the previous node's next reference to skip the node to be removed
                    previous.next = head.next;
                }

                // Break the link from the removed node to the rest of the linked list
                head.next = null;

                // Decrease the size of the hash table
                this.size--;

                // Return the value associated with the removed key
                return head.value;
            }

            // Move to the next node in the linked list
            previous = head;
            head = head.next;
        }

        // If the key is not found in the linked list, return null
        return null;
    }
}

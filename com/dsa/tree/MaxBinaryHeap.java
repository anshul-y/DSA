package com.dsa.tree;

import com.dsa.Answer;
import com.dsa.array.ArrayUtil;

public class MaxBinaryHeap {
    Integer[] heap;
    int n;

    MaxBinaryHeap(int capacity) {
        heap = new Integer[capacity + 1];
        n = 0;
    }

    /**
     * Returns the current size of the heap.
     *
     * @return the number of elements currently stored in the heap
     */
    public int size() {
        return n;
    }

    /**
     * Checks if the heap is empty.
     *
     * @return true if the heap is empty, false otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Prints the elements of the heap.
     * 
     * This method delegates the printing task to the 'print' method of the 'Answer'
     * class, providing the heap array and a label indicating it as a "Max heap".
     */
    public void print() {
        Answer.print(this.heap, "Max heap");
    }

    /**
     * Inserts an element into the heap.
     *
     * @param x the element to be inserted
     */
    public void insert(int x) {
        // Check if the heap array is full, resize if necessary
        if (this.n == this.heap.length - 1) {
            this.heap = ArrayUtil.resizeArray(this.heap, this.heap.length * 2);
        }

        // Increment the size of the heap
        this.n++;
        // add the element at the next available index
        this.heap[n] = x;

        // Perform the swim operation to maintain the heap property
        swim();
    }

    /**
     * Performs the "swim" operation on the heap.
     * 
     * The "swim" operation is used to maintain the heap property by moving an
     * element up the heap until its parent's value is less than or equal to its own
     * value.
     */
    public void swim() {
        // Start with the last element added to the heap
        int k = this.n;

        // Continue the swim operation until reaching the root (k = 1) or the heap
        // property is satisfied
        while (k > 1 && this.heap[k / 2] < this.heap[k]) {
            // Swap the current element with its parent if necessary
            int temp = this.heap[k];
            this.heap[k] = this.heap[k / 2];
            this.heap[k / 2] = temp;

            // Move up to the parent position
            k = k / 2;
        }
    }

    /**
     * Swaps the elements at the specified indices in the heap array.
     *
     * @param a the index of the first element to be swapped
     * @param b the index of the second element to be swapped
     */
    public void swap(int a, int b) {
        // Temporary variable to hold the value of the element at index 'b'
        int temp = this.heap[b];

        // Swap the elements at indices 'a' and 'b'
        this.heap[b] = this.heap[a];
        this.heap[a] = temp;
    }

    /**
     * Deletes the maximum element from the heap.
     *
     * @return the maximum element that is deleted from the heap
     */
    public int deleteMax() {
        // Store the maximum element
        int max = this.heap[1];

        // Swap the maximum element with the last element in the heap and decrement the
        // heap size
        swap(1, n);
        n--;

        // Set the last element to null to remove it from the heap
        this.heap[n + 1] = null;

        // Perform the "sink" operation to restore the heap property
        sink();

        // Check if resizing of the heap array is necessary
        if (n > 0 && (this.heap.length - 1) / 4 == n) {
            this.heap = ArrayUtil.resizeArray(this.heap, this.heap.length / 2);
        }

        // Return the maximum element that was deleted from the heap
        return max;
    }

    /**
     * Performs the "sink" operation on the heap.
     * 
     * The "sink" operation is used to maintain the heap property by moving an
     * element down the heap until its children's values are less than or equal to
     * its own value.
     */
    public void sink() {
        // Start with the root element
        int k = 1;

        // Continue the sink operation until reaching a leaf node or the heap property
        // is satisfied
        while (2 * k <= n) {
            // Find the index of the child with the greater value
            int j = 2 * k;
            if (j < n && this.heap[j] < this.heap[j + 1]) {
                j++;
            }

            // If the current element is greater than or equal to its largest child, stop
            // sinking
            if (this.heap[k] >= this.heap[j]) {
                break;
            }

            // Swap the current element with its largest child and move down the heap
            swap(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        MaxBinaryHeap maxBH = new MaxBinaryHeap(3);
        Answer.print(maxBH.isEmpty(), "Heap Empty");
        maxBH.insert(3);
        maxBH.print();
        maxBH.insert(5);
        maxBH.print();
        maxBH.insert(4);
        maxBH.print();
        maxBH.insert(6);
        maxBH.print();
        maxBH.insert(2);
        maxBH.print();
        int max = maxBH.deleteMax();
        Answer.print(max, "Max number");
        maxBH.print();
        Answer.print(maxBH.isEmpty(), "Heap Empty");
        Answer.print(maxBH.size(), "Heap size");
    }

}

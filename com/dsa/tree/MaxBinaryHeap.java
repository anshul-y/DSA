package com.dsa.tree;

import java.util.Arrays;

import com.dsa.Answer;
import com.dsa.array.ArrayUtil;

public class MaxBinaryHeap {
    Integer[] heap;
    int n;

    MaxBinaryHeap(int capacity) {
        heap = new Integer[capacity + 1];
        n = 0;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void print() {
        Answer.print(this.heap, "Max heap");
    }

    public void insert(int x) {
        if (this.n == this.heap.length - 1) {
            this.heap = ArrayUtil.resizeArray(this.heap, 2 * this.heap.length);
        }
        this.n++;
        this.heap[n] = x;
        swim(n);
    }

    public void swim(int k) {
        while (k > 1 && this.heap[k / 2] < this.heap[k]) {
            int temp = this.heap[k];
            this.heap[k] = this.heap[k / 2];
            this.heap[k / 2] = temp;
            k = k / 2;
        }
    }

    public void deleteMax() {
        int max = this.heap[1];

    }

    public void sink() {
        int k = 1;
        while (k < this.heap.length && this.heap[2*k]!=null) {
            // int second = this.heap[2*k+1];
            // int first = this.heap[2*k];
            // if(){int temp = this.heap[k];
            // this.heap[k] = this.heap[k * 2];
            // this.heap[k * 2] = temp;}
            // k=2*k;
        }
    }

    public static void main(String[] args) {
        MaxBinaryHeap maxBH = new MaxBinaryHeap(3);
        System.out.println(maxBH.isEmpty());
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
        System.out.println(maxBH.isEmpty());
        System.out.println(maxBH.size());
    }

}

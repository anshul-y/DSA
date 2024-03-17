package com.dsa.algo.sorting;

import com.dsa.Answer;

public class QuickSort {

    /**
     * Sorts a portion of an array using the quicksort algorithm.
     *
     * @param arr  the array to be sorted
     * @param low  the starting index of the portion to be sorted
     * @param high the ending index of the portion to be sorted
     */
    public static void sort(int[] arr, int low, int high) {
        // Base case: if low is less than high, continue with the sorting process
        if (low < high) {
            // Partition the array and recursively sort the left and right partitions
            int p = partition(arr, low, high);
            sort(arr, low, p - 1);
            sort(arr, p + 1, high);
        }
    }

    /**
     * Partitions a portion of an array for quicksort.
     *
     * @param arr  the array to be partitioned
     * @param low  the starting index of the portion to be partitioned
     * @param high the ending index of the portion to be partitioned
     * @return the index of the pivot element after partitioning
     */
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose the pivot element
        int i = low; // Initialize the left pointer
        int j = low; // Initialize the right pointer

        // Iterate over the portion to be partitioned
        while (i <= high) {
            // If the current element is less than or equal to the pivot, swap it with the
            // element at index j and increment j
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                j++;
            }
            i++;
        }
        // Return the index of the pivot element after partitioning
        return j - 1;
    }

    /**
     * Swaps two elements in an array.
     *
     * @param arr the array in which elements are to be swapped
     * @param i   the index of the first element
     * @param j   the index of the second element
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 8, -3, 5, 2, 6, 9, -6, 1, 3 };
        Answer.print(arr, "Array");
        sort(arr, 0, arr.length - 1);
        Answer.print(arr, "Array");
    }

}

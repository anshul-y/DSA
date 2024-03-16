package com.dsa.algo.sorting;

import com.dsa.Answer;

public class InsertionSort {

    /**
     * * Sorts an array using the insertion sort algorithm.
     *
     * @param arr the array to be sorted
     */
    public static void sort(int[] arr) {
        // Iterate over the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i]; // Store the current element
            int j = i - 1; // Initialize the index for comparison

            // Shift elements greater than the current element to the right
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert the current element into its correct position
            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {

        int[] arr = { 9, 2, 5, 1, 6 };
        Answer.print(arr, "Array");

        InsertionSort.sort(arr);
        Answer.print(arr, "Insertion sort");

        
    }
    
}

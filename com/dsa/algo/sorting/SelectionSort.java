package com.dsa.algo.sorting;

import com.dsa.Answer;

public class SelectionSort {
    
    /**
     * Sorts an array using the selection sort algorithm.
     * 
     * 1. In Selection sort we divide the given array
     * into two parts — sorted part and unsorted
     * part.
     * 2. The algorithm sorts an array by repeatedly
     * finding the minimum in an unsorted array
     * and making it part of the sorted array.
     * From unsorted part, we pick minimum
     * 3. element and swap it with leftmost element of
     * unsorted part. After swap, that element now
     * becomes part of sorted array.
     * 4. Its repeated till unsorted array is not empty.
     *
     * @param arr the array to be sorted
     */
    public static void sort(int[] arr) {
        // Iterate over the array
        for (int i = 0; i < arr.length; i++) {
            int min = i; // Assume the current index as the minimum

            // Find the index of the minimum element in the unsorted portion of the array
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            // Swap the minimum element with the element at the current index
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void main(String[] args) {

        int[] arr = { 9, 2, 5, 1, 6 };
        Answer.print(arr, "Array");

        SelectionSort.sort(arr);
        Answer.print(arr, "Selection sort");
        
    }
}

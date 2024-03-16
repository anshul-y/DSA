package com.dsa.algo.sorting;

import com.dsa.Answer;

public class BubbleSort {

    /**
     * Sorts an array using the bubble sort algorithm.
     *
     * @param arr the array to be sorted
     */
    public static void sort(int[] arr) {
        boolean isSwapped = false;

        // Iterate over the array
        for (int i = 0; i < arr.length - 1; i++) {
            isSwapped = false;

            // Perform a single pass through the array to bubble the maximum element to the
            // end
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // If the current element is greater than the next element, swap them
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapped = true;
                }
            }

            // If no swaps were made in a pass, the array is already sorted
            if (!isSwapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = { 9, 2, 5, 1, 6 };
        Answer.print(arr, "Array");

        BubbleSort.sort(arr);
        Answer.print(arr, "Bubble sort");
        
    }

}

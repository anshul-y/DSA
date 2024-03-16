package com.dsa.algo.search;

import com.dsa.Answer;

public class BinarySearch {
    /**
     * Performs binary search to find the index of a value in a sorted array.
     *
     * @param arr   the sorted array to be searched
     * @param value the value to be found in the array
     * @return the index of the value in the array, or -1 if not found
     */
    public static int search(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;

        // Continue searching until the search space is exhausted
        while (low <= high) {
            int mid = (low + high) / 2; // Calculate the middle index

            // If the value is found at the middle index, return it
            if (arr[mid] == value) {
                return mid;
            }

            // If the value is less than the element at the middle index, search the left
            // half
            if (value < arr[mid]) {
                high = mid - 1;
            } else { // Otherwise, search the right half
                low = mid + 1;
            }
        }

        // If the value is not found in the array, return -1
        return -1;
    }

    /**
     * Finds the index where the target should be inserted into a sorted array to
     * maintain its sorted order.
     *
     * @param arr    the sorted array
     * @param target the value to be inserted
     * @return the index where the target should be inserted
     */
    public static int getInsertPosition(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        // Continue searching until the search space is exhausted
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the middle index

            // If the target is found at the middle index, return it
            if (arr[mid] == target) {
                return mid;
            }

            // If the target is less than the element at the middle index, search the left
            // half
            if (target < arr[mid]) {
                high = mid - 1;
            } else { // Otherwise, search the right half
                low = mid + 1;
            }
        }

        // If the target is not found in the array, return the index where it should be
        // inserted
        return low;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 10, 15, 20, 25, 30, 35, 40 };
        int position = BinarySearch.search(arr, 1);
        Answer.print(position, "Found at");

        position = BinarySearch.getInsertPosition(arr, 22);
        Answer.print(position, "Found at");

    }
}

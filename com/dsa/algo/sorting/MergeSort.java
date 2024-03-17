package com.dsa.algo.sorting;

import com.dsa.Answer;

public class MergeSort {

    /**
     * Merges two sorted arrays into a single sorted array.
     * 
     * @param arr1 the first sorted array
     * @param arr2 the second sorted array
     * @return the merged sorted array
     */
    public static int[] mergeSortedArray(int[] arr1, int[] arr2) {
        int[] mergeArr = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        // Merge the two arrays by comparing elements from both arrays
        while (i < arr1.length && j < arr2.length) {
            // Determine which element to merge next
            if (arr1[i] <= arr2[j]) {
                mergeArr[k++] = arr1[i++];
            } else {
                mergeArr[k++] = arr2[j++];
            }
        }

        // Append remaining elements from arr1, if any
        while (i < arr1.length) {
            mergeArr[k++] = arr1[i++];
        }

        // Append remaining elements from arr2, if any
        while (j < arr2.length) {
            mergeArr[k++] = arr2[j++];
        }

        // Return the merged sorted array
        return mergeArr;
    }

    /**
     * Sorts a portion of an array using the merge sort algorithm.
     * 
     * Divide — In this step the algorithm takes middle point of array and
     * divides the array into 2 halves. The algorithm is carried out recursively
     * for half arrays, until there are no more half arrays to divide.
     * Conquer — In this step starting from the bottom, we sort and merge
     * the divided arrays and get the sorted array.
     * 
     * @param arr  the array to be sorted
     * @param low  the index representing the start of the portion to be sorted
     * @param high the index representing the end of the portion to be sorted
     */
    public static void sort(int[] arr, int low, int high) {
        // Base case: if the portion of the array has more than one element
        if (low < high) {
            // Calculate the middle index
            int mid = low + (high - low) / 2;

            // Recursively sort the left half
            sort(arr, low, mid);

            // Recursively sort the right half
            sort(arr, mid + 1, high);

            // Merge the sorted halves
            mergeSortedArray(arr, low, mid, high);
        }
    }

    /**
     * Merges two sorted halves of an array into a single sorted portion.
     *
     * @param arr  the array containing the sorted portions to be merged
     * @param low  the starting index of the first sorted portion
     * @param mid  the ending index of the first sorted portion and the starting
     *             index of the second sorted portion
     * @param high the ending index of the second sorted portion
     */
    private static void mergeSortedArray(int[] arr, int low, int mid, int high) {
        // Create a temporary array to store the merged portion
        int[] temp = new int[arr.length];

        // Copy the elements of the portion to be merged into the temporary array
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }

        int i = low; // Index for the first sorted portion
        int j = mid + 1; // Index for the second sorted portion
        int k = low; // Index for the merged portion

        // Merge the two sorted portions
        while (i <= mid && j <= high) {
            // Compare elements from both portions and place the smaller one into the merged
            // array
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        // Copy any remaining elements from the first portion, if any
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
    }

    public static void main(String[] args) {

        int[] arr1 = { 1, 2, 5, 6, 9 };
        int[] arr2 = { 3, 4, 7, 8 };
        Answer.print(arr1, "Array 1");
        Answer.print(arr2, "Array 2");
        int[] mergeArr = MergeSort.mergeSortedArray(arr1, arr2);
        Answer.print(mergeArr, "Merge sorted arrays");

        int[] arr = { 9, 5, 2, 4, 3 };
        Answer.print(arr, "Array");
        MergeSort.sort(arr, 0, arr.length - 1);
        Answer.print(arr, "Merge sort");
    }

}

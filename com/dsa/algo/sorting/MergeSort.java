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
            if (arr1[i] < arr2[j]) {
                mergeArr[k] = arr1[i];
                i++;
            } else {
                mergeArr[k] = arr2[j];
                j++;
            }
            k++;
        }

        // Append remaining elements from arr1, if any
        while (i < arr1.length) {
            mergeArr[k] = arr1[i];
            k++;
            i++;
        }

        // Append remaining elements from arr2, if any
        while (j < arr2.length) {
            mergeArr[k] = arr2[j];
            k++;
            j++;
        }

        // Return the merged sorted array
        return mergeArr;
    }

    public static void main(String[] args) {
        
        int[] arr1 = { 9, 2, 5, 1, 6 };
        Answer.print(arr1, "Array");

        int[] arr2 = { 3, 4, 7, 8 };
        Answer.print(arr2, "Array");

        int[] mergeArr = MergeSort.mergeSortedArray(arr1, arr2);
        Answer.print(mergeArr, "Merge sorted array");
    }
    
}

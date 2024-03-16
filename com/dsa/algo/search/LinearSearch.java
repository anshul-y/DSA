package com.dsa.algo.search;

import com.dsa.Answer;

public class LinearSearch {

    /**
     * Performs linear search to find the index of a value in an array.
     *
     * @param arr   the array to be searched
     * @param value the value to be found in the array
     * @return the index of the first occurrence of the value in the array, or -1 if
     *         not found
     */
    public static int search(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int position = LinearSearch.search(arr, 7);
        Answer.print(position, "Found at");
    }
}

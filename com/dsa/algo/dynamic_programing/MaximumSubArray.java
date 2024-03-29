package com.dsa.algo.dynamic_programing;

import com.dsa.Answer;

public class MaximumSubArray {

    public static void main(String[] args) {
        //int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr = {4, 3, -2, 6, -12, 7, -1, 6};
        int max = maxSubArray(arr);
        Answer.print(max, "Maximum Sub array");
    }

    /**
     * Finds the maximum sum of contiguous subarray in the given integer array.
     *
     * @param array The input integer array.
     * @return The maximum sum of contiguous subarray.
     */
    public static int maxSubArray(int[] array) {
        // Initialize variables to store the maximum sum found so far and the current maximum sum
        int maxSoFar = array[0];
        int currentMax = array[0];

        // If the array has only one element, return it as the maximum sum
        if (array.length == 1) return maxSoFar;

        // Iterate through the array to find the maximum sum of contiguous subarray
        for (int i = 1; i < array.length; i++) {
            // @param firstParameter represent Should I become part of current subarray?
            //      if sum of subarray is max then add the current number to the subarray.
            //
            // @param secondParameter represent Should I start a new subarray?
            //      if current element is greater than sum of subarray so far, start a new subarray from current element.
            currentMax = Math.max(currentMax + array[i], array[i]);

            //check if currentMax is greater than maxSoFar, if so update the maxSoFar
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        // Return the maximum sum found
        return maxSoFar;
    }


}

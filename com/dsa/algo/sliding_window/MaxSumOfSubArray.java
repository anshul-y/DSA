package com.dsa.algo.sliding_window;

import com.dsa.Answer;

public class MaxSumOfSubArray {

    public static void main(String[] args) {
        int[] arr = {2, 7, 3, 5, 8, 1};
        int maxSumSubArray = maxSumOfSubArray(arr, 2);
        Answer.print(maxSumSubArray, "Maximum sum of sub arrays of size " + 3);
    }

    /**
     * Finds the maximum sum of a subarray of length k in the given array.
     *
     * @param nums The input array of integers.
     * @param k    The length of the subarray.
     * @return The maximum sum of the subarray of length k.
     */
    private static int maxSumOfSubArray(int[] nums, int k) {
        // Initialize variables to store the maximum sum, current window sum, start index, and end index
        int maxSum = Integer.MIN_VALUE; // Initialize the maximum sum to the smallest possible integer value
        int windowSum = 0; // Initialize the current window sum to 0
        int start = 0; // Initialize the start index of the window
        int end = 0; // Initialize the end index of the window

        while (end < nums.length) { // Iterate through the array
            windowSum += nums[end]; // Add the current element to the window sum
            if (end >= k - 1) { // Check if the window size is equal to k
                windowSum -= nums[start++];     // Remove the first element of the window from the window sum
                maxSum = Math.max(maxSum, windowSum);   // Update the maximum sum by comparing it with the current window sum
            }
            end++;  // Move the end pointer to the next element
        }
        return maxSum;  // Return the maximum sum
    }


    // Time complexity O(n^2)
//    private static int maxSumOfSubArray(int[] nums, int k) {
//        int maxSum = Integer.MIN_VALUE;
//        for (int i = 0; i <= nums.length - k; i++){
//            int window = i+k;
//            int j = i+1;
//            int sum = nums[i];
//            while (j  < window) {
//                sum = sum + nums[j++];
//            }
//            maxSum = Math.max(maxSum, sum);
//        }
//        return maxSum;
//    }
}

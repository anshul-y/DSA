package com.dsa.algo.sliding_window;

import com.dsa.Answer;

public class MaxSumOfSubArray {

    public static void main(String[] args) {
        int[] arr = {2, 7, 3, 5, 8, 1};
        int maxSumSubArray = maxSumOfSubArray(arr, 3);
        Answer.print(maxSumSubArray, "Maximum sum of sub arrays of size " + 3);
    }

    private static int maxSumOfSubArray(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int windowStart = 0;
        int windowEnd = 0;
        int windowSize = k;
        for (int i = 0; i <= nums.length - 1; i++){
            if(windowEnd==windowSize){
                windowEnd=0;
            }
            windowEnd++;
        }
        return maxSum;
    }

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

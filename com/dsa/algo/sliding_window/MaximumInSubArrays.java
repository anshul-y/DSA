package com.dsa.algo.sliding_window;

import com.dsa.Answer;
import com.dsa.stack.StackUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumInSubArrays {
    public static void main(String[] args) {
        int[] nums = {44, 77, 33, 44, 88, 11};
        Object[] result = maxOfAllSubArraySizeK(nums, 3);
        Answer.print(Arrays.toString(result), "Maximum of all sub arrays of size " + 3);
    }

    private static Object[] maxOfAllSubArraySizeK(int[] nums, int k) {
//        int[] nextGreaterElement = StackUtil.nextGreaterElement(nums);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= nums.length - k; i++) {
            int j = i;
            int max = Integer.MIN_VALUE;
            int window = j + k;
            while (j < window) {
                max = Math.max(max, nums[j]);
                j++;
            }
            result.add(max);
        }
        return result.toArray();
    }

}

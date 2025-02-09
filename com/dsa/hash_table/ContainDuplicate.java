package com.dsa.hash_table;

import com.dsa.Answer;

import java.util.HashSet;
import java.util.Set;


/**
 * Given an integer array nums, return true if any value appears as least twice in the
 * array, and return false if every element is distinct
 */
public class ContainDuplicate {
    public static void main(String[] args) {
        int[] nums = {0, 5, 3, 2, 6, 3};
        boolean duplicateCheck = isContainsDuplicate(nums);
        Answer.print(duplicateCheck, "Contains Duplicate");
    }

    /**
     * Checks if an integer array contains any duplicate values.
     *
     * <p>This function uses a HashSet to keep track of the elements encountered so far.
     * It iterates through the array and checks if each element is already present in the HashSet.
     * If a duplicate is found, the function immediately returns true. If no duplicates are found
     * after iterating through the entire array, the function returns false.
     *
     * @param nums the integer array to check for duplicates
     * @return true if any duplicate values are found in the array, false otherwise
     */
    private static boolean isContainsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                return true;
            }
            set.add(n);
        }
        return false;
    }
}

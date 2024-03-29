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

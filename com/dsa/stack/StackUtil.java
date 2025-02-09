package com.dsa.stack;

import com.dsa.Answer;
import com.dsa.array.ArrayUtil;

import java.util.Stack;

public class StackUtil {

    public static void main(String[] args) {
        int[] nums = {4, 7, 3, 4, 8, 1};
        Answer.print(nums, "Array");

        StackUtil.nextGreaterElement(nums);

        StackUtil.nextSmallerElement(ArrayUtil.reverseArray(nums));

        boolean result = StackUtil.isBracesBalanced("{()}{");
        Answer.print(result, "Balanced Brackets");
    }

    /**
     * Finds the next greater element for each element in the given array.
     * 
     * @param nums The array of integers
     * @return An array of integers representing the next greater element for each
     *         element in the given array
     */
    public static int[] nextGreaterElement(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        // Iterate through the array in reverse order
        for (int i = nums.length - 1; i >= 0; i--) {
            // Pop elements from the stack that are smaller than or equal to the current
            // element
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            // If the stack is empty, there is no greater element, so set the result to -1
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                // Otherwise, set the result to the top element of the stack
                result[i] = stack.peek();
            }

            // Push the current element onto the stack
            stack.push(nums[i]);
        }

        // Print the result array
        Answer.print(result, "Next greater element");

        // Clear the stack
        stack.clear();

        // Return the result array
        return result;
    }

    public static int[] nextSmallerElement(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
        Answer.print(result, "Next smaller element");
        stack.clear();
        return result;
    }

    /**
     * Checks if the braces in the given pattern are balanced.
     * 
     * @param pattern the pattern to check
     * @return true if the braces are balanced, false otherwise
     */
    public static boolean isBracesBalanced(String pattern) {
        Stack<Character> stack = new Stack<>();
        for (char c : pattern.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.peek();
                    if ((top == '(' && c == ')') ||
                            (top == '{' && c == '}') ||
                            (top == '[' && c == ']')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}

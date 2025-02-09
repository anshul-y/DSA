package com.dsa.array;

import com.dsa.Answer;

import java.lang.reflect.Array;
import java.util.HashMap;

/**
 * ArrayUtil
 */
public class ArrayUtil {

    ArrayUtil() {
    }
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        Answer.print(arr, "Default Array");

        ArrayUtil.removeEven(arr);

        ArrayUtil.reverseArray(arr);

        ArrayUtil.minValue(arr);

        ArrayUtil.secondLargestElement(arr);

        ArrayUtil.placeZeroAtEndOfArray(new int[]{4, 0, 3, 2, 0, 0, 1});

        ArrayUtil.resizeArray(arr, 10);

        ArrayUtil.missingElementByMath(new int[]{2, 5, 1, 4});

        ArrayUtil.containsDuplicate(new int[]{7, 6, 4, 3, 1});

        ArrayUtil.productExceptSelf(new int[]{1, 2, 3, 4});

        ArrayUtil.runningSum(new int[]{1, 2, 3, 4});

        ArrayUtil.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});

        int[] numArray = {0, 1, 2, 2, 3, 0, 4, 2};
        Answer.print(numArray, "Array");
        int remainingLength = ArrayUtil.removeElement(numArray, 2);
        Answer.print(remainingLength, "Remaining Length");
        Answer.print(numArray, "Array");

        int[] duplicateArray = {0, 0, 1, 1, 2, 2, 3,};
        Answer.print(duplicateArray, "Before removing Duplicates");
        int arraySize = ArrayUtil.removeDuplicate(duplicateArray);
        Answer.print(arraySize, "Array Size after removing duplicates");
        Answer.print(duplicateArray, "After removing Duplicates");
    }

    public static int majorityElement(int[] nums) {
        // Boyer-Moore Mojority Voting Algo
        int candidate = nums[0];
        int count = 0;
        for (int n : nums) {
            if (candidate == n) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = n;
                    count++;
                }
            }
        }
        return candidate;
    }

    private static int removeDuplicate(int[] sortedArray) {
        int replacingIndx = 1;
        int iterator = 1;
        while (iterator < sortedArray.length) {
            if (sortedArray[iterator] != sortedArray[iterator - 1]) {
                sortedArray[replacingIndx] = sortedArray[iterator];
                replacingIndx++;
            }
            iterator++;
        }
        return replacingIndx;
    }

    /**
     * Finds the missing element in the given array.(Two-pointers method)
     *
     * @param nums    the array from which the missing element is to be removed
     * @param element the element to be removed
     * @return the number of elements in the array after removing the element
     */
    public static int removeElement(int[] nums, int element) {
        int replacingIndx = 0;
        int iterator = 0;
        while (iterator < nums.length) {
            if (nums[iterator] != element) {
                nums[replacingIndx] = nums[iterator];
                replacingIndx++;
            }
            iterator++;
        }
        return replacingIndx;
    }

    /**
     * Removes even elements from the array and prints the resulting array
     * containing only odd values.
     *
     * @param arr the array from which even elements are to be removed
     */
    public static void removeEven(int[] arr) {
        // Count the number of odd elements in the array
        int oddCount = 0;
        for (int j : arr) {
            if (j % 2 != 0) {
                oddCount++;
            }
        }

        // Create a new array to store the odd elements
        int[] oddArray = new int[oddCount];
        int indx = 0;

        // Copy odd elements from the original array to the new array
        for (int j : arr) {
            if (j % 2 != 0) {
                oddArray[indx] = j;
                indx++;
            }
        }

        // Print the resulting array containing only odd values
        Answer.print(oddArray, "Array with odd values");
    }

    /**
     * Reverses the elements of the given array.
     *
     * @param arr the array to be reversed
     * @return the reversed array
     */
    public static int[] reverseArray(int[] arr) {
        int last = arr.length - 1;

        // Iterate over the array and swap elements to reverse the array
        for (int start = 0; start <= last; start++, last--) {
            int temp = arr[start];
            arr[start] = arr[last];
            arr[last] = temp;
        }

        // Print the reversed array
        Answer.print(arr, "Reversed Array");

        // Return the reversed array
        return arr;
    }

    /**
     * Finds and returns the minimum value in the given array.
     *
     * @param arr the array to find the minimum value from
     * @return the minimum value in the array
     */
    public static int minValue(int[] arr) {
        int min = Integer.MAX_VALUE;

        // Iterate over the array to find the minimum value
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        // Print the minimum value
        Answer.print(min, "Minimum Value in Array");

        // Return the minimum value
        return min;
    }

    /**
     * Finds and returns the second largest element in the given array.
     *
     * @param arr the array to find the second largest element from
     * @return the second largest element in the array
     */
    public static int secondLargestElement(int[] arr) {
        int max = Integer.MIN_VALUE; // Initialize the maximum value
        int secondMax = Integer.MIN_VALUE; // Initialize the second maximum value

        // Iterate over the array to find the second largest element
        for (int i = 0; i < arr.length; i++) {
            // If the current element is greater than the maximum
            if (arr[i] > max) {
                secondMax = max; // Update the second maximum to the previous maximum
                max = arr[i]; // Update the maximum to the current element
            } else if (arr[i] > secondMax && arr[i] != max) {
                // If the current element is greater than the second maximum and not equal to
                // the maximum
                secondMax = arr[i]; // Update the second maximum to the current element
            }
        }

        // Print the second largest element
        Answer.print(secondMax, "Second Largest Value in Array");

        // Return the second largest element
        return secondMax;
    }

    /**
     * Moves all occurrences of zero to the end of the array.
     *
     * @param arr the array in which zeros are to be moved
     * @return the modified array with all zeros placed at the end
     */
    public static int[] placeZeroAtEndOfArray(int[] arr) {
        // 1 Method
        // int index = 0;
        // // Traverse through the array, if element is non-zero, move it to the front
        // for (int i = 0; i < arr.length; i++) {
        //      if (arr[i] != 0) {
        //         arr[index++] = arr[i];
        //      }
        //  }
        //  // Fill the remaining positions with zeros
        //  while (index < arr.length) {
        //      arr[index++] = 0;
        //  }


        // Method 2: Two-pointer technique
        // Initialize two pointers: 'pointer' and 'iterator'
        int pointer = 0;
        int iterator = 0;

        // Iterate through the array
        while (iterator < arr.length) {
            // If the current element is not zero, swap it with the element at 'pointer'
            // and increment 'pointer'
            if (arr[iterator] != 0) {
                swap(arr, pointer, iterator);
                pointer++;
            }
            // Move to the next element
            iterator++;
        }

        // After iterating through the array, all non-zero elements have been moved to the front
        // Print the modified array
        Answer.print(arr, "Array with all zeros at the end");

        // Return the modified array
        return arr;
    }

    /**
     * Swaps the elements at the given indices in the array.
     *
     * @param arr    the array in which the elements are to be swapped
     * @param index1 the index of the first element to be swapped
     * @param index2 the index of the second element to be swapped
     */
    private static void swap(int[] arr, int index1, int index2) {
        // Swap the elements at the given indices
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    /**
     * Resizes the given array to the specified size.
     * If the new size is greater than the original array's size, the additional
     * elements are filled with zeros.
     * If the new size is smaller, excess elements are discarded.
     *
     * @param arr  the array to resize
     * @param size the new size of the array
     * @return the resized array
     */
    public static int[] resizeArray(int[] arr, int size) {
        int[] newArray = new int[size];

        // System.arraycopy(arr, 0, newArray, 0, arr.length); //Method 1
        // newArray = Arrays.copyOf(arr, size); //Method 2

        // Copy elements from the original array to the new array
        System.arraycopy(arr, 0, newArray, 0, arr.length);

        // Print the resized array
        Answer.print(newArray, "New Array with size " + newArray.length);
        return newArray;
    }

    public static <T> T[] resizeArray(T[] arr, int size) {
        T[] newArray = (arr.getClass() == Object[].class)
                ? (T[]) new Object[size]
                : (T[]) Array.newInstance(arr.getClass().getComponentType(), size);
        // System.arraycopy(arr, 0, newArray, 0, arr.length); //Method 1
        // newArray = Arrays.copyOf(arr, size); //Method 2

        // Method 3
        System.arraycopy(arr, 0, newArray, 0, arr.length);
        Answer.print(newArray, "New Array with size " + newArray.length);
        return newArray;
    }

    /**
     * Finds the missing element in the array by mathematical calculation.
     * <p>
     * This method assumes that the array contains elements from the range 1 to n
     * (inclusive), where n is the length of the array plus one. It calculates the
     * sum of all elements from 1 to n using the formula (n * (n + 1)) / 2, then
     * subtracts the sum of elements in the array from this total to find the
     * missing element.
     *
     * @param arr the array containing elements from the range 1 to n (inclusive),
     *            with one element missing
     * @return the missing element
     */
    public static int missingElementByMath(int[] arr) {
        // Calculate the range of the array including the missing element
        int range = arr.length + 1;

        // Calculate the sum of all elements from 1 to n using the mathematical formula
        int sum = (range * (range + 1)) / 2;

        // Subtract the sum of elements in the array from the total sum to find the
        // missing element
        for (int i = 0; i < arr.length; i++) {
            sum -= arr[i];
        }

        // Print the missing element
        Answer.print(sum, "Missing element from array of range 1 to " + (arr.length + 1));

        // Return the missing element
        return sum;
    }

    /**
     * Checks if the given array contains any duplicate elements.
     *
     * This function uses a HashMap to keep track of the elements encountered so far.
     * It iterates over the array and checks if each element is already present in the HashMap.
     * If a duplicate element is found, the function prints "Array contains duplicate" and returns true.
     * If no duplicate element is found after iterating through the entire array, the function prints
     * "Array does not contain duplicate" and returns false.
     *
     * @param nums the array of integers to check for duplicates
     * @return true if the array contains duplicate elements, false otherwise
     */
    public static void containsDuplicate(int[] nums) {
        // Create a HashMap to store the elements encountered so far
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate over the array
        for (int i = 0; i < nums.length; i++) {
            // Check if the current element is already present in the HashMap
            if (map.containsKey(nums[i])) {
                // If a duplicate element is found, print the message and return true
                Answer.print(true, "Array contains duplicate");
                return;
            } else {
                // If no duplicate element is found, add the current element to the HashMap
                map.put(nums[i], i);
            }
        }

        // If no duplicate element is found after iterating through the entire array,
        // print the message and return false
        Answer.print(false, "Array does not contain duplicate");
    }

    /**
     * Calculates the product of all the numbers in the given array except the number at the current index.
     *
     * @param nums the array of integers
     * @return an array of integers where each element at index i is the product of all the numbers in the input array 
     * except nums[i]
     */
    public static int[] productExceptSelf(int[] nums) {
        // Initialize an array to store the final products
        int[] result = new int[nums.length];

        // Calculate prefix products:
        // For each element at index i, the prefix product is the product of all numbers from index 0 to i-1.
        // This is stored in the result array at index i.
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        // Calculate suffix products and combine with prefix products:
        // For each element at index i, the suffix product is the product of all numbers from index i+1 to the end.
        // Multiply the prefix product at index i with the suffix product at index i to get the final product.
        // Store the final product in the result array at index i.
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= suffix; // Multiply with the suffix product
            suffix *= nums[i];
        }

        // Output the result array
        Answer.print(result, "Product of Array Except Self");

        // Return the result array
        return result;
    }

    /**
     * Calculates the running sum of the given array.
     *
     * The running sum of an array is an array where each element at index i is the sum of all elements in the original
     * array up to and including index i.
     *
     * @param nums the array of integers for which the running sum is to be calculated
     * @return an array of integers where each element at index i is the sum of all the numbers in the input array up to
     * and including index i
     *
     * Time complexity: O(n), where n is the length of the input array. This is because we iterate over the array once
     * to calculate the running sum.
     */
    public static int[] runningSum(int[] nums) {
        int n = nums.length; // Get the length of the input array
        int[] runningSum = new int[n]; // Initialize an array to store the running sum
        int sum = 0; // Initialize a variable to store the running sum

        // Iterate over the input array
        for (int i = 0; i < n; i++) {
            sum = sum + nums[i]; // Add the current element to the running sum
            runningSum[i] = sum; // Store the running sum in the corresponding index of the running sum array
        }

        Answer.print(runningSum, "Running Sum"); // Print the running sum array
        return runningSum; // Return the running sum array
    }

}
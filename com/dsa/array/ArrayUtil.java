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

        ArrayUtil.placeZeroAtEndOfArray(new int[]{0, 3, 2, 0, 1});

        ArrayUtil.resizeArray(arr, 10);

        ArrayUtil.missingElementByMath(new int[]{2, 5, 1, 4});

        ArrayUtil.containsDuplicate(new int[]{7, 6, 4, 3, 1});

        ArrayUtil.productExceptSelf(new int[]{1, 2, 3, 4});

        ArrayUtil.runningSum(new int[]{1, 2, 3, 4});

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
        int index = 0;

        // Traverse through the array, if element is non-zero, move it to the front
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[index++] = arr[i];
            }
        }

        // Fill the remaining positions with zeros
        while (index < arr.length) {
            arr[index++] = 0;
        }
        // Print the modified array
        Answer.print(arr, "Array with all zeros at the end");
        return arr;
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
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }

        // Print the resized array
        Answer.print(newArray, "New Array with size " + newArray.length);
        return newArray;
    }

    public static <T> T[] resizeArray(T[] arr, int size) {
        T[] newArray = ((Object) arr.getClass() == (Object) Object[].class)
                ? (T[]) new Object[size]
                : (T[]) Array.newInstance(arr.getClass().getComponentType(), size);
        // System.arraycopy(arr, 0, newArray, 0, arr.length); //Method 1
        // newArray = Arrays.copyOf(arr, size); //Method 2

        for (int i = 0; i < arr.length; i++) { // Method 3
            newArray[i] = arr[i];
        }
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

    public static void containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                Answer.print(true, "Array contains duplicate");
                return;
            } else {
                map.put(nums[i], i);
            }
        }
        Answer.print(false, "Array contain duplicate");
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] productArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j)
                    continue;
                product *= nums[j];
            }
            productArray[i] = product;
        }
        Answer.print(productArray, "Product of Array Except Self");
        return productArray;
    }

    public static int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] runningSum = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
            runningSum[i] = sum;
        }
        Answer.print(runningSum, "Running Sum");
        return runningSum;
    }

}
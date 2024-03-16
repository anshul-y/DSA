package com.dsa.array;

import java.lang.reflect.Array;
import java.util.HashMap;

import com.dsa.Answer;

/**
 * ArrayUtil
 */
public class ArrayUtil {

    ArrayUtil() {
    }

    public static void removeEven(int[] arr) {
        int oddCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0)
                oddCount++;
        }

        int[] oddArray = new int[oddCount];
        int indx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                oddArray[indx] = arr[i];
                indx++;
            }
        }
        Answer.print(oddArray, "Array with odd values");
    }

    public static int[] reverseArray(int[] arr) {
        int last = arr.length - 1;
        for (int start = 0; start <= last; start++, last--) {
            int temp = arr[start];
            arr[start] = arr[last];
            arr[last] = temp;
        }
        Answer.print(arr, "Reversed Array");
        return arr;
    }

    public static int minValue(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        Answer.print(min, "Minimum Value in Array");
        return min;
    }

    public static int secondLargestElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        Answer.print(secondMax, "Second Largest Value in Array");
        return secondMax;
    }

    public static int[] placeZeroAtEndOfArray(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && arr[j] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if (arr[j] != 0)
                j++;
        }
        Answer.print(arr, "Array with all zero's at the end");
        return arr;
    }

    public static int[] resizeArray(int[] arr, int size) {
        int[] newArray = new int[size];
        // System.arraycopy(arr, 0, newArray, 0, arr.length); //Method 1
        // newArray = Arrays.copyOf(arr, size); //Method 2

        for (int i = 0; i < arr.length; i++) { // Method 3
            newArray[i] = arr[i];
        }
        Answer.print(newArray, "New Array with size " + newArray.length);
        return newArray;
    }

    public static <T> T[] resizeArray(T[] arr, int size) {
        // T[] newArray = new T[size];
        T[] newArray = ((Object)arr.getClass() == (Object)Object[].class)
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

    public static int missingElementByMath(int[] arr) {
        int range = arr.length + 1;
        int sum = (range * (range + 1)) / 2;
        for (int i = 0; i < arr.length; i++) {
            sum -= arr[i];
        }
        Answer.print(sum, "Missing element from array of range 1 to " + (arr.length + 1));
        return sum;
    }

    public static int maxSubArray(int[] array) {
        KadanAlgo kadanAlgo = new KadanAlgo(array);
        int maxSubArray = kadanAlgo.maxSubArray();
        Answer.print(maxSubArray, "Maximum Sub-array Value");
        return maxSubArray;
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int complementIndex = map.get(nums[i]);
                int[] indices = new int[] { complementIndex, i };
                Answer.print(indices, "Indexes of element for Two sum to " + target);
                return indices;
            } else {
                int complement = target - nums[i];
                map.put(complement, i);
            }
        }
        Answer.print(nums, "Indexes of element for Two sum to " + target);
        return nums;
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
        for(int i=0;i<n;i++){
            sum = sum + nums[i];
            runningSum[i]=sum;  
        }
        Answer.print(runningSum, "Running Sum");
        return runningSum;
    }

    public static void main(String[] args) {

        int[] arr = { -2, 1, -3, 4 };
        Answer.print(arr, "Default Array");

        ArrayUtil.removeEven(arr);

        ArrayUtil.reverseArray(arr);

        ArrayUtil.minValue(arr);

        ArrayUtil.secondLargestElement(arr);

        ArrayUtil.placeZeroAtEndOfArray(arr);

        ArrayUtil.resizeArray(arr, 10);

        ArrayUtil.missingElementByMath(new int[] {2,5,1,4});

        ArrayUtil.maxSubArray(new int[]{ -2, 1, -3, 4 });

        int[] nums = { 5, 2, 4 };
        Answer.print(nums, "Default Array");
        ArrayUtil.twoSum(nums, 6);

        int[] prices = { 7, 6, 4, 1, 3, 1 };
        Answer.print(prices, "Price Array");
        int profit = SlidingWindow.maxProfit(prices);
        Answer.print(profit, "Max profit from stock");

        ArrayUtil.containsDuplicate(new int[] { 7, 6, 4, 3, 1 });

        ArrayUtil.productExceptSelf(new int[] { 1, 2, 3, 4 });

        ArrayUtil.runningSum(new int[] { 1, 2, 3, 4 });


    }

}
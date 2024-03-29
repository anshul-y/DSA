package questions;

import com.dsa.Answer;
import org.jetbrains.annotations.NotNull;

/**
 * DutchNationFlag
 */
public class DutchNationFlag {

    /**
     * Sorts an array containing only 0s, 1s, and 2s (Dutch National Flag problem).
     *
     * @param arr the array to be sorted
     */
    private static void sort(int @NotNull [] arr) {
        int i = 0;
        int j = 0;
        int k = arr.length - 1;

        // Iterate over the array until all elements are processed
        while (i <= k) {
            if (arr[i] == 0) {
                // If the current element is 0, swap it with the element at index j and
                // increment both i and j
                swap(arr, i, j);
                j++;
                i++;
            } else if (arr[i] == 2) {
                // If the current element is 2, swap it with the element at index k and
                // decrement k
                swap(arr, i, k);
                k--;
            } else {
                // If the current element is 1, simply move to the next element
                i++;
            }
        }
    }

    /**
     * Swaps two elements in an array.
     *
     * @param arr the array in which elements are to be swapped
     * @param i   the index of the first element
     * @param j   the index of the second element
     */
    private static void swap(int @NotNull [] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 0, 2, 2, 0, 1, 1 };
        Answer.print(arr, "Array");
        sort(arr);
        Answer.print(arr, "Array");
    }

}
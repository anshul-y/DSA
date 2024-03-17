package questions;

import com.dsa.Answer;

public class SquaresOfSortedArray {

    // private static void sortedSquares(int[] arr) { // brute force
    // // square Of Array
    // for (int i = 0; i < arr.length; i++) {
    // arr[i] = arr[i] * arr[i];
    // }
    // MergeSort.sort(arr, 0, arr.length - 1);
    // }

    private static int[] sortedSquares(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        int[] result = new int[arr.length];
        for (int k = result.length - 1; k >= 0; k--) {
            if (Math.abs(arr[i]) > Math.abs(arr[j])) {
                result[k] = arr[i] * arr[i];
                i++;
            } else {
                result[k] = arr[j] * arr[j];
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { -4, -2, 0, 3, 9 };
        Answer.print(arr, "Array");

        int[] result = sortedSquares(arr);
        Answer.print(result, "Sorted Array");

    }

}

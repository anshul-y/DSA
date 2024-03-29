package questions;

import com.dsa.Answer;

public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        Answer.print(result, "Product of an array Expect self");
    }

    /**
     * Returns the product of all elements in the input array except the element at the specified index.
     *
     * @param nums the input array
     * @return the product of all elements in the input array except the element at the specified index
     */
    private static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int temp = 1;
        // to calculate the product of left side and store the result
        for (int i = 0; i < nums.length; i++) {
            result[i] = temp;
            temp = temp * nums[i];
        }
        temp = 1;
        // calculate the product of the right side and multiply with the result i.e. left side of current number
        for (int j = nums.length - 1; j >= 0; j--) {
            result[j] = result[j] * temp;
            temp = temp * nums[j];
        }
        return result;
    }
}

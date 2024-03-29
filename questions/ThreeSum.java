package questions;

import java.util.Arrays;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 7, 1, 0};
        threeSum(nums, 5);
    }

    private static void threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    System.out.println("{" + nums[i] + ", " + nums[left] + ", " + nums[right] + "}");
                    left++;
                    right--;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
    }
}

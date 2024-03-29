package questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        System.out.println(Arrays.toString(twoSumWithTwoPointer(nums, target)));
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remainingNum = target - nums[i];
            if (map.containsKey(remainingNum)) {
                indexes[0] = map.get(remainingNum);
                indexes[1] = i;
                return indexes;
            }
            map.put(nums[i], i);
        }
        return indexes;
    }

    private static int[] twoSumWithTwoPointer(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (target == sum) {
                result[0] = left;
                result[1] = right;
                return result;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[0];
    }
}

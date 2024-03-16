package com.dsa.array;

import java.util.HashMap;

public class Sum {
    private Sum(){
    }
    
    public static int[] twoSumUsingHashMap(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                int complementIndex = map.get(nums[i]);
                return new int[]{complementIndex,i};
            }else{
                int complement = target - nums[i];
                map.put(complement,i);
            }
        }
        return nums;
    }
}

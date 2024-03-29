package com.dsa.algo.sliding_window;

import com.dsa.Answer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    public static void main(String[] args) {
        String str = "wpwwpkew";
        int longest = longestSubstring(str);
        Answer.print(longest, "Longest Substring without repeating Characters");
    }

    private static int longestSubstring(String str) {
        int maxLength = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(map.get(c) + 1, start);
            }
            map.put(c, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}

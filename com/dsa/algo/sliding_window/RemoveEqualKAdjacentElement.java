package com.dsa.algo.sliding_window;

import com.dsa.Answer;

public class RemoveEqualKAdjacentElement {

    public static String removeAdjacentChar(String str, int maxAdjacent) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        if (chars.length == 1) {
            return str;
        }
        int start = 0;
        int adjacentCount = 1;
        sb.append(chars[start]);
        for (int end = 1; end < chars.length; end++) {
            if (chars[start] == chars[end]) {
                adjacentCount++;
                sb.append(chars[end]);
                if (adjacentCount == maxAdjacent) {
                    sb.delete(sb.length() - maxAdjacent, sb.length());
                    adjacentCount = 0;
                }
            } else {
                adjacentCount = 0;
                start = end;
                sb.append(chars[end]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String result = removeAdjacentChar("assassinate", 2);
        Answer.print(result, "Removed Equal Kth adjacent character");
        System.out.println(result);
    }
}

package com.dsa.string;

import com.dsa.Answer;
import com.dsa.stack.StackArray;

import java.util.*;

public class StringUtil {

    public static void main(String[] args) {
        boolean isPalindrome = StringUtil.isPalindrome("malayalam");
        Answer.print(isPalindrome, "Valid Palindrome");

        StringUtil.reverseStringUsingStack("abc");

        boolean result = StringUtil.isSubSeq("abcde", "ace");
        Answer.print(result, "Valid Subsequence");

        int index = StringUtil.nonRepeatingCharIndex("codeforcode");
        Answer.print(index, "Non Repeating Character Index");

        String word = StringUtil.removeVowels("What is your name?");
        Answer.print(word, "Removed Vowels");
    }

    private static String removeVowels(String sentence) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            if (!vowels.contains(sentence.charAt(i))) {
                sb.append(sentence.charAt(i));
            }
        }
        return sb.toString();
    }

    private static int nonRepeatingCharIndex(String word) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = word.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isSubSeq(String word, String sequence) {
        int j = 0;
        int i = 0;
        while (i < word.length() && j < sequence.length()) {
            if (sequence.charAt(j) == word.charAt(i)) {
                j++;
            }
            i++;
        }
        return j == sequence.length();
    }

    public static boolean isPalindrome(String word) {
        boolean isPalindrome = true;
        int j = word.length() - 1;
        for (int i = 0; i <= j; i++, j--) {
            if (word.charAt(i) != word.charAt(j)) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    public static void reverseStringUsingStack(String wordArr) {
        StackArray stack = new StackArray(wordArr.length());
        for (int i = 0; i < wordArr.length(); i++) {
            stack.push(wordArr.charAt(i));
        }
        System.out.print(wordArr + " -> ");
        for (int i = 0; i < wordArr.length(); i++) {
            System.out.print(stack.pop().toString());
        }
        System.out.println();
    }

}

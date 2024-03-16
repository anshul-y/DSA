package com.dsa.string;

import com.dsa.stack.StackArray;

public class StringUtil {

    public static void print(boolean value, String mssg) {
        System.out.print(mssg + " : ");
        System.out.print(value);
        System.out.println();
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
        print(isPalindrome, "Palindrome");
        return isPalindrome;
    }

    public static void reverseStringUsingStack(String wordArr) {
        StackArray stack = new StackArray(wordArr.length());
        for (int i = 0; i < wordArr.length(); i++) {
            stack.push(wordArr.charAt(i));
        }
        System.out.print(wordArr+ " -> ");
        for (int i = 0; i < wordArr.length(); i++) {
            System.out.print(stack.pop().toString());
        }
    }

    public static void main(String[] args) {
        // StringUtil.isPalindrome("malayalam");

        reverseStringUsingStack("abc");
    }
    
}

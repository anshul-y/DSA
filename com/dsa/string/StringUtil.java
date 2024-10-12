package com.dsa.string;

import com.dsa.Answer;
import com.dsa.stack.StackArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * Removes all vowels from a given sentence.
     *
     * @param sentence The sentence from which to remove vowels.
     * @return A new string with all vowels removed.
     * @author Anshul
     * @version 1.0
     * @since 2023-01-01
     */
    private static String removeVowels(String sentence) {
        // Create a list of vowels
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

        // Create a StringBuilder to build the new string
        StringBuilder sb = new StringBuilder();

        // Iterate over each character in the sentence
        for (int i = 0; i < sentence.length(); i++) {
            // If the current character is not a vowel, append it to the StringBuilder
            if (!vowels.contains(sentence.charAt(i))) {
                sb.append(sentence.charAt(i));
            }
        }

        // Convert the StringBuilder to a string and return it
        return sb.toString();
    }

        /**
         * Finds the index of the first non-repeating character in a given word.
         *
         * @param word The word to search for the first non-repeating character.
         * @return The index of the first non-repeating character in the word. If all characters are repeating, returns -1.
         *
         * @author Anshul
         * @version 1.0
         * @since 2023-01-01
         */
        private static int nonRepeatingCharIndex(String word) {
            // Create a map to store each character and its count in the word
            Map<Character, Integer> map = new HashMap<>();

            // Convert the word to a character array for easier iteration
            char[] chars = word.toCharArray();

            // Iterate over each character in the word
            for (char c : chars) {
                // If the character is already in the map, increment its count
                // If the character is not in the map, add it with a count of 1
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            // Iterate over each character in the word again
            for (int i = 0; i < chars.length; i++) {
                // If the count of the current character in the map is 1, return its index
                if (map.get(chars[i]) == 1) {
                    return i;
                }
            }

            // If no non-repeating character is found, return -1
            return -1;
        }

    /**
     * Checks if a given sequence is a subsequence of another word.
     * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without
     * changing the order of the remaining elements.
     *
     * @param word The word to check if it contains the sequence.
     * @param sequence The sequence to check if it is a subsequence of the word.
     * @return {@code true} if the sequence is a subsequence of the word, {@code false} otherwise.
     *
     * @author Anshul
     * @version 1.0
     * @since 2023-01-01
     */
    private static boolean isSubSeq(String word, String sequence) {
        // Initialize counters for the word and sequence
        int sequenceCounter = 0;
        int wordCounter = 0;

        // Iterate over the word and sequence until the end of either is reached
        while (wordCounter < word.length() && sequenceCounter < sequence.length()) {
            // If the current character in the sequence matches the current character in the word, increment the sequence counter
            if (sequence.charAt(sequenceCounter) == word.charAt(wordCounter)) {
                sequenceCounter++;
            }
            // Move to the next character in the word
            wordCounter++;
        }

        // If the sequence counter has reached the end of the sequence, the sequence is a subsequence of the word
        // Return true
        // Otherwise, return false
        return sequenceCounter == sequence.length();
    }

    /**
     * Checks if a given word is a palindrome. A palindrome is a word, phrase, number, or other sequence of characters
     * that reads the same forward and backward, ignoring spaces, punctuation, and capitalization.
     *
     * @param word The word to check for palindrome.
     * @return {@code true} if the word is a palindrome, {@code false} otherwise.
     *
     * @author Anshul
     * @version 1.0
     * @since 2023-01-01
     */
    public static boolean isPalindrome(String word) {
        boolean isPalindrome = true;
        int j = word.length() - 1;
        for (int i = 0; i <= j; i++, j--) {
            // If the current character from the start of the word is not equal to the current character from the end,
            // the word is not a palindrome.
            if (word.charAt(i) != word.charAt(j)) {
                isPalindrome = false;
                break;
            }
        }
        // Return the result indicating whether the word is a palindrome or not.
        return isPalindrome;
    }

    /**
     * Reverses a given string using a stack.
     *
     * @param wordArr The string to be reversed.
     *
     * @author Anshul
     * @version 1.0
     * @since 2023-01-01
     */
    public static void reverseStringUsingStack(String wordArr) {
        // Create a stack with the size of the input string
        StackArray stack = new StackArray(wordArr.length());
    
        // Push each character of the input string onto the stack
        for (int i = 0; i < wordArr.length(); i++) {
            stack.push(wordArr.charAt(i));
        }
    
        // Print the original string
        System.out.print(wordArr + " -> ");
    
        // Pop each character from the stack and print it
        for (int i = 0; i < wordArr.length(); i++) {
            System.out.print(stack.pop().toString());
        }

        // Print a newline character
        System.out.println();
    }

}

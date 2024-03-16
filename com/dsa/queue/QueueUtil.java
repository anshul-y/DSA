package com.dsa.queue;

import java.util.LinkedList;
import java.util.Queue;

import com.dsa.Answer;

public class QueueUtil {

    /**
     * Generates an array of binary numbers up to a given number.
     * 
     * @param n The number of binary numbers to generate.
     */
    public static void generateBinaryNumber(int n) {
        String[] result = new String[n];
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        for (int i = 0; i < result.length; i++) {
            String binary = queue.poll();
            result[i] = binary;
            queue.offer(binary.concat("0"));
            queue.offer(binary.concat("1"));
        }
        Answer.print(result, "Binary Numbers");
    }

    public static void main(String[] args) {
        generateBinaryNumber(15);
    }
}

package com.dsa;

import com.dsa.custom_class.ListNode;

import java.util.Stack;

public class Answer<T> {
    private Stack<T> stack;
    private ListNode head;

    public Answer() {
    }

    public Answer(Stack<T> stack) {
        this.stack = stack;
    }

    public Answer(ListNode head) {
        this.head = head;
    }

    public static void print(int[] arr, String mssg) {
        System.out.print(mssg + " : { ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("}");
        System.out.println();
    }

    public static <T> void print(T[] arr, String mssg) {
        System.out.print(mssg + " : { ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("}");
        System.out.println();
    }

    public static void print(String[] arr, String mssg) {
        System.out.print(mssg + " : { ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("}");
        System.out.println();
    }

    public static void print(int data, String mssg) {
        System.out.println(mssg + " : " + data);
    }

    public static void print(boolean data, String mssg) {
        System.out.println(mssg + " : " + data);
    }

    public static void print(String data, String mssg) {
        System.out.println(mssg + " : " + data);
    }

    public void printStack() {
        Object[] iterator = stack.toArray();
        System.out.println("| |");
        for (int i = iterator.length - 1; i >= 0; i--) {
            System.out.println("|" + iterator[i] + "|");
        }
        System.out.println("|-|");
    }

    public void printLinkedList() {
        ListNode current = this.head;
        while (current.next != null) {
            System.out.print(current.getData() + " >> ");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void print(int[][] matrix, String mssg) {
        mssg = mssg + ": ";
        int n = mssg.length();
        for (int i = 0; i < matrix.length; i++) {
            if (i == 0) {
                System.out.print(mssg);
            } else {
                System.out.printf("%1$" + n + "s", "");
            }
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}

package com.dsa;

import java.util.Stack;
import java.util.logging.Logger;

public class Answer<T> {
    private static final Logger logger = Logger.getLogger(Answer.class.getName());
    private Stack<T> stack;
    private ListNode head;

    public Answer(){}

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
        while(current.next!=null) {
            System.out.print(current.getData()+" >> ");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }

}

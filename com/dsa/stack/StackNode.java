package com.dsa.stack;

import java.util.EmptyStackException;

import com.dsa.custom_class.ListNode;

/**
 * Stack
 */
public class StackNode<T> {

    private ListNode head;
    private int length;

    StackNode() {
        this.head = null;
        this.length = 0;
    }

    /**
     * Checks if the length of the object is equal to zero.
     * 
     * @return true if the length is zero, false otherwise.
     */
    private boolean isEmpty() {
        return length == 0;
    }

    /**
     * Adds a new element to the top of the stack.
     * 
     * @param val the value of the element to be added
     */
    public void push(int val) {
        ListNode temp = new ListNode(val);
        temp.next = this.head;
        head = temp;
        length++;
        System.out.println("Push: " + val);
    }

    /**
     * Removes and returns the top element of the stack.
     * 
     * @return the top element of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object data = this.head.getData();
        this.head = this.head.next;
        length--;
        System.out.println("Pop: " + data);
        return data;
    }

    /**
     * Retrieves the element at the top of the stack without removing it.
     * Throws an EmptyStackException if the stack is empty.
     */
    public void peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        System.out.println("Peek: " + head.getData());
    }

    /**
     * Prints the elements of the linked list in reverse order.
     */
    public void print() {
        int size = this.length;
        ListNode top = this.head;
        for (int i = size - 1; i >= 0; i--) {
            System.out.println("|" + top.getData() + "|");
            top = top.next;
        }
        System.out.println("|-|");
    }

    public static void main(String[] args) {
        StackNode<Integer> stack = new StackNode<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);

        stack.print();

        stack.pop();
        stack.print();
    }
}
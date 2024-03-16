package com.dsa.stack;

import java.util.EmptyStackException;

public class StackArray {

    private Object[] stack;
    private int top;
    private int size;

    public StackArray(int size) {
        this.size = size;
        this.stack = new Object[size];
        top = -1;
    }

    /**
     * Adds an element to the top of the stack.
     * 
     * @param data the element to be added to the stack
     * @throws StackOverflowError if the stack is already full
     */
    public void push(Object data) {
        if (top >= this.size)
            throw new StackOverflowError();
        top++;
        this.stack[top] = data;
    }

    /**
     * Removes and returns the top element from the stack.
     * 
     * @return The top element of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    public Object pop() {
        if (top < 0)
            throw new EmptyStackException();
        Object data = this.stack[top];
        this.stack[top] = 0;
        top--;
        return data;
    }

    /**
     * Prints the elements of the stack in a vertical format.
     */
    public void print() {
        for (int i = top; i >= 0; i--) {
            System.out.println("|" + this.stack[i] + "|");
        }
        System.out.println("|-|");
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.print();
        stack.pop();
        stack.print();
    }
}

package com.dsa.linked_list;

import java.util.NoSuchElementException;

import com.dsa.ListNode;

public class DoublyLinkedList {

    ListNode head;
    ListNode tail;
    int length;

    DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0; // head==null
    }

    public int getLength() {
        return length;
    }

    private void printBackward() {
        if (this.tail == null) {
            return;
        }
        ListNode temp = this.tail;
        while (temp != null) {
            System.out.print(temp.getData() + " >> ");
            temp = temp.previous;
        }
        System.out.print("null");
        System.out.println();
    }

    private void printForward() {
        if (this.head == null) {
            System.out.println("null");
            return;
        }
        ListNode temp = this.head;
        while (temp != null) {
            System.out.print(temp.getData() + " >> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void insertFirst(int data) {
        ListNode temp = new ListNode(data);
        if (this.head == null) {
            this.tail = temp;
        } else {
            this.head.previous = temp;
            temp.next = this.head;
        }
        this.head = temp;
    }

    public void deleteFirst() {
        if (this.head == null) {
            throw new NoSuchElementException();
        } 
        ListNode firstNode = this.head;
        if(this.tail == this.head){
            this.tail = null;
        }else {
            this.head.next.previous = null;
        }
        this.head = this.head.next;
        firstNode.next = null;
    }

    public void deleteLast() {
        if (this.tail == null) {
            throw new NoSuchElementException();
        }
        ListNode lastNode = this.tail;
        if (this.tail == this.head) {
            this.head = null;
        } else {
            this.tail.previous.next = null;
        }
        this.tail = this.tail.previous;
        lastNode.previous = null;
    }

    public void insertEnd(int data) {
        ListNode newNode = new ListNode(data);
        if (this.tail == null) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
            newNode.previous = this.tail;
        }
        this.tail = newNode;
    }

    public static void main(String[] args) {
        // ListNode head = new ListNode(0);
        // ListNode second = new ListNode(1);
        // second.previous = head;
        // second.next = head.next;
        // head.next = second;
        // print(head);

        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertEnd(1);
        dll.insertFirst(0);
        dll.insertEnd(2);
        dll.printForward();

        // dll.deleteFirst();
        // dll.deleteFirst();
        // dll.deleteFirst();
        // dll.printForward();

        dll.deleteLast();
        dll.deleteLast();
        dll.deleteLast();
        dll.printForward();

    }

}

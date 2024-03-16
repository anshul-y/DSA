package com.dsa.linked_list;

import java.util.NoSuchElementException;

import com.dsa.ListNode;

public class CircularSinglyLinkedList {

    private ListNode last;

    CircularSinglyLinkedList() {
        this.last = null;
    }

    public void print() {
        if (this.last == null)
            return;

        ListNode current = this.last.next;
        while (current != this.last) {
            System.out.print(current.getData() + " >> ");
            current = current.next;
        }
        System.out.print(current.getData());
        System.out.println();
    }

    public void insertFirst(int data) {
        ListNode temp = new ListNode(data);
        if (this.last == null) {
            this.last = temp;
        } else {
            temp.next = this.last.next;
        }
        this.last.next = temp;
    }

    public void insertLast(int data) {
        ListNode temp = new ListNode(data);
        if (this.last == null) {
            temp.next = temp;
        } else {
            temp.next = this.last.next;
            this.last.next = temp;
        }
        this.last = temp;
    }

    public void removeFirst() {
        if(this.last==null){
            throw new NoSuchElementException();
        }
        ListNode first = this.last.next;
        if(last == last.next){
            this.last = null;
        }else{
            this.last.next = first.next;
        }
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.insertLast(1);
        csll.insertLast(2);
        csll.insertLast(3);
        csll.insertFirst(0);
        csll.print();
        csll.removeFirst();
        csll.removeFirst();
        csll.removeFirst();
        csll.print();

    }
}

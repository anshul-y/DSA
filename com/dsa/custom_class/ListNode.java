package com.dsa.custom_class;

public class ListNode {  
    private int data;
    public ListNode next;
    public ListNode previous;

    public ListNode(int data) {  
        this.data = data;  
        this.next = null;  
        this.previous = null;  
    }
  
    public int getData(){
        return data;
    }
}  
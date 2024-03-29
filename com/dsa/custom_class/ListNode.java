package com.dsa.custom_class;

public class ListNode {  
    private int data;
    public ListNode next = null;
    public ListNode previous = null;

    public ListNode(int data) {  
        this.data = data;  
        this.next = null;  
        this.previous = null;  
    }
  
    public int getData(){
        return data;
    }
}  
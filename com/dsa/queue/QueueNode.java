package com.dsa.queue;

import com.dsa.custom_class.ListNode;

public class QueueNode {
    private ListNode front;
    private ListNode end;
    private int length;

    QueueNode(){
        length = 0;
        front = null;
        end = null;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public void enqueue(int data){
        ListNode node = new ListNode(data);
        if(isEmpty()){
            front = node;
        }else{
            end.next = node;
        }
        end = node;
        length++;
        print();
    }

    public int dequeue(){
        int data = front.getData();
        front = front.next;
        if(front==null){
            end = null;
        }
        length--;
        print();
        return data;
    }

    public int first() {
        return front.getData();
    }

    public int last() {
        return end.getData();
    }

    public void print() {
        ListNode current = front; 
        while (current!=null) {
            System.out.print(current.getData()+" > ");
            current = current.next;            
        }
        System.out.print("null");
        System.out.println();
    }

}

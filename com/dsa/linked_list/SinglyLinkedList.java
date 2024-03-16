package com.dsa.linked_list;

import com.dsa.Answer;
import com.dsa.ListNode;

public class SinglyLinkedList<T> {

    public ListNode head;
    private int length;

    SinglyLinkedList() {
        this.length = 0;
    }

    public int getLength() {
        ListNode current = this.head;
        int count = 1;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    public void print() {
        ListNode current = this.head;
        while (current != null) {
            System.out.print(current.getData() + " >> ");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void linkListAtNode(int position) {
        if (getLength() < position || position <= 0) {
            throw new IndexOutOfBoundsException();
        }
        ListNode current = this.head;
        ListNode temp = null;
        while (current.next != null) {
            position--;
            if (position == 0) {
                temp = current;
            }
            current = current.next;
        }
        current.next = temp;
    }

    public void insertFirst(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
    }

    public void insertEnd(int data) {
        ListNode newNode = new ListNode(data);
        if (this.head == null) {
            this.head = newNode;
            this.length++;
            return;
        }
        ListNode current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        this.length++;
    }

    public void insert(int data, int position) {
        if (position == 1) {
            insertFirst(data);
        } else {
            ListNode newNode = new ListNode(data);
            ListNode previous = head;
            for (int i = 1; i < position - 1; i++) {
                previous = previous.next;
            }
            ListNode current = previous.next;
            newNode.next = current;
            previous.next = newNode;
            length++;
        }
    }

    public void deleteFirst() {
        if (head == null) {
            return;
        }
        ListNode firstNode = this.head;
        this.head = firstNode.next;
        firstNode.next = null;
    }

    public void deleteEnd() {
        if (this.head == null) {
            return;
        }
        ListNode current = this.head;
        ListNode previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            this.head = null;
        } else {
            previous.next = current.next;
        }
        current.next = null;
    }

    public void delete(int position) {
        if (position == 1) {
            this.head = this.head.next;
        } else {
            ListNode previous = this.head;
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            ListNode next = current.next;
            previous.next = next;
            current.next = null;
        }

    }

    public void search(int data) {
        ListNode current = this.head;
        int count = 1;
        while (current != null) {
            if (current.getData() == data) {
                Answer.print(count, "Found " + data + " at position ");
                return;
            }
            current = current.next;
            count++;
        }
        System.out.println(data + " is not present in list");
    }

    public void reverse() {
        ListNode current = this.head;
        ListNode previous = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        this.head = previous;
    }

    public void middleNode() {
        ListNode slowNode = this.head;
        ListNode fastNode = this.head;
        int position = 1;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            position++;
        }
        System.out.println("Middle Node at " + position + ": " + slowNode.getData());
    }

    public void nodeFromLast(int position) {
        ListNode mainNode = this.head;
        ListNode refNode = this.head;
        int count = 0;
        while (count < position) {
            refNode = refNode.next;
            count++;
        }
        while (refNode != null) {
            refNode = refNode.next;
            mainNode = mainNode.next;
        }
        System.out.println(position + "th Node from end: " + mainNode.getData());
    }

    public void removeDuplicates() {
        ListNode current = this.head;
        while (current != null && current.next != null) {
            if (current.getData() == current.next.getData()) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public void insertInSortedList(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = this.head;
        ListNode prevNode = null;
        while (current != null && current.getData() < newNode.getData()) {
            prevNode = current;
            current = current.next;
        }
        if (prevNode == null) {
            insertFirst(data);
        } else {
            newNode.next = prevNode.next;
            prevNode.next = newNode;
        }
    }

    public void deleteKey(int data) {
        ListNode current = this.head;
        ListNode temp = null;
        if (current != null && current.getData() == data) {
            this.head = current.next;
            return;
        }
        while (current != null && current.getData() != data) {
            temp = current;
            current = current.next;
        }
        if (current == null)
            return;
        temp.next = current.next;
    }

    public boolean containsLoop() {
        ListNode slowNode = this.head;
        ListNode fastNode = this.head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode.getData() == fastNode.getData()) {
                return true;
            }
        }
        return false;
    }

    public void startNodeOfLoop() {
        ListNode slowNode = this.head;
        ListNode fastNode = this.head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode.getData() == fastNode.getData()) {
                int data = getStartingNode(slowNode).getData();
                Answer.print(data, "Starting node of loop");
                return;
            }
        }
    }

    private ListNode getStartingNode(ListNode slowNode) {
        ListNode temp = this.head;
        while (temp != slowNode) {
            temp = temp.next;
            slowNode = slowNode.next;
        }
        return temp;
    }

    public void removeLoop() {
        ListNode slowNode = this.head;
        ListNode fastNode = this.head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (fastNode == slowNode) {
                removeLink(slowNode);
                return;
            }
        }

    }

    private void removeLink(ListNode slowNode) {
        ListNode temp = this.head;
        while (temp.next != slowNode.next) {
            temp = temp.next;
            slowNode = slowNode.next;
        }
        slowNode.next=null;
    }

    public void sort(){
        ListNode current = this.head;
    }

    public void removeAndAddNode(ListNode node) {
        ListNode current = this.head;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();

        sll.insertEnd(3);
        sll.insertFirst(2);
        sll.insertFirst(1);
        sll.insertEnd(4);
        sll.insert(5, 5);
        sll.print();
        // sll.deleteFirst();

        // sll.deleteEnd();
        // sll.print();

        // sll.delete(1);
        // sll.print();

        // sll.search(3);
        // sll.search(6);

        // sll.reverse();
        // sll.print();

        // sll.middleNode();

        // sll.nodeFromLast(2);

        // sll.removeDuplicates();
        // sll.print();

        // sll.insertInSortedList(1);
        // sll.print();

        // sll.deleteKey(1);
        // sll.print();

        sll.linkListAtNode(3);
        boolean result = sll.containsLoop();
        Answer.print(result, "Loop detected in Linked List");

        sll.startNodeOfLoop();

        sll.removeLoop();
        boolean isLoop = sll.containsLoop();
        Answer.print(isLoop, "Loop detected in Linked List");

    }

}

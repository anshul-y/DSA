package com.dsa.linked_list;

import com.dsa.custom_class.ListNode;


public class LinkedListUtil {

    LinkedListUtil() {
    }

    private static void print(ListNode mergeHeadNode) {
        while (mergeHeadNode != null) {
            System.out.print(mergeHeadNode.getData() + " >> ");
            mergeHeadNode = mergeHeadNode.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static ListNode mergeSort(ListNode a, ListNode b) {
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;
        while (a != null && b != null) {
            if (a.getData() < b.getData()) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if (a != null) {
            tail.next = a;
        } else {
            tail.next = b;
        }
        return dummyNode.next;
    }

    public static ListNode sort(ListNode listHead) {
        if (listHead == null || listHead.next == null) { // return if one node in list
            return listHead;
        }
        ListNode temp = listHead;
        ListNode slow = listHead;
        ListNode fast = listHead;
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        ListNode leftHead = sort(listHead);
        ListNode rigthHead = sort(slow);
        return mergeSort(leftHead, rigthHead);
    }

    public static ListNode addList(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while (a != null || b != null) {
            int x = a!=null?a.getData():0;
            int y = b!=null?b.getData():0;
            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;
            tail.next = new ListNode(sum);
            if(a!=null) a = a.next;
            if(b!=null) b = b.next;
            tail = tail.next;
        }
        if(carry!=0){
            tail.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        SinglyLinkedList<Integer> firstLL = new SinglyLinkedList<>();
        firstLL.insertFirst(5);
        firstLL.insertEnd(4);
        // firstLL.insertEnd(6);
        firstLL.print();


        SinglyLinkedList<Integer> secondLL = new SinglyLinkedList<>();
        secondLL.insertFirst(5);
        secondLL.insertEnd(6);
        secondLL.insertEnd(4);
        secondLL.print();

        ListNode sum = LinkedListUtil.addList(firstLL.head, secondLL.head);
        print(sum);

        // sort(firstLL.head);
        // sort(secondLL.head);
        // ListNode mergeHeadNode = LinkedListUtil.mergeSort(firstLL.head, secondLL.head);
        // print(mergeHeadNode);
    }

    

}

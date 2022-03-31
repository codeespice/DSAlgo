package com.g.ds.linkedlist;
 class ListNode1 {
      int val;
    ListNode1 next;
      ListNode1() {}
      ListNode1(int val) { this.val = val; }
      ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
  }

public class MiddleLinkedList {

    public ListNode1 middleNode(ListNode1 head) {
        ListNode1 fPointer = head;
        ListNode1 sPointer = head;

        while(sPointer!=null){

            sPointer=sPointer.next;
            if(sPointer!=null){
                sPointer=sPointer.next;
                fPointer = fPointer.next;
            }
        }

        return fPointer;
    }
    public static void main(String args[]){

    }
}

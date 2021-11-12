package com.g.ds.linkedlist;

import com.g.ds.tree.Node;

/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]

 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class RemoveNthNode {


        public ListNode removeNthNodeFromEnd(ListNode head,int n){
            ListNode dummy = new ListNode(); //dummy to hold root node
            dummy.next = head ;
            ListNode runner = dummy; //runner node to find the end
            ListNode walker = dummy; //walker node to hit the exact node . this method saves second iteration to find the element

            for(int i=1;i<=n+1;i++){
                runner=runner.next;
            }
            //move until runner hits end
            while(runner !=null){
                walker= walker.next;
                runner =runner.next;
            }
            //at this step you are at nth element to remove So just change the pointer
            walker.next =walker.next.next;

            return dummy.next;
        }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode headHolder = head;
        for(int i=2;i<10;i++){
            ListNode dummy =  new ListNode(i);
            dummy.next=head;
            head= dummy;
        }
       /* System.out.println("before removal of Node");
        while(headHolder  !=null){

            System.out.print(head.val +",");
            head = head.next;
        }*/

        RemoveNthNode removeNode = new RemoveNthNode();
        ListNode result = removeNode.removeNthNodeFromEnd(head,2);
        System.out.println("After removal of Node");
        while(result !=null){

            System.out.print(result.val+",");
            result = result .next;
        }

    }
}



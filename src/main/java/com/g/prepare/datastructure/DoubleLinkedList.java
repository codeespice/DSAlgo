package com.g.prepare.datastructure;

public class DoubleLinkedList<T> {

    Node head;
    static class Node<T>{
        T value;
        Node previous;
        Node next;


        public Node(T value,Node previous,Node next)
        {
            this.value=value;
            this.next=next;
            this.previous=previous;

        }
    }
    //add element always at the start
    public void addElement(T value)
    {
        Node node =  new Node(value,null,null);
        if(head ==null)
        {
            head = node;
        }
        else
        {
            head.previous=node;
            node.next=head;
            head = node;
        }
    }
    //delete first element
    public void delete()
    {
         if(head!=null) {
             head = head.next;
             head.previous = null;
         }
    }

    public void printElements()
    {

       Node currentNode = head;
        while(currentNode!=null)
        {
            System.out.println(currentNode.value+"\t");
            currentNode=currentNode.next;
        }

    }

    public static void main(String args[])
    {


        DoubleLinkedList<String> stringLinkedList= new DoubleLinkedList<>();
        stringLinkedList.addElement("one");
        stringLinkedList.addElement("two");
        stringLinkedList.addElement("three");
        stringLinkedList.addElement("four" );
        stringLinkedList.printElements();
        stringLinkedList.delete();
        System.out.println("After head is removed");
        stringLinkedList.printElements();
    }
}

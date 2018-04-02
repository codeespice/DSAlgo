package com.g.prepare.datastructure;

public class LinkedList<T> {

    Node head;

    public LinkedList()
    {
      head=null;
    }
    class Node<T>{
        T value;
        Node next;

        public Node(T value)
        {
            this.value=value;
            this.next=null;
        }
    }

    public void addElement(T value)
    {

        //add element always at the start
        if(head==null)
        {
            head=new Node(value);;
        }
        else
        {
            Node currentNode = new Node(value);
            currentNode.next=head;
            head=currentNode;
        }
       /*
        // add element at the end
        if(head==null)
        {
            head = new Node(value);

        }
        else
        {
            Node currentNode = head;
            while(currentNode.next!=null)
            {
                currentNode=currentNode.next;
            }
            currentNode.next=new Node(value);
        }*/
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
    public void delete()
    {
        if(head!=null) {
            head = head.next;
        }
    }

    public static void main(String args[])
    {
      /*  LinkedList<Integer> linkedList= new LinkedList<>();
        linkedList.addElement(2);
        linkedList.addElement(3);
        linkedList.addElement(4);
        linkedList.addElement(8 );
        linkedList.printElements();*/

        LinkedList<String> stringLinkedList= new LinkedList<>();
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

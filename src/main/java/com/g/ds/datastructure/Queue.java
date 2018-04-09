package com.g.ds.datastructure;

public class Queue<T> {

    Node front;

    public Queue()
    {

    }
    static class Node<T>{
        T value;
        Node next;

        public Node(T value)
        {
            this.value=value;
            this.next=null;
        }
    }

    public void enQueue(T value)
    {

        //add element always at the start
        if(front==null)
        {
            front=new Node(value);
        }
        else
        {
            Node currentNode = new Node(value);
            currentNode.next=front;
            front=currentNode;
        }

    }


    public T deQueue()
    {

        if(front==null) {
            System.out.println("Queue is empty");
            return null;
        }
        Node currentNode = front;
        Node previousNode = null;
        //look for the last element
        while(currentNode.next!=null)
        {
            previousNode =currentNode;
            currentNode=currentNode.next;
        }
        T value = (T) currentNode.value;
        /*if there is only one element remove the element and set to null
        if there are more elements set the previous element next reference to null since
        we are removing the elemnts
        */
        if(previousNode!=null)
        {
            previousNode.next=null;
        }
        else
        {
            front=null;
        }
        return value;


    }


    public static void main(String[] args){
        Queue<Integer> queue = new Queue<>();
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());


    }
}

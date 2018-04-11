package com.g.ds.datastructure;

public class Queue<T> {

    Node front;
    Node rear;

    public Queue()
    {

    }
    static class Node<T>{
        T value;
        Node next;
        Node previous;

        public Node(T value)
        {
            this.value=value;
            this.next=null;
            this.previous=null;
        }
    }
//add at the end of the quque
    public void enQueue(T value)
    {
        Node newNode=new Node(value);
        //add element always at the start
        if(front==null)
        {

            front=newNode;
            rear=newNode;
        }
        else
        {
            //adding at rear  and move the rear to current element

            newNode.previous=rear;
            rear.next = newNode;
            rear=newNode;
        }

    }


    public T deQueue()
    {
        //look if quque is empty
        if(front==null || rear==null) {
            System.out.println("Queue is empty");
            return null;
        }
        //if not empty remove the element from front
        T value =(T)front.value;
        front = front.next;
        //if reached end check for null
        if(front!=null) {

            front.previous = null;
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

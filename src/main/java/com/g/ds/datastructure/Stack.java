package com.g.ds.datastructure;

public class Stack<T> {

    Node top;

    public Stack()
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

    public void push(T value)
    {

        //add element always at the start
        if(top==null)
        {
            top=new Node(value);
        }
        else
        {
           Node currentNode = new Node(value);
            currentNode.next=top;
            top=currentNode;
        }

    }


    public T pop()
    {
        if(top==null) {
            System.out.println("Stack is empty");
           return null;
        }
        T value = (T)top.value;
        top = top.next;
        return value;


    }

    public static void main(String[] args)
    {
        Stack<Integer> myStack = new Stack<>();
        myStack.push(10);
        myStack.push(12);
        myStack.push(13);
        myStack.push(14);

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());


    }
}

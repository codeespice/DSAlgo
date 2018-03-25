package com.g.prepare.tree;

public class MyBinaryTreeTest {
    public static void main(String args[])
    {
        MyBinaryTree myTree = new MyBinaryTree();
        myTree.insert(2);
        myTree.insert(3);
        myTree.insert(5);
        myTree.insert(4);
        myTree.inorderTraversal();
        //myTree.postorderTraversal();
        System.out.println("Contains Element::"+myTree.containsElement(0));
    }



}

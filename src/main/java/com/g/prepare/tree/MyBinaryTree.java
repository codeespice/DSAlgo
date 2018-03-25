package com.g.prepare.tree;



public class MyBinaryTree {
  private Node root ;

  public Node insert(int element)
  {
      if(root ==null)
      {
          root = new Node(element);
      }
      else
      {
        insert(root,element);
      }
      return root;
  }

  private Node insert(Node current ,int element)
  {
      if(current==null)
      {
         current = new Node(element);
      }
      else
      {
         if(current.element>element)
         {
             current.leftNode=insert(current.leftNode,element);
         }
         else if (current.element<element)
         {
             current.rightNode =insert(current.rightNode,element);
         }
         
      }
      return current;
  }


  public boolean containsElement(int element)
  {
    return containsElement(root,element);
  }
  private boolean containsElement(Node currentNode,int element)
  {
      if(currentNode==null)
      {
          return false;
      }
      if(currentNode.element==element)
      {
          return true;
      }
      else if (currentNode.element>element){
         return  containsElement(currentNode.leftNode, element);
      }
      else
      {
          return containsElement(currentNode.rightNode, element);
      }
  }
  public void inorderTraversal()
  {
      inorderTraversal(root);
  }
    public void preorderTraversal()
    {
        preorderTraversal(root);
    }
    public void postorderTraversal()
    {
        postorderTraversal(root);
    }
   private void inorderTraversal(Node currentNode)
   {
       if(currentNode==null)
       {
        return ;
       }
       inorderTraversal(currentNode.leftNode);
       System.out.println(currentNode.element);
       inorderTraversal(currentNode.rightNode);
   }
    private void preorderTraversal(Node currentNode)
    {
        if(currentNode==null)
        {
            return ;
        }

        System.out.println(currentNode.element);
        inorderTraversal(currentNode.leftNode);
        inorderTraversal(currentNode.rightNode);
    }
    private void postorderTraversal(Node currentNode)
    {
        if(currentNode==null)
        {
            return ;
        }
        inorderTraversal(currentNode.leftNode);
        inorderTraversal(currentNode.rightNode);
        System.out.println(currentNode.element);



    }

}

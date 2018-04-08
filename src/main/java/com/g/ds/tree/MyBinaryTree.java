package com.g.ds.tree;



public class MyBinaryTree {
  public Node root ;

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
/*
On each iteration lower and upper bounds of current subtree can be stored.
If we want to check subtree with root x, and bounds for the subtree are l and h,
then all we need is to check that l <= x <= h and to check the left subtree with bounds l and x,
and the right one with bounds x and h.
 */
    public boolean isValidBST(Node root)
    {
        //lower bound is -infinity and upperbound is -infinity
        return isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);


    }
    public boolean isValidBST(Node node,int lowerBound,int upperBound)
    {
        if(node==null)
        {
            return true;

        }

        return (node.element>lowerBound && node.element<upperBound) &&  //check if current element is in the range of lowerbound and upperbound
                isValidBST(node.leftNode,lowerBound,node.element) && //for left tree lower bound is previous bound and uppder bound is current element
                isValidBST(node.rightNode,node.element,upperBound); //for right node lowerbound is current node value and upperbound is previous upper bound





    }

    public int heightOfBinaryTree()
    {
        if(root==null)
        {
            return 0;
        }
        return heightOfBinaryTree(root,1);
    }

    private int heightOfBinaryTree(Node currentNode,int currentHeight)
    {
        if(currentNode==null)
        {
            return currentHeight;
        }
        if(currentNode!=null)
        {

           int leftHeight = heightOfBinaryTree(currentNode.leftNode,currentHeight+1);
            int rightHeight = heightOfBinaryTree(currentNode.rightNode,currentHeight+1);
            return leftHeight>rightHeight?leftHeight:rightHeight;
        }
        return currentHeight;
    }
}

package com.g.ds.trivial;
class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        return invertNode(root);

    }

    public TreeNode invertNode(TreeNode node){
        TreeNode temp = new TreeNode();
        if(node == null){
            return node;
        }
        temp = node.left;
        node.left = invertNode(node.right) ;

        node.right = invertNode(temp);
        return node;


    }

    public TreeNode createTree(int[] inputArray){
        TreeNode root = new TreeNode(inputArray[0]);
       for(int i=1;i<inputArray.length;i++){
           insertNode(inputArray[i],root);
       }
       return root;
    }
    public TreeNode insertNode(int element, TreeNode node){

        if(node==null){

            node  = new TreeNode();
            node.val=element;
           return node;
        }
        if(element < node.val){
           node.left = insertNode(element,node.left);
        }else{
           node.right =  insertNode(element,node.right);
        }
        return node;
    }
    public void printNodes(TreeNode root){
        printNode(root);
    }
    public void printNode(TreeNode node){
        if(node == null){
            return ;
        }
        System.out.print(node.val+",");
        printNode(node.left);
        printNode(node.right);
    }

    public static void main(String args[]){

        int[] inputArray = {4,2,7,1,3,6,9 };
        InvertTree tree = new InvertTree();
        TreeNode root = tree.createTree(inputArray);
        tree.printNodes(root);
        TreeNode inverted=   tree.invertTree(root);
        System.out.println("After Inversion::");
        tree.printNodes(inverted);

    }
}

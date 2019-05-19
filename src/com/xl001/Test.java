package com.xl001;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Test {
    private static class Node{
        char value;
        Node left;
        Node right;

        Node(char v){
            this.value = v;
        }
    }

    private static Node createTree(){
        Node a= new Node('A');
        Node b= new Node('B');
        Node c= new Node('C');
        Node d= new Node('D');
        Node e= new Node('E');
        Node f= new Node('F');
        Node g= new Node('G');
        Node h= new Node('H');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.right = h;
        return a;
    }
    //当树是空树时，  node=null
    private static void preOrderTraversal(Node root){
        //根  左子树的中序   右子树的中序
        if(root!=null){
            System.out.print(root.value + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    private static void inOrderTraversal(Node root){
        //左子树的中序   根   右子树的中序
        if(root!=null){
            inOrderTraversal(root.left);
            System.out.print(root.value + " ");
            inOrderTraversal(root.right);
        }
    }
    //结点个数
    //递归思想
    private static int count(Node root){
        if(root == null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        return count(root.left) + count(root.right) + 1;
    }

    //二叉树的高度
    //递归思想
    private static int height(Node root){
//        if(root.left==null&&root.right==null){
//            return 1;
//        }
//        if(height(root.left)>height(root.right)){
//            return height(root.left)+1;
//        }else {
//            return height(root.right)+1;
//        }
        if(root==null){
            return 0;
        }else {
            int left = height(root.left);
            int right = height(root.right);
            return (left>right ? left : right)+1;
        }
        //一直都是入栈，当遇到左子树，右子树为空的情况下出栈，返回 left、right
        //只要遇到空，就会出栈，返回值
    }

    private static void postOrderTraversal(Node root){
        //左子树的后序   右子树的后序   根
        if(root!=null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.value + " ");
        }
    }

    //求第K层结点的个数
    private static int klevel(Node root, int k){
        if(root == null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return klevel(root.left, k-1)+klevel(root.right,k-1);
    }

    //返回特定结点
    private static Node search(Node root, char v){
        if(root==null){
            return null;
        }
        if(root.value==v){
            return root;
        }

        Node r = search(root.left, v);
        if(r!=null){
            return r;
        }
        r = search(root.right, v);
        if(r!=null){
            return r;
        }
        return null;
    }


    public static void main(String[] args) {
        Node root = createTree();
        preOrderTraversal(root);
        System.out.println();
        inOrderTraversal(root);
        System.out.println();
        postOrderTraversal(root);
        System.out.println();
        System.out.println("二叉树的高度"+height(root));
    }

}

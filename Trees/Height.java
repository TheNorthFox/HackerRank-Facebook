package com.afro.Trees;




//  Hackerrank question: https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem

public class Height {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static int height(Node root) {
          // Write your code here.
          
          if(root==null)
            return -1;
        else
            return 1+(height(root.left)>height(root.right)?height(root.left):height(root.right));
    }
}
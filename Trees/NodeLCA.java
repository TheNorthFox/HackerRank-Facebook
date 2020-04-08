import java.util.*;
import java.io.*;

// https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem
class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static Node lca(Node root, int v1, int v2) {
          // Write your code here.
          while (root != null) {
            if (root.data > v1 && root.data > v2) root = root.left;
            else if (root.data < v1 && root.data < v2) root = root.right;
            else break;
        }
        return root;
    }
}
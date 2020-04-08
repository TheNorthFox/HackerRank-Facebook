package com.afro.Trees;


/*
     * Complete the swapNodes function below.
     */

import java.util.LinkedList;


// https://www.hackerrank.com/challenges/swap-nodes-algo/problem

public class SwapNodes {
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */
        idx = 0;
        Node root = buildTree(indexes);
        int[][] result = new int[queries.length][];
        for (int i = 0; i < queries.length; i++) {
            //swap
            int multple = 1;
            boolean swapped = true;
            while (swapped) {
                swapped = swapNodes(root, multple * queries[i]);
                multple++;
            }
            //print
            result[i] = printNodes(root);

        }

        return result;

    }

    private static int[] printNodes(Node root) {
        LinkedList<Integer> print = new LinkedList<>();
        printNodes(root.left, print);
        print.add(root.data);
        printNodes(root.right, print);
        return print.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void printNodes(Node root, LinkedList<Integer> print) {
        if (root == null || root.data == -1) {
            return;
        }
        if (root.left.data != -1) {
            printNodes(root.left, print);
        }
        print.add(root.data);
        if (root.right.data != -1) {
            printNodes(root.right, print);
        }
    }

    private static boolean swapNodes(Node root, int query) {
        boolean swapped = false;
        if (query <= 0 || root == null) {
            return false;
        }
        if (query == 1) {
            Node tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            return true;
        }
        if (root.left != null && root.left.data != -1) {
            swapped = swapNodes(root.left, query - 1);
        }
        if (root.right != null && root.right.data != -1) {
            swapped = swapNodes(root.right, query - 1) || swapped;
        }
        return swapped;
    }

    private static int idx = 0;

    private static Node buildTree(int[][] indexes) {
        Node root = new Node(1);
        root.left = new Node(indexes[idx][0]);
        root.right = new Node(indexes[idx++][1]);

        while (idx < indexes.length) {
            if (root.left.data != -1) {
                buildSubTree(indexes, root.left);
            }
            if (root.right.data != -1) {
                buildSubTree(indexes, root.right);
            }
        }
        return root;
    }

    private static void buildSubTree(int[][] indexes, Node root) {

        if (idx == indexes.length) {
            return;
        }
        if (root.left == null && root.right == null) {
            root.left = new Node(indexes[idx][0]);
            root.right = new Node(indexes[idx][1]);
            idx++;
            return;
        }
        if (root.left != null && root.left.data != -1) {
            buildSubTree(indexes, root.left);
        }
        if (root.right != null && root.right.data != -1) {
            buildSubTree(indexes, root.right);
        }
    }


    public static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }
}
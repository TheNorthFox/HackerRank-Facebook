package com.afro.LinkedList;


// https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem

public class FindMergeNode {

	    static class SinglyLinkedListNode {
	        public int data;
	        public SinglyLinkedListNode next;

	        public SinglyLinkedListNode(int nodeData) {
	            this.data = nodeData;
	            this.next = null;
	        }
	    }

	    static class SinglyLinkedList {
	        public SinglyLinkedListNode head;
	        public SinglyLinkedListNode tail;

	        public SinglyLinkedList() {
	            this.head = null;
	            this.tail = null;
	        }

	        public void insertNode(int nodeData) {
	            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

	            if (this.head == null) {
	                this.head = node;
	            } else {
	                this.tail.next = node;
	            }

	            this.tail = node;
	        }
	    }

	  



	    // Complete the findMergeNode function below.

	    /*
	     * For your reference:
	     *
	     * SinglyLinkedListNode {
	     *     int data;
	     *     SinglyLinkedListNode next;
	     * }
	     *
	     */
	    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
	         SinglyLinkedListNode tmp = head2;
	        
	        while (head1 != null) {
	            if (head2 == null) {
	                head1 = head1.next;
	                head2 = tmp;
	            }
	            if (head1 == head2) {
	                return head1.data;
	            }
	            head2 = head2.next;
	        }
	        
	        return 0;

	    }
}


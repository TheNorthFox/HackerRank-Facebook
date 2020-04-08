import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


// https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem
public class SortedInsert {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }



    // Complete the sortedInsert function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        if(head == null){
            head = new DoublyLinkedListNode(data);
            return head;
        }

        DoublyLinkedListNode curr = head;
        while(curr != null){ //tail addition
            if(curr.data == data){
                return head;
            }

            if(data > curr.data && curr.next == null){
                curr.next = new DoublyLinkedListNode(data);
                curr.next.prev = curr;
                return head;
            }

            if(data < curr.data && curr.prev == null){ //new head
                curr.prev = new DoublyLinkedListNode(data);
                head = curr.prev;
                head.next = curr;
                return head;
            }

            if(data > curr.data && curr.next!=null && data<= curr.next.data){
                DoublyLinkedListNode node = new DoublyLinkedListNode(data);
                node.prev = curr;
                node.next = curr.next;
                curr.next.prev = node;
                curr.next = node;
                return head; // > insertion
            }

            if(data <= curr.data && curr.prev!=null && data> curr.prev.data){
                DoublyLinkedListNode node = new DoublyLinkedListNode(data);
                curr.prev.next = node;
                curr.prev = node;
                return head; // <insertion
            }

            curr = curr.next;
        }

        return head;

    }

  }
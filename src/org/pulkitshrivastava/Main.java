package org.pulkitshrivastava;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
	// write your code here
    }
    public static class LRUCache {
        int capacity;
        public static class DoublyLinkedList {
            int key;
            int value;
            DoublyLinkedList previousNode;
            DoublyLinkedList nextNode;
            public DoublyLinkedList(int key, int value) {
                this.key = key;
                this.value = value;
                this.previousNode = null;
                this.nextNode = null;
            }
        }
        HashMap<Integer, DoublyLinkedList> cache;
        public DoublyLinkedList headNode = null;
        public DoublyLinkedList tailNode = null;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>(this.capacity);
        }
        public void removeNode(DoublyLinkedList currentNode)
        {
            if ( currentNode.nextNode == null && currentNode.previousNode == null )
            {
                headNode = null;
                tailNode = null;
                return;
            }

            if ( currentNode == tailNode )
            {
                tailNode = currentNode.previousNode;
                return;
            }

            if ( headNode == currentNode )
                headNode = headNode.nextNode;
            DoublyLinkedList currentPreviousNode = currentNode.previousNode;
            DoublyLinkedList currentNextNode = currentNode.nextNode;
            currentNextNode.previousNode = currentPreviousNode;
            if (currentPreviousNode != null)
            {
                currentPreviousNode.nextNode = currentNextNode;
            }
        }
        public void insertAtLast(DoublyLinkedList currentNode)
        {
            if (headNode == null)
            {
                headNode = currentNode;
                tailNode = currentNode;
                return;
            }
            tailNode.nextNode = currentNode;
            currentNode.previousNode = tailNode;
            tailNode = currentNode;
        }
    }
}

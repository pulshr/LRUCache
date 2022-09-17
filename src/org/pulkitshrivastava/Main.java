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

    }
}

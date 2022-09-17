package org.pulkitshrivastava;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
	// write your code here
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(1,10);
        lruCache.set(5,12);
        lruCache.get(5);
        lruCache.get(1);
        lruCache.get(10);
        lruCache.set(6,14);
        lruCache.get(5);
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
        public void get(int key) {
            if ( cache.containsKey(key) )
            {
                DoublyLinkedList currentNode = cache.get(key);
                if (currentNode.nextNode != null)
                {
                    removeNode(currentNode);
                    insertAtLast(currentNode);
                }
                System.out.println(currentNode.value);
                return;
            }
            System.out.println(-1);
        }
        public void set(int key, int value) {
            if ( cache.containsKey(key) )
            {
                DoublyLinkedList updateNode = cache.get(key);
                updateNode.value = value;
                if ( updateNode.nextNode != null )
                {
                    removeNode(updateNode);
                    cache.remove(updateNode.key);
                    updateNode = new DoublyLinkedList(key, value);
                    cache.put(key, updateNode);
                    insertAtLast(updateNode);
                }
            }
            else
            {
                DoublyLinkedList newNode = new DoublyLinkedList(key, value);
                if (cache.size() == capacity)
                {
                    DoublyLinkedList deleteNode = removeHeadNode();
                    cache.remove(deleteNode.key);
                }
                cache.put(key, newNode);
                insertAtLast(newNode);
            }
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
        public DoublyLinkedList removeHeadNode()
        {
            DoublyLinkedList deleteNode = headNode;
            if (headNode.nextNode == null && headNode.previousNode == null)
            {
                headNode = null;
                tailNode = null;
            }
            else
            {
                headNode = headNode.nextNode;
            }
            return deleteNode;
        }
    }
}

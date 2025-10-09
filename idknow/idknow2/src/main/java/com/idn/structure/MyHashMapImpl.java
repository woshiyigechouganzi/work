package com.idn.structure;

import javax.management.StandardMBean;

public class MyHashMapImpl<K,V> implements MyHashMap<K,V> {
    Node<K,V>[] table = new Node[10];

    @Override
    public V put(K key, V value) {
        Node<K,V> newNode = table[IndexOf(key)];
        if (newNode == null) {
            table[IndexOf(key)] = new Node(key, value);
            return null;
        }
        while (true){
            if (newNode.key.equals(key)) {
                V oldValue = newNode.value;
                newNode.value = value;
                return oldValue;
            }
            if(newNode.next == null){
                newNode.next = new Node<>(key, value);
                return null;
            }
              newNode = newNode.next;
        }
    }

    @Override
    public V get(K key) {
        Node<K,V> theNode = table[IndexOf(key)];
        while (theNode != null) {
            if (theNode.key.equals(key)) {
                return theNode.value;
            }
            theNode = theNode.next;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        Node<K,V> theNode = table[IndexOf(key)];
        if (theNode == null) {
            return null;
        }
        if(theNode.key.equals(key)){
            table[IndexOf(key)] = theNode.next;
            return theNode.value;
        }
        Node<K,V> head = theNode;
        Node<K,V> next = theNode.next;
        while (next != null) {
            if (next.key.equals(key)) {
                head.next = next.next;
                return next.value;
            }
            head = head.next;
            next = next.next;
        }
        return null;
    }

    class Node<K,V>{
        Node<K,V> next;
        K key;
        V value;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int IndexOf(K key){
        return key.hashCode()%10;
    }
}

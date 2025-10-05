package com.idn.structure;

public class MyHashMapImpl<K,V> implements MyHashMap<K,V> {
    MyArrayList<Node<K,V>> table = new MyArrayListImpl<>();//这里用的是我自己的arraylist因为再写一个自增数组太麻烦了反正都是自己写的也不算违规吧应该

    @Override
    public V put(K key, V value) {
        for(int i =0 ;i<table.size();i++) {
            if(table.get(i).key.equals(key)) {
                V oldValue = table.get(i).value;
                table.get(i).value = value;
                return oldValue;
            }
        }
        table.add(new Node<K,V>(key,value));
        return null;
    }

    @Override
    public V get(K key) {
        for(int i =0 ;i<table.size();i++) {
            if(table.get(i).key.equals(key)) {
                V theValue = table.get(i).value;
                return theValue;
            }
        }return null;
    }

    @Override
    public V remove(K key) {
        for(int i =0 ;i<table.size();i++) {
            if(table.get(i).key.equals(key)) {
                V theValue = table.get(i).value;
                table.remove(i);
                return theValue;
            }
        }return null;

    }

    class Node<K,V>{
        K key;
        V value;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

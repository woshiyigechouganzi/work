package com.idn.structure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyLinkedListImpl<E> implements MyLinkedList<E> {
    private int size = 0;

    Node<E> head;
    Node<E> tail;
    @Override
    public void add(E e) {
        Node<E> node = new Node<>(e,tail,null);
        if(tail != null){
            tail.next = node;
        }else {
            head = node;
        }
        tail = node;
        size++;
    }

    @Override
    public void add(int index, E e) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(index == size){
            add(e);
        }
        Node<E> indexNode = findByIndex(index);
        Node<E> newNode = new Node<>(e,indexNode.pre,indexNode);
        if(indexNode.pre == null){
            head = newNode;
        }else {
            indexNode.pre.next = newNode;
        }
        indexNode.pre = newNode;
        size++;
    }

    private Node<E> findByIndex(int index) {
        Node<E> result = head;
        for(int i = 0; i < index; i++){
            result = result.next;
        }
        return result;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node<E> indexNode = findByIndex(index);
        delete(indexNode);
        return indexNode.e;
    }

    @Override
    public boolean remove(E o) {
        Node<E> node = head;
        while(node != null){
            if(Objects.equals(node.e,o)){
                delete(node);
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public E get(int index) {
        return (E)findByIndex(index);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {

        return new LinkedListIterator();
    }

    private E delete(Node<E> node) {
        final E element = node.e;
        final Node<E> prev = node.pre;
        final Node<E> next = node.next;
        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            node.pre = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.pre = prev;
            node.next = null;
        }
        node.e = null;
        size--;
        return element;
    }

    class LinkedListIterator implements Iterator<E> {
        Node<E> current = head;
        private Node<E> lastReturned = null;
        private int nextIndex = 0;

        @Override
        public boolean hasNext() {
            return current != null;
        }


        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = current; // 记录最后返回的节点
            E result = current.e;
            current = current.next;
            nextIndex++;
            return result;
        }

        @Override
        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException("请先选定对象再删除");
            }

            Node<E> lastNext = lastReturned.next;
            delete(lastReturned);//这个地方
            nextIndex--;
        }
    }

    class Node<E>{
        Node<E> pre;
        Node<E> next;
        E e;
        public Node(MyLinkedListImpl<E>.Node<E> tail, E e1, E e) {
            this.e = e;
        }
        public Node(E e, Node<E> pre, Node<E> next) {
            this.e = e;
            this.pre = pre;
            this.next = next;
        }
    }
}

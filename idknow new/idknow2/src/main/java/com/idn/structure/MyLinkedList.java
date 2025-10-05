package com.idn.structure;

public interface MyLinkedList<E> extends Iterable<E> {
    void add(E e);
    void add(int index, E e);
    E remove(int index);
    boolean remove(E e);
    E get(int index);
    int size();
}

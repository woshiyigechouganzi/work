package com.idn.structure;

import java.util.ArrayList;

public interface MyArrayList<E> {
    void add(E e);
    void add(int index, E e);
    E remove(int index);
    boolean remove(E e);
    E get(int index);
    int size();
}

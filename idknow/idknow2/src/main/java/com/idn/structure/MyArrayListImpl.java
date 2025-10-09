package com.idn.structure;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class MyArrayListImpl<E> implements MyArrayList<E> {
    private Object[] volume = new Object[10];

    private int size = 0;

    @Override
    public void add(E e) {
        if (size == volume.length) {
            scaleOut();
        }
        volume[size] = e;
        size++;
    }

    private void scaleOut(){
        Object[] newVolume = new Object[volume.length * 2];
        System.arraycopy(volume, 0, newVolume, 0, volume.length);
        volume = newVolume;
    }
    @Override
    public void add(int index, E e) {
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException();
        }
        if (size == volume.length) {
            scaleOut();
        }
        System.arraycopy(volume, index, volume, index+1, size - index);
        volume[index] = e;
        size++;
    }

    @Override
    public E remove(int index) {
        if (index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        E e = (E)volume[index];
        System.arraycopy(volume,index+1,volume,index,size-index-1);
        size--;
        volume[size] = null;//删除最顶端的元素
        return e;
    }

    @Override
    public boolean remove(E e) {
        for (int i = 0; i < size; i++) {
            if(Objects.equals(volume[i],e)){
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        E e = (E)volume[index];
        return e;
    }

    public int size(){
        return this.size;
    }


}

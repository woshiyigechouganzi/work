package com.idn.map;

import com.idn.structure.MyArrayList;
import com.idn.structure.MyArrayListImpl;
import com.idn.structure.MyLinkedList;
import com.idn.structure.MyLinkedListImpl;
import com.idn.util.Person;

import java.util.Iterator;

public class MyTreeByLinkedList implements MyTree {
    MyLinkedList<Person> list = new MyLinkedListImpl<>();
    MyArrayList<Person> list2 = new MyArrayListImpl<>();

    @Override
    public MyArrayList<Person> rangeQuery(Integer minId, Integer maxId) {
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()){
            Person person = iterator.next();
            if(person.getId()>minId && person.getId()<maxId){
                list2.add(person);
            }
        }
        return list2;
    }

    @Override
    public int put(Person p, int id) {
        return 0;
    }

    @Override
    public Person get(int id) {
        return null;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}

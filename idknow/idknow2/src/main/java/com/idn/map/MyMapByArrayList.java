package com.idn.map;

import com.idn.structure.MyArrayList;
import com.idn.structure.MyArrayListImpl;
import com.idn.util.Person;

import java.util.ArrayList;
import java.util.List;

public class MyMapByArrayList implements MyMap {
    private MyArrayList<Person> persons = new MyArrayListImpl<>();

    @Override
    public Person get(int id) {
        if (id < 0 || id >= persons.size()) {
            return null;
        }
        Person p = persons.get(id);
        return p;
    }

    @Override
    public int put(Person p, int id) {
        while (persons.size() <= id) {
            persons.add(null);
        }
        persons.add(id , p);
        return 1;

    }

    @Override
    public int delete(int id) {
        if (id >= 0 && id < persons.size()) {
            Person p = get(id);
            persons.remove(p);
            return 1;
        }return 0;
    }
}

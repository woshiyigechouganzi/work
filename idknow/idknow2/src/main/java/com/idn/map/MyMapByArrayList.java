package com.idn.map;

import com.idn.util.Person;

import java.util.ArrayList;
import java.util.List;

public class MyMapByArrayList implements MyMap {
    private List<Person> persons = new ArrayList<Person>();


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

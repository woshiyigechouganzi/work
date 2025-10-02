package com.idn.map;

import com.idn.util.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyTreeByLinkedList implements MyTree {
    List<Person> list = new LinkedList<Person>();

    @Override
    public List<Person> rangeQuery(Integer minId, Integer maxId) {
        List<Person> persons = new ArrayList<Person>();
        for(Person p : list) {
            if(p.getId()>=minId && p.getId()<=maxId) {
                persons.add(p);
            }
        }
        return persons;
    }

    @Override
    public Person get(int id) {
        for (Person p : list) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public int put(Person p, int id) {
        delete(id);
        list.add(p);
        return 1;
    }

    @Override
    public int delete(int id) {
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            Person p = iterator.next();
            if (p.getId() == id) {
                iterator.remove();
                return 1;
            }
        }
        return 0;
    }
}

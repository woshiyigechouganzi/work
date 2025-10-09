package com.idn.map;

import com.idn.util.Person;

import java.util.HashMap;
import java.util.Map;

public class MyIndexByHashMap {
    private final MyIndex<Integer, Person> idIndex;

    private final MyIndex<String, Person> NameIndex;

    public MyIndexByHashMap() {
        this.idIndex = new HashMapIndex<Integer,Person>();
        this.NameIndex = new HashMapIndex<String,Person>();
    }

    public void addPersonByName(Person person) {
        NameIndex.put(person.getName(), person);
    }

    public void addPersonById(Person person) {
        idIndex.put(person.getId(), person);
    }
    // TODO: 根据ID查询
    public Person getPersonById(Integer id) {
        return idIndex.get(id);
    }

    // TODO: 根据姓氏查询
    public Person getPersonByLastName(String lastName) {
        return NameIndex.get(lastName);
    }

}

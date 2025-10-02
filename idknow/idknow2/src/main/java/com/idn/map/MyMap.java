package com.idn.map;

import com.idn.util.Person;

public interface MyMap {
    int put(Person p, int id);
    Person get(int id);
    int delete(int id);
}

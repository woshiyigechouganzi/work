package com.idn.map;

import com.idn.structure.MyHashMap;
import com.idn.structure.MyHashMapImpl;
import com.idn.util.Person;

import java.util.HashMap;
import java.util.Map;

public class MyMapByHashMap implements MyMap {
    private MyHashMap<Integer, Person> map = new MyHashMapImpl<>();

    @Override
    public Person get(int id) {
        Person p = map.get(id);
        return p;
    }

    @Override
    public int put(Person p, int id) {
        Person p2 = get(id);
        if(p2 == null){
            map.put(id,p);
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public int delete(int id) {
        Person p2 = get(id);
        if(p2 != null){
            map.remove(id);
            return 1;
        }else {
            return 0;
        }
    }
}

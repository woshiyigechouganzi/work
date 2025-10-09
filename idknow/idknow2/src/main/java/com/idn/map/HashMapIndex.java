package com.idn.map;

import com.idn.structure.MyHashMap;
import com.idn.structure.MyHashMapImpl;
import com.idn.util.Person;

import java.util.HashMap;
import java.util.Map;

public class HashMapIndex<K,M> implements MyIndex<K,M> {
    MyHashMap<K,M> map = new MyHashMapImpl<>();

    @Override
    public void put(K key, M value) {
        map.put(key, value);
    }

    @Override
    public M get(K key) {
        M p = map.get(key);
        return p;
    }
}

package com.idn.map;

import com.idn.util.Person;

import java.util.HashMap;
import java.util.Map;

public class HashMapIndex<K,M> implements MyIndex<K,M> {
    HashMap<K,M> map = new HashMap<>();

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

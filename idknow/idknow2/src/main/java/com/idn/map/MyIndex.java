package com.idn.map;

public interface MyIndex <K,M>{
    void put(K key, M value);
    M get(K key);
}

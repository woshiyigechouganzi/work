package com.idn.map;

import com.idn.util.Person;

import java.util.List;

public interface MyTree extends MyMap{

    List<Person> rangeQuery(Integer minId, Integer maxId);

}


package com.idn.map;

import com.idn.structure.MyArrayList;
import com.idn.util.Person;

public interface MyTree extends MyMap{

    MyArrayList<Person> rangeQuery(Integer minId, Integer maxId);

}


package com.idn.util;

public class Person {
    private int age;
    private String name;
    private int id;
    private String gender;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Person(int age, String name, int id, String gender) {
        this.age = age;
        this.name = name;
        this.id = id;
        this.gender = gender;
    }
}

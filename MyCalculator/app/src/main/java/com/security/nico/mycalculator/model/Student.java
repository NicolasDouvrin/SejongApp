package com.security.nico.mycalculator.model;

import java.io.Serializable;

public class Student implements Serializable {
    private String name, email, age, nat, major;
    private int mood;

    public Student(String name, String email, String age, String nat, String major, int mood) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.nat = nat;
        this.major = major;
        this.mood = mood;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }
}
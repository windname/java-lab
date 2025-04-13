package com.vg.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String name;
    private int age;
    private boolean admin;
    private int id;

    public User(String name, boolean admin, int age) {
        this.name = name;
        this.age = age;
        this.admin = admin;
    }
}

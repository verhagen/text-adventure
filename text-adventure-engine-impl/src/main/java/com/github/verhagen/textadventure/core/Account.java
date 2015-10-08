package com.github.verhagen.textadventure.core;

public class Account {
    private final String name;
    private final String email;


    public Account(final String name, final String email) {
        this.name = name;
        this.email = email;
    }


    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }

}

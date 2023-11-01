package com.example.onlight_project;

public class User {
    private String name;
    private String identifier_card;

    public User(String name,String identifier_card){
        this.name = name;
        this.identifier_card = identifier_card;
    }

    public String getName() {
        return name;
    }

    public String getIdentifier_card() {
        return identifier_card;
    }

}

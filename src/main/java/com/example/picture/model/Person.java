package com.example.picture.model;

import java.util.Objects;

public record Person(String name, String password) {
    public Person {
        Objects.requireNonNull(name);
        Objects.requireNonNull(password);
    }
}
package com.juampicrud.my_crud.model;

public class Book {

    public final long id;

    public String name;

    public Book(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

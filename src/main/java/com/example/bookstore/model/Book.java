package com.example.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Book {
    private int id;
    private String title;
    private String isbn;
    private double price;
}

//The Book domain model which attributes: Id(int), title(string), isbn(string), price(double).

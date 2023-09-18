package de.VBKA.backend.entity;

import lombok.Data;

import java.util.List;


@Data
public class Category {

    private int id;
    private String name;
    private List<String> stringPatterns;
    private List<Category> subCategories;

    public Category(int id) {
        this.id = id;
    }

}

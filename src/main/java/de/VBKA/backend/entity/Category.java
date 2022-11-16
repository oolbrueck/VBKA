package de.VBKA.backend.entity;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Category {

    private UUID id;
    private String name;
    private List<String> stringPatterns;
    private List<Category> subCategories;

}

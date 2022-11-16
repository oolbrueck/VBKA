package de.VBKA.backend.entity;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class BankAccount {

    private UUID id;
    private List<Category> categories;

}

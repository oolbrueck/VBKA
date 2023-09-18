package de.VBKA.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;


@Data
public class BankAccount {

    @NonNull
    private String iban;
    private List<Category> categories;

    public BankAccount(String iban) {
        this.iban = iban;
    }

}

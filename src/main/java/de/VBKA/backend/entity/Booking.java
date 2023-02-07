package de.VBKA.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    private UUID id;
    private LocalDate bookedDate;
    private String bookedText;
    private Double amount;
    private List<Category> categories;
    private BankAccount bankAccount;

}

package de.VBKA.backend.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class Booking {

    private UUID id;
    private LocalDate bookedDate;
    private String bookedText;
    private Double amount;
    private List<Category> categories;
    private UUID bankAccount;

}

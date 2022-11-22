package de.VBKA.backend.controller;

import de.VBKA.backend.entity.BankAccount;
import de.VBKA.backend.entity.Booking;

public class ApplyCategorizationController {

    public void categorize(Booking booking) {
        booking.getBankAccount().getCategories().stream().forEach(category -> category.getStringPatterns().stream().forEach(
                stringPattern -> {
                    if(booking.getBookedText().contains(stringPattern)) {
                        booking.getCategories().add(category);
                    }
                }
        ));
    }
}

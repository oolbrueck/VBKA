package de.VBKA.backend.controller.bankStatementParser;

import de.VBKA.backend.entity.BankAccount;
import de.VBKA.backend.entity.Booking;

import java.io.File;
import java.io.IOException;
import java.util.List;

abstract class BookingParser {

    protected List<Booking> bookings;
    protected BankAccount bankAccount;

    public BookingParser() {}
    public BookingParser(List<Booking> bookings, BankAccount bankAccount) {
        this.bookings = bookings;
        this.bankAccount = bankAccount;
    }

    abstract List<String> getAllIbans();

    abstract List<String> getBookings();
}

package de.VBKA.backend.controller.bankStatementParser;

import de.VBKA.backend.entity.BankAccount;
import de.VBKA.backend.entity.Booking;

import java.util.List;

public abstract class BookingParser {

    protected List<Booking> bookings;
    protected BankAccount bankAccount;

    public BookingParser() {}
    public BookingParser(List<Booking> bookings, BankAccount bankAccount) {
        this.bookings = bookings;
        this.bankAccount = bankAccount;
    }

    public abstract List<Booking> getBookings();
}

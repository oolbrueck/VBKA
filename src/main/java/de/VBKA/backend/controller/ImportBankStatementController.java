package de.VBKA.backend.controller;

import de.VBKA.backend.controller.bankStatementParser.bookingParserImpl.VolksbankParser;
import de.VBKA.backend.entity.Booking;
import de.VBKA.backend.dao.BookingDAO;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ImportBankStatementController {

    public int importBankStatement(File file) {
        List<Booking> bookings = getBookings(file);
        bookings.forEach(this::makeBookingComplete);

        BookingDAO bookingDAO = new BookingDAO();
        bookings.forEach(bookingDAO::createBooking);
        return 0;
    }

    private void makeBookingComplete(Booking booking) {
        booking.setBankAccount(new SessionController().getCurrentBankAccount());
        new ApplyCategorizationController().categorize(booking);
    }

    private List<Booking> getBookings(File file) {
        List<Booking> result;
        try {
            result = new VolksbankParser().parseBookings(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}

package de.VBKA.backend.controller;

import de.VBKA.backend.entity.BankAccount;
import de.VBKA.backend.entity.Booking;
import de.VBKA.backend.entity.Category;
import de.VBKA.database.dao.BookingDAO;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ImportBankStatementController {

    public int importBankStatement(File file) {
        List<String> bookingsAsString = getBookingsAsString(file);
        List<Booking> listOfBookings = bookingsAsString.stream()
                                                       .map(this::stringBookingToObjectBooking)
                                                       .toList();
        BookingDAO bookingDAO = new BookingDAO();
        listOfBookings.stream().forEach(booking -> bookingDAO.createBooking(booking));
        return 0;
    }

    private Booking stringBookingToObjectBooking(String bookingAsString) {
        Booking booking = new Booking();
        booking.setAmount(new BookingParseController().parseAmount(bookingAsString));
        booking.setBankAccount(new SessionController().getCurrentBankAccount());
        booking.setBookedText(bookingAsString);
        new ApplyCategorizationController()
                .categorize(booking);
        return booking;
    }

    private List<String> getBookingsAsString(File file) {
        List<String> result;
        try {
            result = new BookingParseController().parseBookings(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}

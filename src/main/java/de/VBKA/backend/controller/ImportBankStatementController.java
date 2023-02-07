package de.VBKA.backend.controller;

import de.VBKA.backend.controller.bankStatementParser.bookingParserImpl.VolksbankParser;
import de.VBKA.backend.entity.Booking;
import de.VBKA.backend.dao.BookingDAO;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
        booking.setAmount(new VolksbankParser().parseAmount(bookingAsString));
        booking.setBankAccount(new SessionController().getCurrentBankAccount());
        booking.setBookedText(bookingAsString);
        new ApplyCategorizationController()
                .categorize(booking);
        return booking;
    }

    private List<String> getBookingsAsString(File file) {
        List<String> result;
        try {
            result = new VolksbankParser().parseBookings(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}

package de.VBKA.backend.controller;

import de.VBKA.backend.controller.bankStatementParser.bookingParserImpl.pdfParser.VolksbankPdfParser;
import de.VBKA.backend.controller.bankStatementParser.csvParser.VolksbankCSVParser;
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
        var parser = new VolksbankCSVParser(file);
        return parser.getBookings();
    }
}

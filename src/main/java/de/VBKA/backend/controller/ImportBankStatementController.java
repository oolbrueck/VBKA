package de.VBKA.backend.controller;

import de.VBKA.backend.controller.bankStatementParser.csvParser.VolksbankCSVParser;
import de.VBKA.backend.dao.BookingDAO;

import java.io.File;

public class ImportBankStatementController {

    public int importBankStatement(File file) {
        var parser = new VolksbankCSVParser(file);
        //parser.getIbanThatBelongsToBankStatement(); //TODO check if this iban is registered, if not: Don't sve bookings and notify user

        var bookings = parser.getBookings();
        System.out.println("bookings: " + bookings);
        var categorizationController = new ApplyCategorizationController();
        bookings.forEach(categorizationController::categorize);


        //BookingDAO bookingDAO = new BookingDAO();
        //bookings.forEach(bookingDAO::createBooking);
        return 0;
    }
}

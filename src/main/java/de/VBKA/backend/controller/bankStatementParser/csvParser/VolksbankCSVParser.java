package de.VBKA.backend.controller.bankStatementParser.csvParser;

import de.VBKA.Utils;
import de.VBKA.backend.controller.bankStatementParser.BookingParser;
import de.VBKA.backend.entity.BankAccount;
import de.VBKA.backend.entity.Booking;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class VolksbankCSVParser extends BookingParser {

    public VolksbankCSVParser(File file) {
        super();
        List<Booking> bookings = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            boolean headerIgnored = false;
            while (scanner.hasNextLine()) {
                if(!headerIgnored) {
                    headerIgnored = true;
                } else {
                    List<String> bookingInformation = getRecordFromLine(scanner.nextLine());
                    Booking booking = new Booking();
                    booking.setBankAccount(new BankAccount(bookingInformation.get(1)));
                    booking.setBookedDate(Utils.ddMmYyyyToLocalDate(bookingInformation.get(4)));
                    booking.setPaymentParty(bookingInformation.get(6));
                    booking.setBankAccountPaymentParty(new BankAccount(bookingInformation.get(7)));
                    booking.setBookingType(bookingInformation.get(9));
                    booking.setPurposeOfUse(bookingInformation.get(10));
                    booking.setAmountInCents(Utils.amountStringToCent(bookingInformation.get(11)));
                    booking.setBalanceAfterBooking(Utils.amountStringToCent(bookingInformation.get(13)));
                    bookings.add(booking);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BankAccount orderAccount = bookings.isEmpty() ? null : bookings.get(0).getBankAccount();
        this.bookings = bookings;
        this.bankAccount = orderAccount;
    }

    public List<Booking> getBookings() {
        return this.getBookings().isEmpty() ? new ArrayList<>() : this.getBookings();
    }


    public BankAccount getIbanThatBelongsToBankStatement() {
        return this.bankAccount;
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(";");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }


}

package de.VBKA.backend.controller.bankStatementParser;

import de.VBKA.backend.entity.Booking;

import java.io.File;
import java.util.List;

public interface BookingParser {
    public List<Booking> parseBookings(File file);
}

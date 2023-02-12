package de.VBKA.backend.controller.bankStatementParser.csvParser;

import de.VBKA.backend.controller.bankStatementParser.BookingParser;
import de.VBKA.backend.entity.Booking;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VolksbankCSVParser implements BookingParser {
    @Override
    public List<Booking> parseBookings(File file) throws IOException {

        List<List<String>> records = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        records.forEach(r -> System.out.println(r));

        return new ArrayList<>();
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

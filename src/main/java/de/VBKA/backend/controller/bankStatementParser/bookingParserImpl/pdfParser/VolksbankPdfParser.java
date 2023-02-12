package de.VBKA.backend.controller.bankStatementParser.bookingParserImpl.pdfParser;

import de.VBKA.backend.controller.bankStatementParser.BookingParser;
import de.VBKA.backend.entity.Booking;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class VolksbankPdfParser implements BookingParser {

    String fileName = "C:/Users/oligo/Desktop/2408043010_2022_Nr.010_Kontoauszug_vom_31.10.2022_20221111203727.pdf";

    public List<Booking> parseBookings(File file) throws IOException {
        //File f = new File(fileName);
        String parsedText;
        PDFParser parser = new PDFParser(new RandomAccessFile(file, "r"));
        parser.parse();

        COSDocument cosDoc = parser.getDocument();
        PDFTextStripper pdfStripper = new PDFTextStripper();
        pdfStripper.setSortByPosition(true);
        PDDocument pdDoc = new PDDocument(cosDoc);
        parsedText = pdfStripper.getText(pdDoc);

        //TODO pdf doc closen siehe Warnung

        var listOfIndices = new ArrayList<Integer>();
        System.out.println(parsedText);

        parsedText = parsedText.replaceAll("                                            Übertrag auf Blatt", "00.00. 00.00. ")
                .replaceAll("                                    neuer Kontostand vom", "00.00. 00.00. ");
        String pat = "(\\d\\d\\.\\d\\d\\. \\d\\d\\.\\d\\d\\. )";
        Pattern pattern = Pattern.compile(pat);
        Matcher matcher = pattern.matcher(parsedText);
        while (matcher.find()) {
            listOfIndices.add(matcher.start());
        }
        var listOfParsedBookings = new ArrayList<String>();
        for (int i = 0; i < listOfIndices.size(); i++) {
            if (parsedText.substring(listOfIndices.get(i), listOfIndices.get(i) + 14).equals("00.00. 00.00. ")) {
                continue;
            }
            listOfParsedBookings.add(parsedText.substring(listOfIndices.get(i), listOfIndices.get(i + 1)));
        }
        int year = 2022;

        return listOfParsedBookings.stream().map(bookingAsString ->
                new Booking(null, parseBookingDate(bookingAsString, year), bookingAsString, parseAmount(bookingAsString), null, null))
                .collect(Collectors.toList()); //TODO
    }

    private int parseAmount(String parsedBooking) {

        var stringFragments = parsedBooking.split("\\R")[0].split("             ");
        var amountAsString = stringFragments[stringFragments.length - 1]
                                    .trim().replaceAll("\\.", "").replaceAll(",", ".");
        var amountAsDouble = amountAsString.contains("S") ?
                                    -1 * Double.parseDouble(amountAsString.substring(0, amountAsString.length() - 2)) :
                                    Double.parseDouble(amountAsString.substring(0, amountAsString.length() - 2));
        return (int)((amountAsDouble - (int)amountAsDouble) * 100) + ((int)amountAsDouble) * 100;
    }

    private LocalDate parseBookingDate(String parsedBooking, int year) {
        System.out.println(parsedBooking);
        return LocalDate.of(2022, 1, 1); //TODO
    }
}

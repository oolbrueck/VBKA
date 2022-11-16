package de.VBKA.backend.controller;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookingParseController {

    String fileName = "C:/Users/oligo/Desktop/2408043010_2022_Nr.010_Kontoauszug_vom_31.10.2022_20221111203727.pdf";

    public List<String> parseBookings() throws IOException {
        File f = new File(fileName);
        String parsedText;
        PDFParser parser = new PDFParser(new RandomAccessFile(f, "r"));
        parser.parse();

        COSDocument cosDoc = parser.getDocument();
        PDFTextStripper pdfStripper = new PDFTextStripper();
        PDDocument pdDoc = new PDDocument(cosDoc);
        parsedText = pdfStripper.getText(pdDoc);

        //TODO pdf doc closen siehe Warnung

        var listOfIndices = new ArrayList<Integer>();

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
//        System.out.println(listOfParsedBookings.toString());
//        System.out.println(listOfParsedBookings.size());
//        System.out.println(listOfParsedBookings.stream().map(s -> s.substring(50, 90).replaceAll("S", "")
//                        .trim().replaceAll(",", ".")).filter(s -> !s.equals(""))
//                .map(Double::parseDouble).reduce(0.0, (a, b) -> a + b));

        return listOfParsedBookings;
    }

    public Double parseAmount(String parsedBooking) {

        var stringFragments = parsedBooking.split("\\R")[0].split("             ");
        var amountAsString = stringFragments[stringFragments.length - 1]
                                    .trim().replaceAll("\\.", "").replaceAll(",", ".");
        var amountAsDouble = amountAsString.contains("S") ?
                                    -1 * Double.parseDouble(amountAsString.substring(0, amountAsString.length() - 2)) :
                                    Double.parseDouble(amountAsString.substring(0, amountAsString.length() - 2));
        System.out.println(amountAsString);
        System.out.println(amountAsDouble);
        return 0.0;

    }
}

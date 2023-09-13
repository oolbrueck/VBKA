/**
 * Author: Oliver Olbrück
 */

package de.VBKA;

import java.lang.reflect.Array;
import java.time.LocalDate;

public class Utils {

    public static LocalDate ddMmYyyyToLocalDate(String date) {
        int day, month, year = 0;
        day = Integer.parseInt(date.substring(0, 2));
        month = Integer.parseInt(date.substring(3, 5));
        year = Integer.parseInt(date.substring(6, 10));
        return LocalDate.of(year, month, day);
    }

    public static int amountStringToCent(String amount) {
        var amountParts = amount.split(",");
        int sum = Integer.parseInt(amountParts[0]) * 100;
        return amountParts.length == 2 ? sum + Integer.parseInt(amountParts[1]) : sum;
    }
}

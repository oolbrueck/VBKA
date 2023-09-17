package de.VBKA.backend.controller;

import de.VBKA.backend.dao.UserDAO;
import de.VBKA.backend.entity.Booking;
import de.VBKA.database.jooq.tables.records.CategoryRecord;

import java.util.List;

public class ApplyCategorizationController {

    public void categorize(Booking booking) {
        var categoriesAssociatedWithUser = (new UserDAO()).getCategoriesWithMatcher(); //myMap.keySet()
        //categoriesAssociatedWithUser.forEach(c -> c.get("MATCHING_WORD")); //TODO
        booking.getBankAccount().getCategories().forEach(category -> category.getStringPatterns().forEach(
                stringPattern -> {
                    if(booking.getPurposeOfUse().contains(stringPattern) || booking.getBookingType().contains(stringPattern)) {
                        booking.getCategories().add(category);
                    }
                }
        ));
    }
}

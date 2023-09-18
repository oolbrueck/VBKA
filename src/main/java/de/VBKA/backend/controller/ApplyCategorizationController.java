package de.VBKA.backend.controller;

import de.VBKA.backend.dao.UserDAO;
import de.VBKA.backend.entity.Booking;
import de.VBKA.backend.entity.Category;
import de.VBKA.database.jooq.tables.records.CategoryRecord;

import java.util.List;
import java.util.Map;

public class ApplyCategorizationController {

    public void categorize(Booking booking) {
        var categoriesAssociatedWithUser = (new UserDAO()).getCategoriesWithMatcher(); //myMap.keySet()

        for (Map<String, Object> map : categoriesAssociatedWithUser) {
            var matchingWord = map.get("MATCHING_WORD");
            var idAssociatedWithKeyWordName = (int)map.get("ID");

            if(booking.getBookingType().contains((String)matchingWord) || booking.getPurposeOfUse().contains((String)matchingWord)) {
                booking.getCategories().add(new Category(idAssociatedWithKeyWordName));
            }
        }
    }
}

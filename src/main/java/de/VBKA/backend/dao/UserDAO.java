/**
 * Author: Oliver Olbrück
 */

package de.VBKA.backend.dao;

import de.VBKA.backend.controller.SessionController;
import de.VBKA.database.DataBase;
import de.VBKA.database.jooq.tables.Category;
import de.VBKA.database.jooq.tables.records.UserTableRecord;

import java.util.List;
import java.util.Map;

import static de.VBKA.database.jooq.Tables.*;
import static de.VBKA.database.jooq.tables.UserTable.USER_TABLE;


public class UserDAO {

    public int createUser(UserTableRecord user) {
        return DataBase.db.insertInto(USER_TABLE).columns(USER_TABLE.NAME).values(user.getName()).execute();
    }

    public int deleteUser(UserTableRecord user) {
        return DataBase.db.delete(USER_TABLE).where(USER_TABLE.NAME.eq(user.getName())).execute();
    }

    public List<UserTableRecord> readAllUser() {
        return DataBase.db.select().from(USER_TABLE).fetchInto(UserTableRecord.class);
    }

    public List<Map<String, Object>> getCategoriesWithMatcher() {
        var currentUser = SessionController.getCurrentUser();
        var result = DataBase.db
                .select(CATEGORY.NAME, CATEGORY_MATCHER.MATCHING_WORD, CATEGORY.ID, CATEGORY.FK_USER)
                .from(CATEGORY_MATCHER_R_CATEGORY)
                .join(CATEGORY_MATCHER)
                .on(CATEGORY_MATCHER_R_CATEGORY.FK_CATEGORY_MATCHER.eq(CATEGORY_MATCHER.ID))
                .join(CATEGORY)
                .on(CATEGORY_MATCHER_R_CATEGORY.FK_CATEGORY.eq(CATEGORY.ID))
                .where(CATEGORY.FK_USER.eq(currentUser)) // Hier wird die Bedingung hinzugefügt
                .fetch().intoMaps();
        return result;
    }

    public int insertKeyWords(String keyWordName, List<String> keyWords) {
        var idKeyWordName = DataBase.db.insertInto(CATEGORY)
                .columns(CATEGORY.NAME, CATEGORY.FK_USER)
                .values(keyWordName, SessionController.getCurrentUser())
                .returning(CATEGORY.ID)
                .fetchOne().value1();
        for(String kw : keyWords) {
            var idMatcher = DataBase.db.insertInto(CATEGORY_MATCHER)
                    .columns(CATEGORY_MATCHER.MATCHING_WORD)
                    .values(kw)
                    .returning(CATEGORY_MATCHER.ID)
                    .fetchOne().value1();

            DataBase.db.insertInto(CATEGORY_MATCHER_R_CATEGORY)
                    .columns(CATEGORY_MATCHER_R_CATEGORY.FK_CATEGORY, CATEGORY_MATCHER_R_CATEGORY.FK_CATEGORY_MATCHER)
                    .values(idKeyWordName, idMatcher)
                    .execute();
        }

        var toPrint = this.getCategoriesWithMatcher();

        for (Map<String, Object> data : toPrint) {
            System.out.println("Datensatz:");

            for (Map.Entry<String, Object> entry : data.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                System.out.println(key + ": " + value);
            }

            System.out.println(); // Leerzeile zwischen den Datensätzen
        }
        return 0;
    }
}

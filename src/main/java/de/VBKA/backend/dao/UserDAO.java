/**
 * Author: Oliver Olbrück
 */

package de.VBKA.backend.dao;

import de.VBKA.backend.controller.SessionController;
import de.VBKA.database.DataBase;
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
                .select(CATEGORY_MATCHER.MATCHING_WORD, CATEGORY.NAME, CATEGORY.FK_USER)
                .from(CATEGORY_MATCHER_R_CATEGORY)
                .join(CATEGORY_MATCHER)
                .on(CATEGORY_MATCHER_R_CATEGORY.FK_CATEGORY_MATCHER.eq(CATEGORY_MATCHER.MATCHING_WORD))
                .join(CATEGORY)
                .on(CATEGORY_MATCHER_R_CATEGORY.FK_CATEGORY.eq(CATEGORY.ID))
                .where(CATEGORY.FK_USER.eq(currentUser)) // Hier wird die Bedingung hinzugefügt
                .fetch().intoMaps();
        return result;
    }
}

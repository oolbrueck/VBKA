/**
 * Author: Oliver Olbrück
 */

package de.VBKA.backend.dao;

import de.VBKA.database.DataBase;
import static de.VBKA.database.jooq.tables.UserTable.USER_TABLE;


public class UserDAO {

    public Integer getUserId(String user) {
        return DataBase.db.select(USER_TABLE.ID)
                .from(USER_TABLE)
                .where(USER_TABLE.NAME.eq(user))
                .fetchOne(USER_TABLE.ID);
    }
}

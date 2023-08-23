/**
 * Author: Oliver Olbrück
 */

package de.VBKA.backend.dao;

import de.VBKA.database.DataBase;
import de.VBKA.database.jooq.tables.records.AccountRecord;
import de.VBKA.database.jooq.tables.records.UserTableRecord;

import java.util.List;

import static de.VBKA.database.jooq.tables.Account.ACCOUNT;
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
}

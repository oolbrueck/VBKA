package de.VBKA.backend.dao;

import de.VBKA.database.DataBase;
import de.VBKA.database.jooq.tables.records.AccountRecord;

import java.util.List;

import static de.VBKA.database.jooq.tables.Account.ACCOUNT;


public class AccountDAO {

    public int createAccount(AccountRecord account) {
        return DataBase.db.insertInto(ACCOUNT).columns(ACCOUNT.IBAN).values(account.getIban()).execute();
    }

    public int deleteAccount(AccountRecord account) {
        return DataBase.db.delete(ACCOUNT).where(ACCOUNT.IBAN.eq(account.getIban())).execute();
    }

    public List<AccountRecord> readAllAccounts() {
        return DataBase.db.select().from(ACCOUNT).fetchInto(AccountRecord.class);
    }
}

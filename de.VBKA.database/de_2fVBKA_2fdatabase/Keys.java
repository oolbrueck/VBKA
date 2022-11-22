/*
 * This file is generated by jOOQ.
 */
package de_2fVBKA_2fdatabase;


import de_2fVBKA_2fdatabase.tables.Account;
import de_2fVBKA_2fdatabase.tables.records.AccountRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * PUBLIC.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AccountRecord> CONSTRAINT_E = Internal.createUniqueKey(Account.ACCOUNT, DSL.name("CONSTRAINT_E"), new TableField[] { Account.ACCOUNT.IBAN }, true);
}
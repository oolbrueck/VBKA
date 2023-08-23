/*
 * This file is generated by jOOQ.
 */
package de.VBKA.database.jooq.tables.records;


import de.VBKA.database.jooq.tables.Account;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AccountRecord extends UpdatableRecordImpl<AccountRecord> implements Record2<String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>VBKA.ACCOUNT.IBAN</code>.
     */
    public void setIban(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>VBKA.ACCOUNT.IBAN</code>.
     */
    public String getIban() {
        return (String) get(0);
    }

    /**
     * Setter for <code>VBKA.ACCOUNT.FK_USER</code>.
     */
    public void setFkUser(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>VBKA.ACCOUNT.FK_USER</code>.
     */
    public String getFkUser() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Account.ACCOUNT.IBAN;
    }

    @Override
    public Field<String> field2() {
        return Account.ACCOUNT.FK_USER;
    }

    @Override
    public String component1() {
        return getIban();
    }

    @Override
    public String component2() {
        return getFkUser();
    }

    @Override
    public String value1() {
        return getIban();
    }

    @Override
    public String value2() {
        return getFkUser();
    }

    @Override
    public AccountRecord value1(String value) {
        setIban(value);
        return this;
    }

    @Override
    public AccountRecord value2(String value) {
        setFkUser(value);
        return this;
    }

    @Override
    public AccountRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AccountRecord
     */
    public AccountRecord() {
        super(Account.ACCOUNT);
    }

    /**
     * Create a detached, initialised AccountRecord
     */
    public AccountRecord(String iban, String fkUser) {
        super(Account.ACCOUNT);

        setIban(iban);
        setFkUser(fkUser);
    }
}

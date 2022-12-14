/*
 * This file is generated by jOOQ.
 */
package de.VBKA.database.de_2fVBKA_2fdatabase.tables.records;


import de.VBKA.database.de_2fVBKA_2fdatabase.tables.Account;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Row1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AccountRecord extends UpdatableRecordImpl<AccountRecord> implements Record1<String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>PUBLIC.ACCOUNT.IBAN</code>.
     */
    public void setIban(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>PUBLIC.ACCOUNT.IBAN</code>.
     */
    public String getIban() {
        return (String) get(0);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record1 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row1<String> fieldsRow() {
        return (Row1) super.fieldsRow();
    }

    @Override
    public Row1<String> valuesRow() {
        return (Row1) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Account.ACCOUNT.IBAN;
    }

    @Override
    public String component1() {
        return getIban();
    }

    @Override
    public String value1() {
        return getIban();
    }

    @Override
    public AccountRecord value1(String value) {
        setIban(value);
        return this;
    }

    @Override
    public AccountRecord values(String value1) {
        value1(value1);
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
    public AccountRecord(String iban) {
        super(Account.ACCOUNT);

        setIban(iban);
    }
}

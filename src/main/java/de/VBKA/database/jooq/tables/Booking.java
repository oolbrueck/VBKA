/*
 * This file is generated by jOOQ.
 */
package de.VBKA.database.jooq.tables;


import de.VBKA.database.jooq.Keys;
import de.VBKA.database.jooq.Vbka;
import de.VBKA.database.jooq.tables.records.BookingRecord;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function6;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Booking extends TableImpl<BookingRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>VBKA.BOOKING</code>
     */
    public static final Booking BOOKING = new Booking();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BookingRecord> getRecordType() {
        return BookingRecord.class;
    }

    /**
     * The column <code>VBKA.BOOKING.ID</code>.
     */
    public final TableField<BookingRecord, Integer> ID = createField(DSL.name("ID"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>VBKA.BOOKING.FK_ACCOUNT</code>.
     */
    public final TableField<BookingRecord, String> FK_ACCOUNT = createField(DSL.name("FK_ACCOUNT"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>VBKA.BOOKING.FK_BANK_STATEMENT</code>.
     */
    public final TableField<BookingRecord, Integer> FK_BANK_STATEMENT = createField(DSL.name("FK_BANK_STATEMENT"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>VBKA.BOOKING.BOOKING_DATE</code>.
     */
    public final TableField<BookingRecord, LocalDate> BOOKING_DATE = createField(DSL.name("BOOKING_DATE"), SQLDataType.LOCALDATE.nullable(false), this, "");

    /**
     * The column <code>VBKA.BOOKING.AMOUNT_IN_CENT</code>.
     */
    public final TableField<BookingRecord, Integer> AMOUNT_IN_CENT = createField(DSL.name("AMOUNT_IN_CENT"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>VBKA.BOOKING.BOOKING_AS_STRING</code>.
     */
    public final TableField<BookingRecord, String> BOOKING_AS_STRING = createField(DSL.name("BOOKING_AS_STRING"), SQLDataType.VARCHAR(512).nullable(false), this, "");

    private Booking(Name alias, Table<BookingRecord> aliased) {
        this(alias, aliased, null);
    }

    private Booking(Name alias, Table<BookingRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>VBKA.BOOKING</code> table reference
     */
    public Booking(String alias) {
        this(DSL.name(alias), BOOKING);
    }

    /**
     * Create an aliased <code>VBKA.BOOKING</code> table reference
     */
    public Booking(Name alias) {
        this(alias, BOOKING);
    }

    /**
     * Create a <code>VBKA.BOOKING</code> table reference
     */
    public Booking() {
        this(DSL.name("BOOKING"), null);
    }

    public <O extends Record> Booking(Table<O> child, ForeignKey<O, BookingRecord> key) {
        super(child, key, BOOKING);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Vbka.VBKA;
    }

    @Override
    public UniqueKey<BookingRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_2;
    }

    @Override
    public List<ForeignKey<BookingRecord, ?>> getReferences() {
        return Arrays.asList(Keys.CONSTRAINT_2E, Keys.CONSTRAINT_2EA);
    }

    private transient Account _account;
    private transient BankStatement _bankStatement;

    /**
     * Get the implicit join path to the <code>VBKA.ACCOUNT</code> table.
     */
    public Account account() {
        if (_account == null)
            _account = new Account(this, Keys.CONSTRAINT_2E);

        return _account;
    }

    /**
     * Get the implicit join path to the <code>VBKA.BANK_STATEMENT</code> table.
     */
    public BankStatement bankStatement() {
        if (_bankStatement == null)
            _bankStatement = new BankStatement(this, Keys.CONSTRAINT_2EA);

        return _bankStatement;
    }

    @Override
    public Booking as(String alias) {
        return new Booking(DSL.name(alias), this);
    }

    @Override
    public Booking as(Name alias) {
        return new Booking(alias, this);
    }

    @Override
    public Booking as(Table<?> alias) {
        return new Booking(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Booking rename(String name) {
        return new Booking(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Booking rename(Name name) {
        return new Booking(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Booking rename(Table<?> name) {
        return new Booking(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, String, Integer, LocalDate, Integer, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function6<? super Integer, ? super String, ? super Integer, ? super LocalDate, ? super Integer, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function6<? super Integer, ? super String, ? super Integer, ? super LocalDate, ? super Integer, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}

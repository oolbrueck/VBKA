/*
 * This file is generated by jOOQ.
 */
package de.VBKA.database.jooq.tables.records;


import de.VBKA.database.jooq.tables.BookingRCategory;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BookingRCategoryRecord extends UpdatableRecordImpl<BookingRCategoryRecord> implements Record2<Long, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>VBKA.BOOKING_R_CATEGORY.FK_BOOKING</code>.
     */
    public void setFkBooking(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>VBKA.BOOKING_R_CATEGORY.FK_BOOKING</code>.
     */
    public Long getFkBooking() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>VBKA.BOOKING_R_CATEGORY.FK_CATEGORY</code>.
     */
    public void setFkCategory(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>VBKA.BOOKING_R_CATEGORY.FK_CATEGORY</code>.
     */
    public Long getFkCategory() {
        return (Long) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<Long, Long> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, Long> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Long, Long> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return BookingRCategory.BOOKING_R_CATEGORY.FK_BOOKING;
    }

    @Override
    public Field<Long> field2() {
        return BookingRCategory.BOOKING_R_CATEGORY.FK_CATEGORY;
    }

    @Override
    public Long component1() {
        return getFkBooking();
    }

    @Override
    public Long component2() {
        return getFkCategory();
    }

    @Override
    public Long value1() {
        return getFkBooking();
    }

    @Override
    public Long value2() {
        return getFkCategory();
    }

    @Override
    public BookingRCategoryRecord value1(Long value) {
        setFkBooking(value);
        return this;
    }

    @Override
    public BookingRCategoryRecord value2(Long value) {
        setFkCategory(value);
        return this;
    }

    @Override
    public BookingRCategoryRecord values(Long value1, Long value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BookingRCategoryRecord
     */
    public BookingRCategoryRecord() {
        super(BookingRCategory.BOOKING_R_CATEGORY);
    }

    /**
     * Create a detached, initialised BookingRCategoryRecord
     */
    public BookingRCategoryRecord(Long fkBooking, Long fkCategory) {
        super(BookingRCategory.BOOKING_R_CATEGORY);

        setFkBooking(fkBooking);
        setFkCategory(fkCategory);
    }
}

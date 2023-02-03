/*
 * This file is generated by jOOQ.
 */
package de.VBKA.database.jooq;


import de.VBKA.database.jooq.tables.Account;
import de.VBKA.database.jooq.tables.Booking;
import de.VBKA.database.jooq.tables.BookingRCategory;
import de.VBKA.database.jooq.tables.Category;
import de.VBKA.database.jooq.tables.CategoryMatcher;
import de.VBKA.database.jooq.tables.CategoryMatcherRCategory;
import de.VBKA.database.jooq.tables.CategoryRCategory;
import de.VBKA.database.jooq.tables.UserTable;
import de.VBKA.database.jooq.tables.records.AccountRecord;
import de.VBKA.database.jooq.tables.records.BookingRCategoryRecord;
import de.VBKA.database.jooq.tables.records.BookingRecord;
import de.VBKA.database.jooq.tables.records.CategoryMatcherRCategoryRecord;
import de.VBKA.database.jooq.tables.records.CategoryMatcherRecord;
import de.VBKA.database.jooq.tables.records.CategoryRCategoryRecord;
import de.VBKA.database.jooq.tables.records.CategoryRecord;
import de.VBKA.database.jooq.tables.records.UserTableRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * VBKA.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AccountRecord> CONSTRAINT_E = Internal.createUniqueKey(Account.ACCOUNT, DSL.name("CONSTRAINT_E"), new TableField[] { Account.ACCOUNT.IBAN }, true);
    public static final UniqueKey<BookingRecord> CONSTRAINT_2 = Internal.createUniqueKey(Booking.BOOKING, DSL.name("CONSTRAINT_2"), new TableField[] { Booking.BOOKING.ID }, true);
    public static final UniqueKey<BookingRCategoryRecord> CONSTRAINT_6 = Internal.createUniqueKey(BookingRCategory.BOOKING_R_CATEGORY, DSL.name("CONSTRAINT_6"), new TableField[] { BookingRCategory.BOOKING_R_CATEGORY.FK_BOOKING, BookingRCategory.BOOKING_R_CATEGORY.FK_CATEGORY }, true);
    public static final UniqueKey<CategoryRecord> CONSTRAINT_3 = Internal.createUniqueKey(Category.CATEGORY, DSL.name("CONSTRAINT_3"), new TableField[] { Category.CATEGORY.ID }, true);
    public static final UniqueKey<CategoryMatcherRecord> CONSTRAINT_9 = Internal.createUniqueKey(CategoryMatcher.CATEGORY_MATCHER, DSL.name("CONSTRAINT_9"), new TableField[] { CategoryMatcher.CATEGORY_MATCHER.MATCHING_WORD }, true);
    public static final UniqueKey<CategoryMatcherRCategoryRecord> CONSTRAINT_D = Internal.createUniqueKey(CategoryMatcherRCategory.CATEGORY_MATCHER_R_CATEGORY, DSL.name("CONSTRAINT_D"), new TableField[] { CategoryMatcherRCategory.CATEGORY_MATCHER_R_CATEGORY.FK_CATEGORY, CategoryMatcherRCategory.CATEGORY_MATCHER_R_CATEGORY.FK_CATEGORY_MATCHER }, true);
    public static final UniqueKey<CategoryRCategoryRecord> CONSTRAINT_6A = Internal.createUniqueKey(CategoryRCategory.CATEGORY_R_CATEGORY, DSL.name("CONSTRAINT_6A"), new TableField[] { CategoryRCategory.CATEGORY_R_CATEGORY.FK_PARENT_CATEGORY, CategoryRCategory.CATEGORY_R_CATEGORY.FK_CHILD_CATEGORY }, true);
    public static final UniqueKey<UserTableRecord> CONSTRAINT_C = Internal.createUniqueKey(UserTable.USER_TABLE, DSL.name("CONSTRAINT_C"), new TableField[] { UserTable.USER_TABLE.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<AccountRecord, UserTableRecord> CONSTRAINT_E4 = Internal.createForeignKey(Account.ACCOUNT, DSL.name("CONSTRAINT_E4"), new TableField[] { Account.ACCOUNT.FK_USER }, Keys.CONSTRAINT_C, new TableField[] { UserTable.USER_TABLE.ID }, true);
    public static final ForeignKey<BookingRecord, AccountRecord> CONSTRAINT_2E = Internal.createForeignKey(Booking.BOOKING, DSL.name("CONSTRAINT_2E"), new TableField[] { Booking.BOOKING.FK_ACCOUNT }, Keys.CONSTRAINT_E, new TableField[] { Account.ACCOUNT.IBAN }, true);
    public static final ForeignKey<BookingRCategoryRecord, BookingRecord> CONSTRAINT_6F = Internal.createForeignKey(BookingRCategory.BOOKING_R_CATEGORY, DSL.name("CONSTRAINT_6F"), new TableField[] { BookingRCategory.BOOKING_R_CATEGORY.FK_BOOKING }, Keys.CONSTRAINT_2, new TableField[] { Booking.BOOKING.ID }, true);
    public static final ForeignKey<BookingRCategoryRecord, CategoryRecord> CONSTRAINT_6F3 = Internal.createForeignKey(BookingRCategory.BOOKING_R_CATEGORY, DSL.name("CONSTRAINT_6F3"), new TableField[] { BookingRCategory.BOOKING_R_CATEGORY.FK_CATEGORY }, Keys.CONSTRAINT_3, new TableField[] { Category.CATEGORY.ID }, true);
    public static final ForeignKey<CategoryMatcherRCategoryRecord, CategoryRecord> CONSTRAINT_DF = Internal.createForeignKey(CategoryMatcherRCategory.CATEGORY_MATCHER_R_CATEGORY, DSL.name("CONSTRAINT_DF"), new TableField[] { CategoryMatcherRCategory.CATEGORY_MATCHER_R_CATEGORY.FK_CATEGORY }, Keys.CONSTRAINT_3, new TableField[] { Category.CATEGORY.ID }, true);
    public static final ForeignKey<CategoryMatcherRCategoryRecord, CategoryMatcherRecord> CONSTRAINT_DF8 = Internal.createForeignKey(CategoryMatcherRCategory.CATEGORY_MATCHER_R_CATEGORY, DSL.name("CONSTRAINT_DF8"), new TableField[] { CategoryMatcherRCategory.CATEGORY_MATCHER_R_CATEGORY.FK_CATEGORY_MATCHER }, Keys.CONSTRAINT_9, new TableField[] { CategoryMatcher.CATEGORY_MATCHER.MATCHING_WORD }, true);
    public static final ForeignKey<CategoryRCategoryRecord, CategoryRecord> CONSTRAINT_6A2 = Internal.createForeignKey(CategoryRCategory.CATEGORY_R_CATEGORY, DSL.name("CONSTRAINT_6A2"), new TableField[] { CategoryRCategory.CATEGORY_R_CATEGORY.FK_PARENT_CATEGORY }, Keys.CONSTRAINT_3, new TableField[] { Category.CATEGORY.ID }, true);
    public static final ForeignKey<CategoryRCategoryRecord, CategoryRecord> CONSTRAINT_6A28 = Internal.createForeignKey(CategoryRCategory.CATEGORY_R_CATEGORY, DSL.name("CONSTRAINT_6A28"), new TableField[] { CategoryRCategory.CATEGORY_R_CATEGORY.FK_CHILD_CATEGORY }, Keys.CONSTRAINT_3, new TableField[] { Category.CATEGORY.ID }, true);
}
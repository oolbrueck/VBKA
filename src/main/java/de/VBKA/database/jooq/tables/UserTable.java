/*
 * This file is generated by jOOQ.
 */
package de.VBKA.database.jooq.tables;


import de.VBKA.database.jooq.Keys;
import de.VBKA.database.jooq.Vbka;
import de.VBKA.database.jooq.tables.records.UserTableRecord;

import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function1;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row1;
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
public class UserTable extends TableImpl<UserTableRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>VBKA.USER_TABLE</code>
     */
    public static final UserTable USER_TABLE = new UserTable();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserTableRecord> getRecordType() {
        return UserTableRecord.class;
    }

    /**
     * The column <code>VBKA.USER_TABLE.NAME</code>.
     */
    public final TableField<UserTableRecord, String> NAME = createField(DSL.name("NAME"), SQLDataType.VARCHAR(20).nullable(false), this, "");

    private UserTable(Name alias, Table<UserTableRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserTable(Name alias, Table<UserTableRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>VBKA.USER_TABLE</code> table reference
     */
    public UserTable(String alias) {
        this(DSL.name(alias), USER_TABLE);
    }

    /**
     * Create an aliased <code>VBKA.USER_TABLE</code> table reference
     */
    public UserTable(Name alias) {
        this(alias, USER_TABLE);
    }

    /**
     * Create a <code>VBKA.USER_TABLE</code> table reference
     */
    public UserTable() {
        this(DSL.name("USER_TABLE"), null);
    }

    public <O extends Record> UserTable(Table<O> child, ForeignKey<O, UserTableRecord> key) {
        super(child, key, USER_TABLE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Vbka.VBKA;
    }

    @Override
    public UniqueKey<UserTableRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_C;
    }

    @Override
    public UserTable as(String alias) {
        return new UserTable(DSL.name(alias), this);
    }

    @Override
    public UserTable as(Name alias) {
        return new UserTable(alias, this);
    }

    @Override
    public UserTable as(Table<?> alias) {
        return new UserTable(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserTable rename(String name) {
        return new UserTable(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserTable rename(Name name) {
        return new UserTable(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserTable rename(Table<?> name) {
        return new UserTable(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row1 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row1<String> fieldsRow() {
        return (Row1) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function1<? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function1<? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}

/*
 * This file is generated by jOOQ.
 */
package de.VBKA.database.jooq.tables;


import de.VBKA.database.jooq.Keys;
import de.VBKA.database.jooq.Vbka;
import de.VBKA.database.jooq.tables.records.AccountRecord;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function2;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row2;
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
public class Account extends TableImpl<AccountRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>VBKA.ACCOUNT</code>
     */
    public static final Account ACCOUNT = new Account();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AccountRecord> getRecordType() {
        return AccountRecord.class;
    }

    /**
     * The column <code>VBKA.ACCOUNT.IBAN</code>.
     */
    public final TableField<AccountRecord, String> IBAN = createField(DSL.name("IBAN"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>VBKA.ACCOUNT.FK_USER</code>.
     */
    public final TableField<AccountRecord, String> FK_USER = createField(DSL.name("FK_USER"), SQLDataType.VARCHAR(20).nullable(false), this, "");

    private Account(Name alias, Table<AccountRecord> aliased) {
        this(alias, aliased, null);
    }

    private Account(Name alias, Table<AccountRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>VBKA.ACCOUNT</code> table reference
     */
    public Account(String alias) {
        this(DSL.name(alias), ACCOUNT);
    }

    /**
     * Create an aliased <code>VBKA.ACCOUNT</code> table reference
     */
    public Account(Name alias) {
        this(alias, ACCOUNT);
    }

    /**
     * Create a <code>VBKA.ACCOUNT</code> table reference
     */
    public Account() {
        this(DSL.name("ACCOUNT"), null);
    }

    public <O extends Record> Account(Table<O> child, ForeignKey<O, AccountRecord> key) {
        super(child, key, ACCOUNT);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Vbka.VBKA;
    }

    @Override
    public UniqueKey<AccountRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_E;
    }

    @Override
    public List<ForeignKey<AccountRecord, ?>> getReferences() {
        return Arrays.asList(Keys.CONSTRAINT_E4);
    }

    private transient UserTable _userTable;

    /**
     * Get the implicit join path to the <code>VBKA.USER_TABLE</code> table.
     */
    public UserTable userTable() {
        if (_userTable == null)
            _userTable = new UserTable(this, Keys.CONSTRAINT_E4);

        return _userTable;
    }

    @Override
    public Account as(String alias) {
        return new Account(DSL.name(alias), this);
    }

    @Override
    public Account as(Name alias) {
        return new Account(alias, this);
    }

    @Override
    public Account as(Table<?> alias) {
        return new Account(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Account rename(String name) {
        return new Account(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Account rename(Name name) {
        return new Account(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Account rename(Table<?> name) {
        return new Account(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function2<? super String, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function2<? super String, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}

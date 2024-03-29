/*
 * This file is generated by jOOQ.
 */
package de.VBKA.database.jooq.tables;


import de.VBKA.database.jooq.Keys;
import de.VBKA.database.jooq.Vbka;
import de.VBKA.database.jooq.tables.records.BankStatementRecord;

import java.time.LocalDateTime;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function3;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row3;
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
public class BankStatement extends TableImpl<BankStatementRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>VBKA.BANK_STATEMENT</code>
     */
    public static final BankStatement BANK_STATEMENT = new BankStatement();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BankStatementRecord> getRecordType() {
        return BankStatementRecord.class;
    }

    /**
     * The column <code>VBKA.BANK_STATEMENT.ID</code>.
     */
    public final TableField<BankStatementRecord, Long> ID = createField(DSL.name("ID"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>VBKA.BANK_STATEMENT.FILE_NAME</code>.
     */
    public final TableField<BankStatementRecord, String> FILE_NAME = createField(DSL.name("FILE_NAME"), SQLDataType.VARCHAR(70).nullable(false), this, "");

    /**
     * The column <code>VBKA.BANK_STATEMENT.DATE_OF_UPLOAD</code>.
     */
    public final TableField<BankStatementRecord, LocalDateTime> DATE_OF_UPLOAD = createField(DSL.name("DATE_OF_UPLOAD"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "");

    private BankStatement(Name alias, Table<BankStatementRecord> aliased) {
        this(alias, aliased, null);
    }

    private BankStatement(Name alias, Table<BankStatementRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>VBKA.BANK_STATEMENT</code> table reference
     */
    public BankStatement(String alias) {
        this(DSL.name(alias), BANK_STATEMENT);
    }

    /**
     * Create an aliased <code>VBKA.BANK_STATEMENT</code> table reference
     */
    public BankStatement(Name alias) {
        this(alias, BANK_STATEMENT);
    }

    /**
     * Create a <code>VBKA.BANK_STATEMENT</code> table reference
     */
    public BankStatement() {
        this(DSL.name("BANK_STATEMENT"), null);
    }

    public <O extends Record> BankStatement(Table<O> child, ForeignKey<O, BankStatementRecord> key) {
        super(child, key, BANK_STATEMENT);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Vbka.VBKA;
    }

    @Override
    public Identity<BankStatementRecord, Long> getIdentity() {
        return (Identity<BankStatementRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<BankStatementRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_9;
    }

    @Override
    public BankStatement as(String alias) {
        return new BankStatement(DSL.name(alias), this);
    }

    @Override
    public BankStatement as(Name alias) {
        return new BankStatement(alias, this);
    }

    @Override
    public BankStatement as(Table<?> alias) {
        return new BankStatement(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public BankStatement rename(String name) {
        return new BankStatement(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public BankStatement rename(Name name) {
        return new BankStatement(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public BankStatement rename(Table<?> name) {
        return new BankStatement(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, String, LocalDateTime> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function3<? super Long, ? super String, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function3<? super Long, ? super String, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}

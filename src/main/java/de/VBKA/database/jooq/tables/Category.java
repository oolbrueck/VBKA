/*
 * This file is generated by jOOQ.
 */
package de.VBKA.database.jooq.tables;


import de.VBKA.database.jooq.Keys;
import de.VBKA.database.jooq.Vbka;
import de.VBKA.database.jooq.tables.records.CategoryRecord;

import java.util.Arrays;
import java.util.List;
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
public class Category extends TableImpl<CategoryRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>VBKA.CATEGORY</code>
     */
    public static final Category CATEGORY = new Category();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CategoryRecord> getRecordType() {
        return CategoryRecord.class;
    }

    /**
     * The column <code>VBKA.CATEGORY.ID</code>.
     */
    public final TableField<CategoryRecord, Long> ID = createField(DSL.name("ID"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>VBKA.CATEGORY.NAME</code>.
     */
    public final TableField<CategoryRecord, String> NAME = createField(DSL.name("NAME"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>VBKA.CATEGORY.FK_USER</code>.
     */
    public final TableField<CategoryRecord, String> FK_USER = createField(DSL.name("FK_USER"), SQLDataType.VARCHAR(20).nullable(false), this, "");

    private Category(Name alias, Table<CategoryRecord> aliased) {
        this(alias, aliased, null);
    }

    private Category(Name alias, Table<CategoryRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>VBKA.CATEGORY</code> table reference
     */
    public Category(String alias) {
        this(DSL.name(alias), CATEGORY);
    }

    /**
     * Create an aliased <code>VBKA.CATEGORY</code> table reference
     */
    public Category(Name alias) {
        this(alias, CATEGORY);
    }

    /**
     * Create a <code>VBKA.CATEGORY</code> table reference
     */
    public Category() {
        this(DSL.name("CATEGORY"), null);
    }

    public <O extends Record> Category(Table<O> child, ForeignKey<O, CategoryRecord> key) {
        super(child, key, CATEGORY);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Vbka.VBKA;
    }

    @Override
    public Identity<CategoryRecord, Long> getIdentity() {
        return (Identity<CategoryRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<CategoryRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_3;
    }

    @Override
    public List<ForeignKey<CategoryRecord, ?>> getReferences() {
        return Arrays.asList(Keys.CONSTRAINT_31);
    }

    private transient UserTable _userTable;

    /**
     * Get the implicit join path to the <code>VBKA.USER_TABLE</code> table.
     */
    public UserTable userTable() {
        if (_userTable == null)
            _userTable = new UserTable(this, Keys.CONSTRAINT_31);

        return _userTable;
    }

    @Override
    public Category as(String alias) {
        return new Category(DSL.name(alias), this);
    }

    @Override
    public Category as(Name alias) {
        return new Category(alias, this);
    }

    @Override
    public Category as(Table<?> alias) {
        return new Category(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Category rename(String name) {
        return new Category(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Category rename(Name name) {
        return new Category(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Category rename(Table<?> name) {
        return new Category(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function3<? super Long, ? super String, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function3<? super Long, ? super String, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}

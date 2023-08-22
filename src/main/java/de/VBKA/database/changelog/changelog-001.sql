-- liquibase formatted sql

-- Changeset oolbrueck:1
CREATE SCHEMA IF NOT EXISTS VBKA;
CREATE TABLE IF NOT EXISTS VBKA.USER_TABLE(
    ID INTEGER NOT NULL PRIMARY KEY,
    NAME VARCHAR(20) NOT NULL
);
CREATE TABLE IF NOT EXISTS VBKA.ACCOUNT(
    IBAN VARCHAR(50) NOT NULL PRIMARY KEY,
    FK_USER INTEGER NOT NULL,
    FOREIGN KEY (FK_USER) REFERENCES VBKA.USER_TABLE(ID)
);
CREATE TABLE IF NOT EXISTS VBKA.BANK_STATEMENT(
    ID INTEGER NOT NULL PRIMARY KEY,
    FILE_NAME VARCHAR(70) NOT NULL,
    DATE_OF_UPLOAD DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS VBKA.BOOKING(
    ID INTEGER NOT NULL PRIMARY KEY,
    FK_ACCOUNT VARCHAR(50) NOT NULL,
    FK_BANK_STATEMENT INTEGER NOT NULL,
    BOOKING_DATE DATE NOT NULL,
    AMOUNT_IN_CENT INTEGER NOT NULL,
    BOOKING_AS_STRING VARCHAR(512) NOT NULL,
    FOREIGN KEY (FK_ACCOUNT) REFERENCES VBKA.ACCOUNT(IBAN),
    FOREIGN KEY (FK_BANK_STATEMENT) REFERENCES VBKA.BANK_STATEMENT(ID)
);
CREATE TABLE IF NOT EXISTS VBKA.CATEGORY(
    ID INTEGER NOT NULL PRIMARY KEY,
    NAME VARCHAR(50) NOT NULL
);
CREATE TABLE IF NOT EXISTS VBKA.BOOKING_R_CATEGORY(
    FK_BOOKING INTEGER NOT NULL,
    FK_CATEGORY INTEGER NOT NULL,
    PRIMARY KEY (FK_BOOKING, FK_CATEGORY),
    FOREIGN KEY (FK_BOOKING) REFERENCES VBKA.BOOKING(ID),
    FOREIGN KEY (FK_CATEGORY) REFERENCES VBKA.CATEGORY(ID)
);
CREATE TABLE IF NOT EXISTS VBKA.CATEGORY_R_CATEGORY(
    FK_PARENT_CATEGORY INTEGER NOT NULL,
    FK_CHILD_CATEGORY INTEGER NOT NULL,
    PRIMARY KEY (FK_PARENT_CATEGORY, FK_CHILD_CATEGORY),
    FOREIGN KEY (FK_PARENT_CATEGORY) REFERENCES VBKA.CATEGORY(ID),
    FOREIGN KEY (FK_CHILD_CATEGORY) REFERENCES VBKA.CATEGORY(ID)
);
CREATE TABLE IF NOT EXISTS VBKA.CATEGORY_MATCHER(
    MATCHING_WORD VARCHAR(50) NOT NULL PRIMARY KEY
);
CREATE TABLE IF NOT EXISTS VBKA.CATEGORY_MATCHER_R_CATEGORY(
    FK_CATEGORY INTEGER NOT NULL,
    FK_CATEGORY_MATCHER VARCHAR(50) NOT NULL,
    PRIMARY KEY (FK_CATEGORY, FK_CATEGORY_MATCHER),
    FOREIGN KEY (FK_CATEGORY) REFERENCES VBKA.CATEGORY(ID),
    FOREIGN KEY (FK_CATEGORY_MATCHER) REFERENCES VBKA.CATEGORY_MATCHER(MATCHING_WORD)
);

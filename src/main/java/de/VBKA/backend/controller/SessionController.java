package de.VBKA.backend.controller;

import de.VBKA.backend.entity.BankAccount;


public class SessionController {

    private static String currentBankAccount;

    public BankAccount getCurrentBankAccount() {
        return new BankAccount(currentBankAccount);
    }

    public int setCurrentBankAccount(BankAccount bankAccount) {
        currentBankAccount = bankAccount.getIban();
        return 0;
    }


}

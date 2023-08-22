package de.VBKA.backend.controller;

import de.VBKA.backend.entity.BankAccount;


public class SessionController {

    private static String currentBankAccount;
    private static String currentUser;

    public BankAccount getCurrentBankAccount() {
        return new BankAccount(currentBankAccount);
    }

    public int setCurrentBankAccount(BankAccount bankAccount) {
        //currentBankAccount = bankAccount.getIban();
        return 0;
    }

    public static void setCurrentBankAccount(String currentBankAccount) {
        SessionController.currentBankAccount = currentBankAccount;
    }

    public static String getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(String currentUser) {
        SessionController.currentUser = currentUser;
    }
}

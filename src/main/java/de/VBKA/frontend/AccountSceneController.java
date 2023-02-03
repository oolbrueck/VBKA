package de.VBKA.frontend;

import de.VBKA.backend.controller.SessionController;
import de.VBKA.backend.entity.BankAccount;
//import de.VBKA.database.dao.AccountDAO;
//import de.VBKA.database.de_2fVBKA_2fdatabase.tables.records.AccountRecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class AccountSceneController implements Initializable {

    @FXML
    ListView<String> listOfAccounts;
    Label label;
    String[] accounts;
    String currentAccount;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateAccountList();
    }

    public void addAccount(ActionEvent event) {
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setTitle("Account hinzufügen");
        textInputDialog.setHeaderText(null);
        textInputDialog.setGraphic(null);
        textInputDialog.setContentText("Iban ");
        textInputDialog.getDialogPane().setMinWidth(300);

        Optional<String> result = textInputDialog.showAndWait();
        System.out.println(result.get());
        //new AccountDAO().createAccount(new AccountRecord(result.get())); //TODO is present check
        updateAccountList();
    }

    public void deleteAccount(ActionEvent event) {
        System.out.println("delete");
        //new AccountDAO().deleteAccount(new AccountRecord(listOfAccounts.getSelectionModel().getSelectedItem()));
        updateAccountList();
    }

    public void inspectAccount(ActionEvent event) {
        System.out.println("inspect " + listOfAccounts.getSelectionModel().getSelectedItem());
        new SceneController().switchToMainMenue(event);
        new SessionController().setCurrentBankAccount(new BankAccount(listOfAccounts.getSelectionModel().getSelectedItem()));
    }

    private void updateAccountList() {
        listOfAccounts.getItems().clear();
        //listOfAccounts.getItems().addAll(new AccountDAO().readAllAccounts()
        //        .stream().map(AccountRecord::getIban).toList());
    }
}

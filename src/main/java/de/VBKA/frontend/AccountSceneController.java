package de.VBKA.frontend;

import de.VBKA.backend.controller.SessionController;
import de.VBKA.backend.dao.AccountDAO;
import de.VBKA.backend.dao.UserDAO;
import de.VBKA.backend.entity.BankAccount;
//import de.VBKA.database.dao.AccountDAO;
//import de.VBKA.database.de_2fVBKA_2fdatabase.tables.records.AccountRecord;
import de.VBKA.database.jooq.tables.records.AccountRecord;
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

        String ibanFromInput = textInputDialog.showAndWait().get();
        System.out.println(ibanFromInput);

        var allAccounts = new AccountDAO().readAllAccounts();
        for(AccountRecord accountRecord : allAccounts) {
            if(accountRecord.getIban().equals(ibanFromInput)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Account Management");
                alert.setContentText("Konto mit der Iban " + ibanFromInput + " bereits im System");
                alert.showAndWait();
                break;
            }
        }

        new AccountDAO().createAccount(new AccountRecord(ibanFromInput, SessionController.getCurrentUser()));
        updateAccountList();
    }

    public void deleteAccount(ActionEvent event) {
        System.out.println("delete");
        //new AccountDAO().deleteAccount(new AccountRecord(listOfAccounts.getSelectionModel().getSelectedItem()));
        updateAccountList();
    }

    public void inspectAccount(ActionEvent event) {
        System.out.println("inspect " + listOfAccounts.getSelectionModel().getSelectedItem());
        new SceneController().switchToDashboard(event);
        new SessionController().setCurrentBankAccount(new BankAccount(listOfAccounts.getSelectionModel().getSelectedItem()));
    }

    private void updateAccountList() {
        listOfAccounts.getItems().clear();
        //listOfAccounts.getItems().addAll(new AccountDAO().readAllAccounts()
        //        .stream().map(AccountRecord::getIban).toList());
    }

    public void goBackToMenue(ActionEvent event) {
        new SceneController().switchToDashboard(event);
    }
}

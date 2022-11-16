package de.VBKA.frontend;

import com.jfoenix.controls.JFXListView;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class GuiController implements Initializable {

    @FXML
    ListView<String> listOfAccounts;
    Label label;
    String[] accounts = {"Albert", "Oslo"};
    String currentAccount;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listOfAccounts.getItems().addAll(accounts);
    }

    public void addAccount(ActionEvent event) {
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setTitle("Account hinzufügen");
        textInputDialog.setHeaderText(null);
        textInputDialog.setGraphic(null);
        textInputDialog.setContentText("Iban ");
        textInputDialog.getDialogPane().setMinWidth(300);

        Optional<String> result = textInputDialog.showAndWait();
        listOfAccounts.getItems().add(result.get());
    }

    public void deleteAccount(ActionEvent event) {
        System.out.println("delete");
        listOfAccounts.getItems().remove(listOfAccounts.getSelectionModel().getSelectedItem());
    }

    public void inspectAccount(ActionEvent event) {
        System.out.println("inspect " + listOfAccounts.getSelectionModel().getSelectedItem());
    }
}

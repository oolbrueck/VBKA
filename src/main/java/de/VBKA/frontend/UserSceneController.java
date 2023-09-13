/**
 * Author: Oliver Olbrück
 */

package de.VBKA.frontend;

import de.VBKA.backend.controller.SessionController;
import de.VBKA.backend.dao.UserDAO;
import de.VBKA.database.jooq.tables.records.UserTableRecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;


public class UserSceneController implements Initializable {

    @FXML
    ListView<String> listOfUser;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateUserList();
    }

    public void addUser(ActionEvent event) {
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setTitle("User hinzufügen");
        textInputDialog.setHeaderText(null);
        textInputDialog.setGraphic(null);
        textInputDialog.setContentText("User ");
        textInputDialog.getDialogPane().setMinWidth(300);

        String newUser = textInputDialog.showAndWait().get();
        System.out.println(newUser);

        var allUser = new UserDAO().readAllUser();
        for(UserTableRecord userTableRecord : allUser) {
            if(userTableRecord.getName().equals(newUser)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("User Management");
                alert.setContentText("User " + newUser + " bereits im System");
                alert.showAndWait();
                break;
            }
        }
        new UserDAO().createUser(new UserTableRecord(newUser));
        updateUserList();
    }

    public void deleteUser(ActionEvent event) {
        System.out.println("delete");
        new UserDAO().deleteUser(new UserTableRecord(listOfUser.getSelectionModel().getSelectedItem()));
        updateUserList();
    }

    public void inspectUser(ActionEvent event) {
        System.out.println("inspect " + listOfUser.getSelectionModel().getSelectedItem());
        new SceneController().switchToDashboard(event);
        SessionController.setCurrentUser(listOfUser.getSelectionModel().getSelectedItem());
    }

    private void updateUserList() {
        listOfUser.getItems().clear();
        listOfUser.getItems().addAll(new UserDAO().readAllUser()
                .stream().map(UserTableRecord::getName).toList());
    }

    public void goBackToMenue(ActionEvent event) {
        new SceneController().switchToDashboard(event);
    }
}


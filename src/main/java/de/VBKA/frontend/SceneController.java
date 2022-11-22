package de.VBKA.frontend;

import de.VBKA.backend.controller.SessionController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {

    private Stage stage;
    private Scene scene;

    public int switchToAccountScene(ActionEvent event) {
        switchScene(event, "/AccountScene.fxml");
        new SessionController().setCurrentBankAccount(null);
        return 0;
    }

    public int switchToMainMenue(ActionEvent event) {
        switchScene(event, "/MainMenueScene.fxml");
        return 0;
    }

    public int switchToBankStatementUpload(ActionEvent event) {
        switchScene(event, "/MainMenueScene.fxml");
        return 0;
    }

    private int switchScene(ActionEvent event, String sceneFile) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(sceneFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        return 0;
    }
}

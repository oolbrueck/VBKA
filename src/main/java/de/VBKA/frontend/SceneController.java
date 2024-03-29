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
        return 0;
    }

    public int switchToDashboard(ActionEvent event) {
        switchScene(event, "/Dashboard.fxml");
        return 0;
    }

    public int switchToBankStatementUpload(ActionEvent event) {
        switchScene(event, "/BankStatementUploadScene.fxml");
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

    public int switchToUserScene(ActionEvent event) {
        switchScene(event, "/UserScene.fxml");
        return 0;
    }

    public int switchToCategoryAddingScene(ActionEvent event) {
        switchScene(event, "/CategoryAddingForm.fxml");
        return 0;
    }

    public int switchToCategoryScene(ActionEvent event) {
        switchScene(event, "/CategoryOverviewScene.fxml");
        return 0;
    }
}

package de.VBKA.frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenueSceneController {

    public int switchToAccountScene(ActionEvent event) {
        new SceneController().switchToAccountScene(event);

        return 0;
    }
}

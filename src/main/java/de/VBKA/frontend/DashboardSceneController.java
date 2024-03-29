package de.VBKA.frontend;

import de.VBKA.backend.controller.SessionController;
import de.VBKA.backend.entity.BankAccount;
import javafx.event.ActionEvent;

public class DashboardSceneController {

    public void goToBankStatementUpload(ActionEvent event) {
        new SceneController().switchToBankStatementUpload(event);
    }

    public void goToAccountScene(ActionEvent event) {
        new SceneController().switchToAccountScene(event);
    }

    public void goToUserScene(ActionEvent event) {
        new SceneController().switchToUserScene(event);
    }

    public void goToCategoryAdding(ActionEvent event) {
        new SceneController().switchToCategoryAddingScene(event);
    }

    public void goToCategoryOverview(ActionEvent event) { new SceneController().switchToCategoryScene(event); }
}

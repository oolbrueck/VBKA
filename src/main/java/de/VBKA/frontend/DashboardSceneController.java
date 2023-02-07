package de.VBKA.frontend;

import de.VBKA.backend.controller.SessionController;
import de.VBKA.backend.entity.BankAccount;
import javafx.event.ActionEvent;

public class DashboardSceneController {

    public void goToBankStatementUpload(ActionEvent event) {
        new SceneController().switchToBankStatementUpload(event);
    }
}

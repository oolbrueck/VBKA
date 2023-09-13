package de.VBKA.frontend;

import de.VBKA.backend.controller.ImportBankStatementController;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;

import java.io.File;

public class BankStatementUploadSceneController {

    public int uploadFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        var  controller = new ImportBankStatementController();
        controller.importBankStatement(file);
        return 0;
    }

    public int goBackToMenue(ActionEvent event) {
        new SceneController().switchToDashboard(event);
        return 0;
    }
}

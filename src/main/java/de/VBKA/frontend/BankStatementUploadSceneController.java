package de.VBKA.frontend;

import de.VBKA.backend.controller.bankStatementParser.bookingParserImpl.VolksbankParser;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class BankStatementUploadSceneController {

    public int uploadFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        try {
            new VolksbankParser().parseBookings(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public int goBackToMenue(ActionEvent event) {
        new SceneController().switchToDashboard(event);
        return 0;
    }
}

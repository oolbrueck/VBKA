package de.VBKA.frontend;

import de.VBKA.backend.controller.BookingParseController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;

import javax.swing.plaf.FileChooserUI;
import java.io.File;
import java.io.IOException;

public class BankStatementUploadSceneController {

    public int uploadFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        try {
            new BookingParseController().parseBookings(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public int goBackToMenue(ActionEvent event) {
        new SceneController().switchToMainMenue(event);
        return 0;
    }
}

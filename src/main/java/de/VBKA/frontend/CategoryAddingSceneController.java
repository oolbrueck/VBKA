/**
 * Author: Oliver Olbrück
 */

package de.VBKA.frontend;

import de.VBKA.backend.dao.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

import java.util.stream.Collectors;

public class CategoryAddingSceneController {

    @FXML
    private FlowPane chipContainer;

    @FXML
    private TextField inputKeyWord;

    @FXML
    private TextField inputKeyWordName;

    public int addKeyWord(ActionEvent event) {
        String keyWord = inputKeyWord.getText();
        inputKeyWord.clear();

        Button keyWordButton = new Button(keyWord);
        keyWordButton.setOnAction(clickEvent -> {
            chipContainer.getChildren().remove(keyWordButton);
        });
        var normalButtonStyle = keyWordButton.getStyle();
        keyWordButton.setOnMouseEntered(mouseEvent -> {
            keyWordButton.setStyle("-fx-background-color: red;");
        });
        keyWordButton.setOnMouseExited(mouseEvent -> {
            keyWordButton.setStyle(normalButtonStyle);
        });

        chipContainer.getChildren().add(keyWordButton);
        return 0;
    }

    public int save(ActionEvent event) {
        var keyWordName = inputKeyWordName.getText();
        var keyWords = chipContainer.getChildren().stream().map(node -> ((Button) node.lookup(".button")).getText()).toList();
        System.out.println("name: " + keyWordName + " keyWords: " + keyWords);
        (new UserDAO()).insertKeyWords(keyWordName, keyWords);

        chipContainer.getChildren().clear();
        inputKeyWordName.clear();
        inputKeyWord.clear();
        return 0;
    }

    public int backToMenu(ActionEvent event) {
        new SceneController().switchToDashboard(event);
        return 0;
    }
}
